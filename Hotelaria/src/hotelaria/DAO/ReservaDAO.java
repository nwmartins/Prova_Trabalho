package hotelaria.DAO;

import hotelaria.jdbc.ConnectionFactory;
import hotelaria.model.Cliente;
import hotelaria.model.Reserva;
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
public class ReservaDAO implements GenericDAO<Reserva>{
    private Connection connection = null;

    @Override
    public void save(Reserva entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getConnection();
            this.connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            String data = DateUtil.dateToString(entity.getDtEntrada()).replace("/", "-");
            String data2 = DateUtil.dateToString(entity.getDtReserva()).replace("/", "-");            
            sql.append("INSERT INTO RESERVA (ID, ID_QUARTO, ID_FUNC,");
                sql.append(" STATUS, DT_RESERVA, DT_ENTRADA, QTD_DIAS)");
                sql.append(" VALUES (?, ?, ?, ?, '" + data + "', '" + data2 + "', ?)");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setInt(2, entity.getQuarto().getCodigo());
            pstm.setInt(3, entity.getFuncionario().getCodigo());
            pstm.setString(4, entity.getStatus());
            pstm.setInt(5, entity.getQtdDias());

            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao INSERIR o RESERVA.");
            ex.printStackTrace();
        } finally {
            this.connection.commit();
            //connection.close();
        }
    }

    @Override
    public void update(Reserva entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getConnection();
            this.connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            String data = DateUtil.dateToString(entity.getDtEntrada()).replace("/", "-");
            sql.append("UPDATE QUARTO SET ID_QUARTO = ?, ID_FUNC, STATUS = ?,");
                sql.append(" QTD_DIAS = ?, DT_ENTRADA = '" + data + "'");
                sql.append(" WHERE ID = ?");                

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getQuarto().getCodigo());
            pstm.setInt(2, entity.getFuncionario().getCodigo());
            pstm.setString(3, entity.getStatus());
            pstm.setInt(4, entity.getQtdDias());
            pstm.setInt(5, entity.getCodigo());

            pstm.execute();
            pstm.close();

        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao ATUALIZAR o RESERVA.");
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
            sql.append("DELETE FROM RESERVA WHERE ID = " + id);
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao DELETAR RESERVA");
            ex.printStackTrace();
        } finally {
            this.connection.commit();
            //this.connection.close();
        }
    }

    @Override
    public Reserva getById(int id) throws SQLException {
        List<Cliente> cliList = new ArrayList<>();
        FuncionarioDAO funDAO = null;
        QuartoDAO quartoDAO = null;
        Reserva reserva =  null;
        Cliente cliente = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT R.ID, R.ID_QUARTO, R.ID_FUNC, R.STATUS, R.DT_RESERVA,");
                sql.append(" R.QTD_DIAS, R.DT_ENTRADA");
                sql.append(" FROM RESERVA AS R");
                sql.append(" WHERE R.ID = " + id);
                
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {            
                reserva = new Reserva();
                reserva.setCodigo(rs.getInt("ID"));
                quartoDAO = new QuartoDAO();
                reserva.setQuarto(quartoDAO.getById(rs.getInt("ID_QUARTO")));
                funDAO = new FuncionarioDAO();
                reserva.setFuncionario(funDAO.getById(rs.getInt("ID_FUNC")));
                reserva.setStatus(rs.getString("STATUS"));
                reserva.setDtReserva(rs.getDate("DT_RESERVA"));
                reserva.setQtdDias(rs.getInt("QTD_DIAS"));
                reserva.setDtEntrada(rs.getDate("DT_ENTRADA"));
               
            }
            pstm.close();
            
            sql = new StringBuilder();
            sql.append("SELECT P.ID, P.CPF, P.RG, P.SEXO, P.NM, C.DT_CAD, R.ID_RESERVA");
                sql.append(" FROM RESERVA_CLI AS R");
                sql.append(" INNER JOIN CLIENTE AS C ON (C.ID = R.ID_CLIENTE)");
                sql.append(" INNER JOIN PESSOA_FISICA AS P ON (C.ID = P.ID)");
                sql.append(" WHERE ID_RESERVA = " + id);
            
            pstm = connection.prepareStatement(sql.toString());
            rs = pstm.executeQuery();                
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCodigo(rs.getInt("ID"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setDtCadastro(rs.getDate("DT_CAD"));
                cliente.setNome(rs.getString("NM"));
                cliente.setRg(rs.getString("RG"));
                cliente.setSexo(rs.getString("SEXO"));
                cliList.add(cliente);
            }
            reserva.setClilist(cliList);
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR RESERVA por ID");
            ex.printStackTrace();
        } finally {
            //this.connection.close();
        }
        return reserva;
    }

    @Override
    public List<Reserva> getByName(String name) throws SQLException {
        FuncionarioDAO funDAO = null;
        QuartoDAO quartoDAO = null;
        Reserva reserva =  null;
        List<Reserva> reList = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT R.ID, R.ID_QUARTO, R.ID_FUNC, R.STATUS, R.DT_RESERVA,");
                sql.append(" R.QTD_DIAS, R.DT_ENTRADA");
                sql.append(" FROM RESERVA AS R");
                sql.append(" WHERE R.STATUS LIKE UPPER('%" + name + "%') ");
                
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            reList = new ArrayList<>();
            while (rs.next()) {            
                reserva = new Reserva();
                reserva.setCodigo(rs.getInt("ID"));
                quartoDAO = new QuartoDAO();
                quartoDAO.getById(rs.getInt("ID_QUARTO"));
                funDAO = new FuncionarioDAO();
                funDAO.getById(rs.getInt("ID_FUNC"));
                reserva.setStatus(rs.getString("STATUS"));
                reserva.setDtReserva(rs.getDate("DT_RESERVA"));
                reserva.setQtdDias(rs.getInt("QTD_DIAS"));
                reserva.setDtEntrada(rs.getDate("DT_ENTRADA"));
                reList.add(reserva);
               
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR RESERVA por ID");
            ex.printStackTrace();
        } finally {
            //this.connection.close();
        }
        return reList;
    }

    @Override
    public List<Reserva> getAll() throws SQLException {
        FuncionarioDAO funDAO = null;
        QuartoDAO quartoDAO = null;
        Reserva reserva =  null;
        List<Reserva> reList = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT R.ID, R.ID_QUARTO, R.ID_FUNC, R.STATUS, R.DT_RESERVA,");
                sql.append(" R.QTD_DIAS, R.DT_ENTRADA");
                sql.append(" FROM RESERVA AS R");
                
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            reList = new ArrayList<>();
            while (rs.next()) {            
                reserva = new Reserva();
                reserva.setCodigo(rs.getInt("ID"));
                quartoDAO = new QuartoDAO();
                quartoDAO.getById(rs.getInt("ID_QUARTO"));
                funDAO = new FuncionarioDAO();
                funDAO.getById(rs.getInt("ID_FUNC"));
                reserva.setStatus(rs.getString("STATUS"));
                reserva.setDtReserva(rs.getDate("DT_RESERVA"));
                reserva.setQtdDias(rs.getInt("QTD_DIAS"));
                reserva.setDtEntrada(rs.getDate("DT_ENTRADA"));
                reList.add(reserva);
               
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR RESERVA por ID");
            ex.printStackTrace();
        } finally {
            //this.connection.close();
        }
        return reList;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT COALESCE(MAX(R.ID),0)+1 AS MAIOR FROM RESERVA AS R ";
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
