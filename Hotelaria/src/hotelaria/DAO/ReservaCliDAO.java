package hotelaria.DAO;

import hotelaria.jdbc.ConnectionFactory;
import hotelaria.model.Reserva;
import hotelaria.model.ReservaCli;
import hotelaria.util.DateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Norton Wagner Martins  
 * @date 18/11/2018
 */
public class ReservaCliDAO implements GenericDAO<ReservaCli>{
    private Connection connection = null;

    @Override
    public void save(ReservaCli entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getConnection();
            this.connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();           
            sql.append("INSERT INTO RESERVA_CLI (ID, ID_RESERVA, ID_CLIENTE)");
                sql.append(" VALUES (?, ?, ?)");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setInt(2, entity.getReserva().getCodigo());
            pstm.setInt(3, entity.getCliente().getCodigo());
            
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao INSERIR o RESERVA DE CLIENTE.");
            ex.printStackTrace();
        } finally {
            this.connection.commit();
            //connection.close();
        }
    }


    @Override
    public void update(ReservaCli entity) throws SQLException {
        //DELETE E INSERT DO ReservaDAO;
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            this.connection = ConnectionFactory.getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM RESERVA_CLI WHERE ID_RESERVA = " + id);
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao DELETAR RESERVA_CLI");
            ex.printStackTrace();
        } finally {
            this.connection.commit();
            //this.connection.close();
        }
    }

    @Override
    public ReservaCli getById(int id) throws SQLException {
        ClienteDAO cliDAO = null;
        ReservaDAO reservaDAO =  null;
        ReservaCli reservaCli = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT R.ID ,R.ID_RESERVA, R.ID_CLIENTE");
                sql.append(" FROM RESERVA_CLI AS R");
                sql.append(" WHERE R.ID = " + id);
                
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {            
                reservaCli = new ReservaCli();
                reservaCli.setCodigo(rs.getInt("ID"));
                reservaDAO = new ReservaDAO();
                reservaDAO.getById(rs.getInt("ID_RESERVA"));
                cliDAO = new ClienteDAO();
                cliDAO.getById(rs.getInt("ID_CLIENTE"));
               
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR RESERVA DE CLIENTE por ID");
            ex.printStackTrace();
        } finally {
            //this.connection.close();
        }
        return reservaCli;
    }

    @Override
    public List<ReservaCli> getByName(String name) throws SQLException {
        return null;
        //por STATUS da RESERVA = ReservaDAO.getByName
    }

    @Override
    public List<ReservaCli> getAll() throws SQLException {
        ClienteDAO cliDAO = null;
        ReservaDAO reservaDAO =  null;
        ReservaCli reservaCli = null;
        List<ReservaCli> reservaCliList = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT R.ID ,R.ID_RESERVA, R.ID_CLIENTE");
                sql.append(" FROM RESERVA_CLI AS R");
                
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            reservaCliList = new ArrayList<>();
            while (rs.next()) {            
                reservaCli = new ReservaCli();
                reservaCli.setCodigo(rs.getInt("ID"));
                reservaDAO = new ReservaDAO();
                reservaDAO.getById(rs.getInt("ID_RESERVA"));
                cliDAO = new ClienteDAO();
                cliDAO.getById(rs.getInt("ID_CLIENTE"));
                reservaCliList.add(reservaCli);
               
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR TODOS AS RESERVAS DE CLIENTE");
            ex.printStackTrace();
        } finally {
            //this.connection.close();
        }
        return reservaCliList;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT COALESCE(MAX(R.ID),0)+1 AS MAIOR FROM RESERVA_CLI AS R ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("MAIOR");
            }

        } catch (SQLException ex) {
            System.out.println("Erro SELECIONAR maior ID de Reserva");
            ex.printStackTrace();
        } finally {
            pstm.close();
            //this.connection.close();
        }          
        return 1;
    }

}
