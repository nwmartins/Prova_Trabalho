package hotelaria.DAO;

import hotelaria.jdbc.ConnectionFactory;
import hotelaria.model.Quarto;
import hotelaria.util.DateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Norton Wagner Martins  
 * @date 17/11/2018
 */
public class QuartoDAO implements GenericDAO<Quarto> {
    private Connection connection = null;

    @Override
    public void save(Quarto entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getConnection();
            this.connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO QUARTO (ID, ANDAR, STATUS, NUM_QUARTO, DESCR, VALOR, CAP_PESSOAS)");
                sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?)");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setInt(2, entity.getAndar());
            pstm.setString(3, entity.getStatus());
            pstm.setInt(4, entity.getNumQuarto());
            pstm.setString(5, entity.getDescricao());
            pstm.setDouble(6, entity.getValor());
            pstm.setInt(7, entity.getCapPessoas());            

            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao INSERIR o QUARTO.");
            ex.printStackTrace();
        } finally {
            this.connection.commit();
            //connection.close();
        }
    }        

    @Override
    public void update(Quarto entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getConnection();
            this.connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE QUARTO SET ANDAR = ?, STATUS = ?, NUM_QUARTO = ?,");
                sql.append(" DESCR = ?, VALOR = ?, CAP_PESSOAS = ?");
                sql.append(" WHERE ID = ?");                

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getAndar());
            pstm.setString(2, entity.getStatus());
            pstm.setInt(3, entity.getNumQuarto());
            pstm.setString(4, entity.getDescricao());
            pstm.setDouble(5, Double.parseDouble(String.valueOf(entity.getValor()).replace("R$ ", "")));
            pstm.setInt(6, entity.getCapPessoas());            
            pstm.setInt(7, entity.getCodigo());            

            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao ATUALIZAR o QUARTO.");
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
            sql.append("DELETE FROM QUARTO WHERE ID = " + id);
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao DELETAR QUARTO");
            ex.printStackTrace();
        } finally {
            this.connection.commit();
            //this.connection.close();
        }        
    }

    @Override
    public Quarto getById(int id) throws SQLException {
        Quarto quarto = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT Q.ID, Q.ANDAR, Q.STATUS, Q.NUM_QUARTO, Q.DESCR, Q.VALOR, Q.CAP_PESSOAS");
            sql.append(" FROM QUARTO AS Q");
            sql.append(" WHERE Q.ID = " + id);
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {            
                quarto = new Quarto();
                quarto.setCodigo(rs.getInt("ID"));
                quarto.setAndar(rs.getInt("ANDAR"));
                quarto.setStatus(rs.getString("STATUS"));
                quarto.setNumQuarto(rs.getInt("NUM_QUARTO"));
                quarto.setDescricao(rs.getString("DESCR"));
                quarto.setValor(rs.getDouble("VALOR"));
                quarto.setCapPessoas(rs.getInt("CAP_PESSOAS"));                
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR QUARTO por ID");
            ex.printStackTrace();
        } finally {
            //this.connection.close();
        }
        return quarto;
    }

    @Override
    public List<Quarto> getByName(String name) throws SQLException {
        Quarto quarto = null;
        List<Quarto> quartoList = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT Q.ID, Q.ANDAR, Q.STATUS, Q.NUM_QUARTO, Q.DESCR, Q.VALOR, Q.CAP_PESSOAS");
            sql.append(" FROM QUARTO AS Q");
            sql.append(" WHERE Q.DESCR LIKE ('%" + name + "%') ");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            quartoList = new ArrayList<>();
            while (rs.next()) {              
                quarto = new Quarto();
                quarto.setCodigo(rs.getInt("ID"));
                quarto.setAndar(rs.getInt("ANDAR"));
                quarto.setStatus(rs.getString("STATUS"));
                quarto.setNumQuarto(rs.getInt("NUM_QUARTO"));
                quarto.setDescricao(rs.getString("DESCR"));
                quarto.setValor(rs.getDouble("VALOR"));
                quarto.setCapPessoas(rs.getInt("CAP_PESSOAS")); 
                quartoList.add(quarto);
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR QUARTO por DESCRIÇÃO");
            ex.printStackTrace();
        } finally {
            //this.connection.close();
        }
        return quartoList;
    }

    @Override
    public List<Quarto> getAll() throws SQLException {
        Quarto quarto = null;
        List<Quarto> quartoList = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT Q.ID, Q.ANDAR, Q.STATUS, Q.NUM_QUARTO, Q.DESCR, Q.VALOR, Q.CAP_PESSOAS");
            sql.append(" FROM QUARTO AS Q");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            quartoList = new ArrayList<>();
            while (rs.next()) {              
                quarto = new Quarto();
                quarto.setCodigo(rs.getInt("ID"));
                quarto.setAndar(rs.getInt("ANDAR"));
                quarto.setStatus(rs.getString("STATUS"));
                quarto.setNumQuarto(rs.getInt("NUM_QUARTO"));
                quarto.setDescricao(rs.getString("DESCR"));
                quarto.setValor(rs.getDouble("VALOR"));
                quarto.setCapPessoas(rs.getInt("CAP_PESSOAS")); 
                quartoList.add(quarto);
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR QUARTO por DESCRIÇÃO");
            ex.printStackTrace();
        } finally {
            //this.connection.close();
        }
        return quartoList;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT COALESCE(MAX(Q.ID),0)+1 AS MAIOR FROM QUARTO AS Q ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("MAIOR");
            }

        } catch (SQLException ex) {
            System.out.println("Erro SELECIONAR maior ID de QUARTO");
            ex.printStackTrace();
        } finally {
            pstm.close();
            //this.connection.close();
        }     
        return 1;
    }
    
}
