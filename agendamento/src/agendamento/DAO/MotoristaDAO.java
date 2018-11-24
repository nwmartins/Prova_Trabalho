package agendamento.DAO;

import agendamento.jdbc.ConnectionFactory;
import agendamento.model.Motorista;
import agendamento.util.DateUtil;
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
public class MotoristaDAO implements GenericDAO<Motorista>{
    
    private Connection connection = null;

    @Override
    public void save(Motorista entity) throws SQLException {
    try {
            this.connection = ConnectionFactory.getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            String data = DateUtil.dateToString(entity.getDtVencimento()).replace("/", "-"); //COISA DE BAIANO... PRA N FLA OUTRA COISA  //COMPILOU TÁ VLENDO         
            sql.append("INSERT INTO MOTORISTA (CD_MOTORISTA, CD_FUNCIONARIO, NR_CNH, DT_VENCIMENTO)")
                    .append(" VALUES(?,?,?,'" + data + "')");
            
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setInt(2, entity.getFuncionario().getCodigo());
            pstm.setString(3, entity.getNumCNH());
                  
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao INSERIR Motorista.");
            ex.printStackTrace();
        } finally {
            this.connection.commit();
        }
    }

    @Override
    public void update(Motorista entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            String data = DateUtil.dateToString(entity.getDtVencimento()).replace("/", "-"); //COISA DE BAIANO... PRA N FLA OUTRA COISA  //COMPILOU TÁ VLENDO
            sql.append("UPDATE MOTORISTA SET CD_FUNCIONARIO = ?, NR_CNH = ?, DT_VENCIMENTO = '" + data + "'")
                    .append(" WHERE CD_MOTORISTA = ?");
            
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getFuncionario().getCodigo());
            pstm.setString(2, entity.getNumCNH());
            pstm.setInt(3, entity.getCodigo());
                  
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao ATUALIZAR MOTORISTA.");
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
            sql.append("DELETE FROM MOTORISTA WHERE CD_MOTORISTA = " + id);
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao DELETAR MOTORISTA");
            ex.printStackTrace();
        }finally {
            this.connection.commit();
        }
    }

    @Override
    public Motorista getById(int id) throws SQLException {
        Motorista mot = null;
        FuncionarioDAO funDAO = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT CD_MOTORISTA, CD_FUNCIONARIO, NR_CNH, DT_VENCIMENTO");
                sql.append(" FROM MOTORISTA");
                sql.append(" WHERE CD_MOTORISTA = " + id);
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                mot = new Motorista();
                mot.setCodigo(rs.getInt("CD_MOTORISTA"));
                funDAO = new FuncionarioDAO();
                mot.setFuncionario(funDAO.getById(rs.getInt("CD_FUNCIONARIO")));
                mot.setNumCNH(rs.getString("NR_CNH"));
                mot.setDtVencimento(rs.getDate("DT_VENCIMENTO"));
                //mot.setNome(mot.getFuncionario().getNome());
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR MOTORISTA por ID");
            ex.printStackTrace();
        }finally {
            
        }
        return mot;
    }

    @Override
    public List<Motorista> getByName(String name) throws SQLException {
        Motorista mot = null;
        List<Motorista> motoList = null;
        FuncionarioDAO funDAO = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT M.CD_MOTORISTA, M.CD_FUNCIONARIO, F.NM_FUNCIONARIO, M.NR_CNH, M.DT_VENCIMENTO");
                sql.append(" FROM MOTORISTA AS M");
                sql.append(" INNER JOIN FUNCIONARIO AS F ON (F.CD_FUNCIONARIO = M.CD_FUNCIONARIO)");
                sql.append(" WHERE F.NM_FUNCIONARIO LIKE UPPER('%"+name+"%') ");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            motoList = new ArrayList<>();
            while (rs.next()) {
                mot = new Motorista();
                mot.setCodigo(rs.getInt("CD_MOTORISTA"));
                funDAO = new FuncionarioDAO();
                mot.setFuncionario(funDAO.getById(rs.getInt("CD_FUNCIONARIO")));
                mot.setNumCNH(rs.getString("NR_CNH"));
                mot.setDtVencimento(rs.getDate("DT_VENCIMENTO"));
                //mot.setNome(mot.getFuncionario().getNome());
                motoList.add(mot);
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR MOTORISTA por NOME");
            ex.printStackTrace();
        }finally {
            
        }
        return motoList;
    }

    @Override
    public List<Motorista> getAll() throws SQLException {
        Motorista mot = null;
        List<Motorista> motoList = null;
        FuncionarioDAO funDAO = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT CD_MOTORISTA, CD_FUNCIONARIO, NR_CNH, DT_VENCIMENTO");
                sql.append(" FROM MOTORISTA");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            motoList = new ArrayList<>();
            while (rs.next()) {
                mot = new Motorista();
                mot.setCodigo(rs.getInt("CD_MOTORISTA"));
                funDAO = new FuncionarioDAO();
                mot.setFuncionario(funDAO.getById(rs.getInt("CD_FUNCIONARIO")));
                mot.setNumCNH(rs.getString("NR_CNH"));
                mot.setDtVencimento(rs.getDate("DT_VENCIMENTO"));
                motoList.add(mot);
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR MOTORISTA por NOME");
            ex.printStackTrace();
        }finally {
            
        }
        return motoList;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT COALESCE(MAX(CD_MOTORISTA),0)+1 AS MAIOR FROM MOTORISTA ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
                return rs.getInt("MAIOR");
              
        }catch (SQLException ex){
            System.out.println("Erro SELECIONAR maior ID de MOTORISTA");
            ex.printStackTrace();
        }finally {
            pstm.close();
        }
        return 1;
    }

}
