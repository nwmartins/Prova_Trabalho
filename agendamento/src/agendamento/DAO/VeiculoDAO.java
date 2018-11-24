package agendamento.DAO;

import agendamento.jdbc.ConnectionFactory;
import agendamento.model.Veiculo;
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
public class VeiculoDAO implements GenericDAO<Veiculo>{
    
    private Connection connection = null;

    @Override
    public void save(Veiculo entity) throws SQLException {
    try {
            this.connection = ConnectionFactory.getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();      
            sql.append("INSERT INTO VEICULO (CD_VEICULO, NR_PLACA, NR_ANO, NR_PASSAGEIROS)")
                    .append(" VALUES(?,?,?,?)");
            
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getPlaca());
            pstm.setInt(3, entity.getAno());
            pstm.setInt(4, entity.getNumPassageiros());
                  
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao INSERIR VEICULO.");
            ex.printStackTrace();
        } finally {
            this.connection.commit();
        }
    }

    @Override
    public void update(Veiculo entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE VEICULO SET NR_PLACA = ?, NR_ANO = ?, NR_PASSAGEIROS = ?")
                    .append(" WHERE CD_VEICULO = ?");
            
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, entity.getPlaca());
            pstm.setInt(2, entity.getAno());
            pstm.setInt(3, entity.getNumPassageiros());
            pstm.setInt(4, entity.getCodigo());
                  
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao ATUALIZAR VEICULO.");
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
            sql.append("DELETE FROM VEICULO WHERE CD_VEICULO = " + id);
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao DELETAR VEICULO");
            ex.printStackTrace();
        }finally {
            this.connection.commit();
        }
    }

    @Override
    public Veiculo getById(int id) throws SQLException {
        Veiculo veic = null;
        FuncionarioDAO funDAO = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT CD_VEICULO, NR_PLACA, NR_ANO, NR_PASSAGEIROS");
                sql.append(" FROM VEICULO");
                sql.append(" WHERE CD_VEICULO = " + id);
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                veic = new Veiculo();
                veic.setCodigo(rs.getInt("CD_VEICULO"));
                veic.setPlaca(rs.getString("NR_PLACA"));
                veic.setAno(rs.getInt("NR_ANO"));
                veic.setNumPassageiros(rs.getInt("NR_PASSAGEIROS"));
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR VEICULO por ID");
            ex.printStackTrace();
        }finally {            
        }
        return veic;
    }

    @Override
    public List<Veiculo> getByName(String name) throws SQLException {
        Veiculo veic = null;
        List<Veiculo> veicList = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT CD_VEICULO, NR_PLACA, NR_ANO, NR_PASSAGEIROS");
                sql.append(" FROM VEICULO");
                sql.append(" WHERE NR_PLACA LIKE UPPER('%"+name+"%') ");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            veicList = new ArrayList<>();
            while (rs.next()) {
                veic = new Veiculo();
                veic.setCodigo(rs.getInt("CD_VEICULO"));
                veic.setPlaca(rs.getString("NR_PLACA"));
                veic.setAno(rs.getInt("NR_ANO"));
                veic.setNumPassageiros(rs.getInt("NR_PASSAGEIROS"));
                veicList.add(veic);
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR VEICULOS por NOME");
            ex.printStackTrace();
        }finally {
            
        }
        return veicList;
    }

    @Override
    public List<Veiculo> getAll() throws SQLException {
        Veiculo veic = null;
        List<Veiculo> veicList = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT CD_VEICULO, NR_PLACA, NR_ANO, NR_PASSAGEIROS");
                sql.append(" FROM VEICULO");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            veicList = new ArrayList<>();
            while (rs.next()) {
                veic = new Veiculo();
                veic.setCodigo(rs.getInt("CD_VEICULO"));
                veic.setPlaca(rs.getString("NR_PLACA"));
                veic.setAno(rs.getInt("NR_ANO"));
                veic.setNumPassageiros(rs.getInt("NR_PASSAGEIROS"));
                veicList.add(veic);
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR TODOS OS VEICULOS");
            ex.printStackTrace();
        }finally {
            
        }
        return veicList;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT COALESCE(MAX(CD_VEICULO),0)+1 AS MAIOR FROM VEICULO ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
                return rs.getInt("MAIOR");
              
        }catch (SQLException ex){
            System.out.println("Erro SELECIONAR maior ID de VEICULO");
            ex.printStackTrace();
        }finally {
            pstm.close();
        }
        return 1;
    }

}
