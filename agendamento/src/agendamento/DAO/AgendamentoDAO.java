package agendamento.DAO;

import agendamento.jdbc.ConnectionFactory;
import agendamento.model.Agendamento;
import agendamento.util.DateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Norton Wagner Martins  
 * @date 24/11/2018
 */
public class AgendamentoDAO implements GenericDAO<Agendamento>{
    
    private Connection connection = null;

    @Override
    public void save(Agendamento entity) throws SQLException {
    try {
            this.connection = ConnectionFactory.getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder(); 
            String dtSaida = DateUtil.dateToString(entity.getDtSaida()).replace("/", "-");
            String dtRetorno = DateUtil.dateToString(entity.getDtRetorno()).replace("/", "-");
            sql.append("INSERT INTO AGENDAMENTO (CD_AGENDAMENTO, CD_VEICULO, DS_ORIGEM, DS_DESTINO,")
                    .append(" CD_MOTORISTA, CD_FUNCIONARIO, DT_SAIDA, DT_RETORNO, NR_PASSAGEIROS, DS_OBSERVACAO)")
                    .append(" VALUES(?,?,?,UPPER(?),?,?,'" + dtSaida + "', '" + dtRetorno + "',?,?)");
            
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setInt(2, entity.getVeiculo().getCodigo());
            pstm.setString(3, entity.getOrigem());
            pstm.setString(4, entity.getDestino());
            pstm.setInt(5, entity.getMotorista().getCodigo());
            pstm.setInt(6, entity.getMotorista().getFuncionario().getCodigo());
            pstm.setInt(7, entity.getNumPassageiros());
            pstm.setString(8, entity.getObs());
                  
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao INSERIR AGENDAMENTO.");
            ex.printStackTrace();
        } finally {
            this.connection.commit();
        }
    }

