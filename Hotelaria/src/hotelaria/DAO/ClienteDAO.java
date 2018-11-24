package hotelaria.DAO;

import hotelaria.jdbc.ConnectionFactory;
import hotelaria.model.Cliente;
import hotelaria.model.PessoaFisica;
import hotelaria.model.Sexo;
import hotelaria.util.DateUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Norton Wagner Martins
 * @date 15/11/2018
 */
public class ClienteDAO implements GenericDAO<Cliente> {

    private Connection connection = null;

    @Override
    public void save(Cliente entity) throws SQLException {
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
            String data = DateUtil.dateToString(entity.getDtCadastro()).replace("/", "-");
            //data.replace("/", "-");
            sql.append("INSERT INTO CLIENTE (ID, DT_CAD) (VALUES (?,'" + data + "'))");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, pf.getCodigo());

            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao INSERIR ao CLIENTE.");
            ex.printStackTrace();
        } finally {
            this.connection.commit();
            //connection.close();
        }
    }

    @Override
    public void update(Cliente entity) throws SQLException {
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

        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao ATUALIZAR o CLIENTE.");
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
            sql.append("DELETE FROM CLIENTE WHERE ID = " + id);
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao DELETAR Cliente");
            ex.printStackTrace();
        } finally {
            this.connection.commit();
            //this.connection.close();
        }
    }

    @Override
    public Cliente getById(int id) throws SQLException {
        Cliente cli = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT PF.ID, PF.CPF, PF.RG, PF.SEXO, PF.NM, C.DT_CAD");
            sql.append(" FROM PESSOA_FISICA AS PF");
            sql.append(" INNER JOIN CLIENTE AS C ON (PF.ID = C.ID)");
            sql.append(" WHERE PF.ID = " + id);
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {            
                cli = new Cliente();
                cli.setCodigo(rs.getInt("ID"));
                cli.setCpf(rs.getString("CPF"));
                cli.setRg(rs.getString("RG"));
                cli.setNome(rs.getString("NM"));
                cli.setSexo(rs.getString("SEXO"));
                cli.setDtCadastro(rs.getDate("DT_CAD"));
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR Cliente por ID");
            ex.printStackTrace();
        } finally {
            //this.connection.close();
        }
        return cli;
    }

    @Override
    public List<Cliente> getByName(String name) throws SQLException {
        Cliente cli = null;
        List<Cliente> cliList = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT PF.ID, PF.CPF, PF.RG, PF.SEXO, PF.NM, C.DT_CAD");
            sql.append(" FROM PESSOA_FISICA AS PF");
            sql.append(" INNER JOIN CLIENTE AS C ON (PF.ID = C.ID)");
            sql.append(" WHERE PF.NM LIKE ('%" + name + "%') ");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            cliList = new ArrayList<>();
            while (rs.next()) {
                //Sexo sexo = null; // PRA PODER DEFINIR UM SEXO PQ É ENUM               
                cli = new Cliente();
                cli.setCodigo(rs.getInt("ID"));
                cli.setCpf(rs.getString("CPF"));
                cli.setRg(rs.getString("RG"));
                cli.setNome(rs.getString("NM"));
                //sexo.setSexo(rs.getInt("SEXO")); //PRIMEIRO DEFINO SEXO
                //cli.setSexo(sexo); //ATRIBUO A Cli
                cli.setSexo(rs.getString("SEXO"));
                cli.setDtCadastro(rs.getDate("DT_CAD"));
                cliList.add(cli);
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR Cliente por NOME");
            ex.printStackTrace();
        } finally {
            //this.connection.close();
        }
        return cliList;
    }

    @Override
    public List<Cliente> getAll() throws SQLException {
        Cliente cli = null;
        List<Cliente> cliList = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT PF.ID, PF.CPF, PF.RG, PF.SEXO, PF.NM, C.DT_CAD");
            sql.append(" FROM PESSOA_FISICA AS PF");
            sql.append(" INNER JOIN CLIENTE AS C ON (PF.ID = C.ID)");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            cliList = new ArrayList<>();
            while (rs.next()) {
                cli = new Cliente();
                Sexo sexo = null; // PRA PODER DEFINIR UM SEXO PQ É ENUM               
                cli.setCodigo(rs.getInt("ID"));
                cli.setCpf(rs.getString("CPF"));
                cli.setRg(rs.getString("RG"));
                cli.setNome(rs.getString("NM"));
                cli.setSexo(rs.getString("SEXO")); //ATRIBUO A PF
                cli.setDtCadastro(rs.getDate("DT_CAD"));
                cliList.add(cli);
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR TODOS os Clientes");
            ex.printStackTrace();
        } finally {
            //this.connection.close();
        }
        return cliList;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT COALESCE(MAX(C.ID),0)+1 AS MAIOR FROM CLIENTE AS C ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("MAIOR");
            }

        } catch (SQLException ex) {
            System.out.println("Erro SELECIONAR maior ID de Cliente");
            ex.printStackTrace();
        } finally {
            pstm.close();
            //this.connection.close();
        }   
        return 1;
    }

}
