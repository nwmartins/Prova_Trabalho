package agendamento.DAO;

import agendamento.jdbc.ConnectionFactory;
import agendamento.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Norton Wagner Martins  
 * @date 21/11/2018
 */
public class FuncionarioDAO implements GenericDAO<Funcionario>{
    
    private Connection connection = null;

    @Override
    public void save(Funcionario entity) throws SQLException {
    try {
            this.connection = ConnectionFactory.getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO FUNCIONARIO (CD_FUNCIONARIO, NM_FUNCIONARIO, NR_MATRICULA)")
                    .append(" VALUES(?,UPPER(?),?)");
            
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getNome());
            pstm.setInt(3, entity.getNumMatricula());
                  
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao INSERIR Funcionario.");
            ex.printStackTrace();
        } finally {
            this.connection.commit();
            //connection.close();
        }
    }

    @Override
    public void update(Funcionario entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE FUNCIONARIO SET NM_FUNCIONARIO = UPPER(?), NR_MATRICULA = ?")
                    .append(" WHERE CD_FUNCIONARIO = ?");
            
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, entity.getNome());
            pstm.setInt(2, entity.getNumMatricula());
            pstm.setInt(3, entity.getCodigo());
                  
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao ATUALIZAR FUNCIONARIO.");
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
            sql.append("DELETE FROM FUNCIONARIO WHERE CD_FUNCIONARIO = " + id);
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao DELETAR FUNCIONARIO");
            ex.printStackTrace();
        }finally {
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
            sql.append("SELECT CD_FUNCIONARIO, NM_FUNCIONARIO, NR_MATRICULA");
                sql.append(" FROM FUNCIONARIO");
                sql.append(" WHERE CD_FUNCIONARIO = " + id);
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                fun = new Funcionario();
                fun.setCodigo(rs.getInt("CD_FUNCIONARIO"));
                fun.setNome(rs.getString("NM_FUNCIONARIO"));
                fun.setNumMatricula(rs.getInt("NR_MATRICULA"));
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR FUNCIONARIO por ID");
            ex.printStackTrace();
        }finally {
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
            sql.append("SELECT CD_FUNCIONARIO, NM_FUNCIONARIO, NR_MATRICULA");
                sql.append(" FROM FUNCIONARIO");
                sql.append(" WHERE NM_FUNCIONARIO LIKE UPPER('%"+name+"%') ");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            funList = new ArrayList<>();
            while (rs.next()) {
                fun = new Funcionario();
                fun.setCodigo(rs.getInt("CD_FUNCIONARIO"));
                fun.setNome(rs.getString("NM_FUNCIONARIO"));
                fun.setNumMatricula(rs.getInt("NR_MATRICULA"));
                funList.add(fun);
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR FUNCIONARIO por NOME");
            ex.printStackTrace();
        }finally {
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
            sql.append("SELECT CD_FUNCIONARIO, NM_FUNCIONARIO, NR_MATRICULA");
                sql.append(" FROM FUNCIONARIO");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            funList = new ArrayList<>();
            while (rs.next()) {
                fun = new Funcionario();
                fun.setCodigo(rs.getInt("CD_FUNCIONARIO"));
                fun.setNome(rs.getString("NM_FUNCIONARIO"));
                fun.setNumMatricula(rs.getInt("NR_MATRICULA"));
                funList.add(fun);
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR TODOS OS FUNCIONARIOS");
            ex.printStackTrace();
        }finally {
            //this.connection.close();
        }
        return funList;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT COALESCE(MAX(CD_FUNCIONARIO),0)+1 AS MAIOR FROM FUNCIONARIO ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
                return rs.getInt("MAIOR");
              
        }catch (SQLException ex){
            System.out.println("Erro SELECIONAR maior ID de FUNCIONARIO");
            ex.printStackTrace();
        }finally {
            pstm.close();
            //this.connection.close();
        }
        return 1;
    }



}