    @Override
    public void update(Agendamento entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            String dtSaida = DateUtil.dateToString(entity.getDtSaida()).replace("/", "-");
            String dtRetorno = DateUtil.dateToString(entity.getDtRetorno()).replace("/", "-");            
            sql.append("UPDATE AGENDAMENTO SET CD_VEICULO = ?, DS_ORIGEM = ?, DS_DESTINO = UPPER(?), CD_MOTORISTA = ?,")
                    .append(" CD_FUNCIONARIO = ?, DT_SAIDA = '" + dtSaida + "', DT_RETORNO = '" + dtRetorno + "',")
                    .append(" NR_PASSAGEIROS = ?, DS_OBSERVACAO = ?")
                    .append(" WHERE CD_AGENDAMENTO = ?");
            
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getVeiculo().getCodigo());
            pstm.setString(2, entity.getOrigem());
            pstm.setString(3, entity.getDestino());
            pstm.setInt(4, entity.getMotorista().getCodigo());
            pstm.setInt(5, entity.getMotorista().getFuncionario().getCodigo());
            pstm.setInt(6, entity.getNumPassageiros());
            pstm.setString(7, entity.getObs());
            pstm.setInt(8, entity.getCodigo());            
                  
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao ATUALIZAR AGENDAMENTO.");
            ex.printStackTrace();
        } finally {
            this.connection.commit();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            this.connection = ConnectionFactory.getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM AGENDAMENTO WHERE CD_AGENDAMENTO = " + id);
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao DELETAR AGENDAMENTO");
            ex.printStackTrace();
        }finally {
            this.connection.commit();
        }
    }

    @Override
    public Agendamento getById(int id) throws SQLException {
        Agendamento agend = null;
        MotoristaDAO motDAO = null;
        VeiculoDAO veicDAO = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT CD_AGENDAMENTO, CD_VEICULO, DS_ORIGEM, DS_DESTINO,")
                    .append(" CD_MOTORISTA, CD_FUNCIONARIO, DT_SAIDA, DT_RETORNO, NR_PASSAGEIROS, DS_OBSERVACAO")
                    .append(" FROM AGENDAMENTO")
                    .append(" WHERE CD_AGENDAMENTO = " + id);
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                agend = new Agendamento();
                agend.setCodigo(rs.getInt("CD_AGENDAMENTO"));
                veicDAO = new VeiculoDAO();
                agend.setVeiculo(veicDAO.getById(rs.getInt("CD_VEICULO")));
                agend.setOrigem(rs.getString("DS_ORIGEM"));
                agend.setDestino(rs.getString("DS_DESTINO"));
                motDAO = new MotoristaDAO();
                agend.setMotorista(motDAO.getById(rs.getInt("CD_MOTORISTA")));
                agend.setDtSaida(rs.getDate("DT_SAIDA"));
                agend.setDtRetorno(rs.getDate("DT_RETORNO"));
                agend.setNumPassageiros(rs.getInt("NR_PASSAGEIROS"));
                agend.setObs(rs.getString("DS_OBSERVACAO"));
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR AGENDAMENTO por ID");
            ex.printStackTrace();
        }finally {            
        }
        return agend;
    }

    @Override
    public List<Agendamento> getByName(String name) throws SQLException {
        Agendamento agend = null;
        MotoristaDAO motDAO = null;
        VeiculoDAO veicDAO = null;
        List<Agendamento> agendList = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT CD_AGENDAMENTO, CD_VEICULO, DS_ORIGEM, DS_DESTINO,")
                    .append(" CD_MOTORISTA, CD_FUNCIONARIO, DT_SAIDA, DT_RETORNO, NR_PASSAGEIROS, DS_OBSERVACAO")
                    .append(" FROM AGENDAMENTO")
                    .append(" WHERE DS_DESTINO LIKE UPPER('%"+name+"%') ");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            agendList = new ArrayList<>();
            while (rs.next()) {
                agend = new Agendamento();
                agend.setCodigo(rs.getInt("CD_AGENDAMENTO"));
                veicDAO = new VeiculoDAO();
                agend.setVeiculo(veicDAO.getById(rs.getInt("CD_VEICULO")));
                agend.setOrigem(rs.getString("DS_ORIGEM"));
                agend.setDestino(rs.getString("DS_DESTINO"));
                motDAO = new MotoristaDAO();
                agend.setMotorista(motDAO.getById(rs.getInt("CD_MOTORISTA")));
                agend.setDtSaida(rs.getDate("DT_SAIDA"));
                agend.setDtRetorno(rs.getDate("DT_RETORNO"));
                agend.setNumPassageiros(rs.getInt("NR_PASSAGEIROS"));
                agend.setObs(rs.getString("DS_OBSERVACAO"));
                agendList.add(agend);
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR AGENDAMENTO por ID");
            ex.printStackTrace();
        }finally {            
        }
        return agendList;
    }

    @Override
    public List<Agendamento> getAll() throws SQLException {
        Agendamento agend = null;
        MotoristaDAO motDAO = null;
        VeiculoDAO veicDAO = null;
        List<Agendamento> agendList = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT CD_AGENDAMENTO, CD_VEICULO, DS_ORIGEM, DS_DESTINO,")
                    .append(" CD_MOTORISTA, CD_FUNCIONARIO, DT_SAIDA, DT_RETORNO, NR_PASSAGEIROS, DS_OBSERVACAO")
                    .append(" FROM AGENDAMENTO");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            agendList = new ArrayList<>();
            while (rs.next()) {
                agend = new Agendamento();
                agend.setCodigo(rs.getInt("CD_AGENDAMENTO"));
                veicDAO = new VeiculoDAO();
                agend.setVeiculo(veicDAO.getById(rs.getInt("CD_VEICULO")));
                agend.setOrigem(rs.getString("DS_ORIGEM"));
                agend.setDestino(rs.getString("DS_DESTINO"));
                motDAO = new MotoristaDAO();
                agend.setMotorista(motDAO.getById(rs.getInt("CD_MOTORISTA")));
                agend.setDtSaida(rs.getDate("DT_SAIDA"));
                agend.setDtRetorno(rs.getDate("DT_RETORNO"));
                agend.setNumPassageiros(rs.getInt("NR_PASSAGEIROS"));
                agend.setObs(rs.getString("DS_OBSERVACAO"));
                agendList.add(agend);
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR TODOS OS AGENDAMENTO");
            ex.printStackTrace();
        }finally {            
        }
        return agendList;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT COALESCE(MAX(CD_AGENDAMENTO),0)+1 AS MAIOR FROM AGENDAMENTO ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
                return rs.getInt("MAIOR");
              
        }catch (SQLException ex){
            System.out.println("Erro SELECIONAR maior ID de AGENDAMENTO");
            ex.printStackTrace();
        }finally {
            pstm.close();
        }
        return 1;
    }
}
