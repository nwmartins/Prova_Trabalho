package hotelaria.DAO;

import hotelaria.jdbc.ConnectionFactory;
import hotelaria.model.Funcionario;
import hotelaria.model.PessoaFisica;
import hotelaria.util.DateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Norton Wagner Martins  
 * @date 15/11/2018
 */
public class FuncionarioDAO implements GenericDAO<Funcionario>{
     private Connection connection = null;

    @Override
    public void save(Funcionario entity) throws SQLException {
        try {
            PessoaFisica pf = new PessoaFisica() {};
            PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();

            //JÁ FIZ SALVAR O PESSOA_FISICA AQUI NO DAO
            pf = new PessoaFisica() {};
            pf.setCodigo(entity.getCodigo());
            pf.setCpf(entity.getCpf());
            pf.setNome(entity.getNome());
            pf.setRg(entity.getRg());
            pf.setSexo(entity.getSexo());

            pfDAO = new PessoaFisicaDAO();
            pfDAO.save(pf);

            this.connection = ConnectionFactory.getConnection();
            this.connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            String data = DateUtil.dateToString(entity.getDtContratacao()).replace("/", "-");
            //data.replace("/", "-");
            sql.append("INSERT INTO FUNCIONARIO (ID, DT_CONTRATACAO, SALARIO) (VALUES (?,'" + data + "', ?))");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, pf.getCodigo());
            pstm.setDouble(2, entity.getSalario());

            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao INSERIR ao FUNCIONARIO.");
            ex.printStackTrace();
        } finally {
            this.connection.commit();
            //connection.close();
        }
    }

    @Override
    public void update(Funcionario entity) throws SQLException {
        PessoaFisica pf = null;
        PessoaFisicaDAO pfDAO = null;
        try {
            pf = new PessoaFisica() {};
            pf.setCodigo(entity.getCodigo());
            pf.setCpf(entity.getCpf());
            pf.setNome(entity.getNome());
            pf.setRg(entity.getRg());
            pf.setSexo(entity.getSexo());

            pfDAO = new PessoaFisicaDAO();
            pfDAO.update(pf);
            
            this.connection = ConnectionFactory.getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE FUNCIONARIO SET SALARIO = ?")
                    .append(" WHERE ID = ?");
            
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setDouble(1, entity.getSalario());            
            pstm.setInt(2, entity.getCodigo());
            
            pstm.execute();
            pstm.close();

        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao ATUALIZAR o FUNCIONARIO.");
            ex.printStackTrace();
        } finally {
            this.connection.commit();
            //connection.close();
        }

    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            this.connection = ConnectionFactory.getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM FUNCIONARIO WHERE ID = " + id);
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao DELETAR Funcionario");
            ex.printStackTrace();
        } finally {
            this.connection.commit();
            //this.connection.close();
        }
    }

    @Override
    public Funcionario getById(int id) throws SQLException {
        Funcionario fun = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT PF.ID, PF.CPF, PF.RG, PF.SEXO, PF.NM, DT_CONTRATACAO, F.SALARIO");
            sql.append(" FROM PESSOA_FISICA AS PF");
            sql.append(" INNER JOIN FUNCIONARIO AS F ON (PF.ID = F.ID)");
            sql.append(" WHERE PF.ID = " + id);
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {            
                fun = new Funcionario();
                fun.setCodigo(rs.getInt("ID"));
                fun.setCpf(rs.getString("CPF"));
                fun.setRg(rs.getString("RG"));
                fun.setNome(rs.getString("NM"));
                fun.setSexo(rs.getString("SEXO"));
                fun.setDtContratacao(rs.getDate("DT_CONTRATACAO"));
                fun.setSalario(rs.getDouble("SALARIO"));
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR Funcionario por ID");
            ex.printStackTrace();
        } finally {
            //this.connection.close();
        }
        return fun;
    }

    @Override
    public List<Funcionario> getByName(String name) throws SQLException {
        Funcionario fun = null;
        List<Funcionario> funList = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT PF.ID, PF.CPF, PF.RG, PF.SEXO, PF.NM, DT_CONTRATACAO, F.SALARIO");
            sql.append(" FROM PESSOA_FISICA AS PF");
            sql.append(" INNER JOIN FUNCIONARIO AS F ON (PF.ID = F.ID)");
            sql.append(" WHERE PF.NM LIKE ('%" + name + "%') ");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            funList = new ArrayList<>();
            while (rs.next()) {
                //Sexo sexo = null; // PRA PODER DEFINIR UM SEXO PQ É ENUM               
                fun = new Funcionario();
                fun.setCodigo(rs.getInt("ID"));
                fun.setCpf(rs.getString("CPF"));
                fun.setRg(rs.getString("RG"));
                fun.setNome(rs.getString("NM"));
                //sexo.setSexo(rs.getInt("SEXO")); //PRIMEIRO DEFINO SEXO
                //cli.setSexo(sexo); //ATRIBUO A Cli
                fun.setSexo(rs.getString("SEXO"));
                fun.setDtContratacao(rs.getDate("DT_CONTRATACAO"));
                fun.setSalario(rs.getDouble("SALARIO"));
                funList.add(fun);
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR Funcionario por NOME");
            ex.printStackTrace();
        } finally {
            //this.connection.close();
        }
        return funList;
    }

    @Override
    public List<Funcionario> getAll() throws SQLException {
        Funcionario fun = null;
        List<Funcionario> funList = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT PF.ID, PF.CPF, PF.RG, PF.SEXO, PF.NM, DT_CONTRATACAO, F.SALARIO");
            sql.append(" FROM PESSOA_FISICA AS PF");
            sql.append(" INNER JOIN FUNCIONARIO AS F ON (PF.ID = F.ID)");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            funList = new ArrayList<>();
            while (rs.next()) {
                fun = new Funcionario();           
                fun.setCodigo(rs.getInt("ID"));
                fun.setCpf(rs.getString("CPF"));
                fun.setRg(rs.getString("RG"));
                fun.setNome(rs.getString("NM"));
                fun.setSexo(rs.getString("SEXO")); //ATRIBUO A PF
                fun.setDtContratacao(rs.getDate("DT_CONTRATACAO"));
                fun.setSalario(rs.getDouble("SALARIO"));
                funList.add(fun);
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR TODOS os Funcionarios");
            ex.printStackTrace();
        } finally {
            //this.connection.close();
        }
        return funList;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT COALESCE(MAX(F.ID),0)+1 AS MAIOR FROM FUNCIONARIO AS F ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("MAIOR");
            }

        } catch (SQLException ex) {
            System.out.println("Erro SELECIONAR maior ID de Funcionario");
            ex.printStackTrace();
        } finally {
            pstm.close();
            //this.connection.close();
        }          
        return 1;
    }
    
    public List<Funcionario> getAllFunc() throws SQLException {
        Funcionario fun = null;
        List<Funcionario> funList = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT PF.ID, PF.CPF, PF.RG, PF.SEXO, PF.NM, DT_CONTRATACAO, F.SALARIO");
            sql.append(" FROM PESSOA_FISICA AS PF");
            sql.append(" INNER JOIN FUNCIONARIO AS F ON (PF.ID = F.ID)");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            funList = new ArrayList<>();
            while (rs.next()) {
                fun = new Funcionario();           
                fun.setCodigo(rs.getInt("ID"));
                fun.setCpf(rs.getString("CPF"));
                fun.setRg(rs.getString("RG"));
                fun.setNome(rs.getString("NM"));
                fun.setSexo(rs.getString("SEXO")); //ATRIBUO A PF
                fun.setDtContratacao(rs.getDate("DT_CONTRATACAO"));
                fun.setSalario(rs.getDouble("SALARIO"));
                funList.add(fun);
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR TODOS os Clientes");
            ex.printStackTrace();
        } finally {
            //this.connection.close();
        }
        return funList;
    }

}
