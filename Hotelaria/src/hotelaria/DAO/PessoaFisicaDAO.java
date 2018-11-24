package hotelaria.DAO;

import hotelaria.jdbc.ConnectionFactory;
import hotelaria.model.PessoaFisica;
import hotelaria.model.Sexo;
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
public class PessoaFisicaDAO implements GenericDAO<PessoaFisica>{
    private Connection connection = null;

    @Override
    public void save(PessoaFisica entity) throws SQLException {
    try {
            this.connection = ConnectionFactory.getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO PESSOA_FISICA (ID, CPF, RG, SEXO, NM)")
                    .append(" VALUES(?,?,?,?,?)");
            
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getCpf());
            pstm.setString(3, entity.getRg());
            pstm.setString(4, entity.getSexo());
            pstm.setString(5, entity.getNome());
                  
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao INSERIR Pessoa Fisica.");
            ex.printStackTrace();
        } finally {
            this.connection.commit();
            //connection.close();
        }
    }        

    @Override
    public void update(PessoaFisica entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE PESSOA_FISICA SET CPF = ?, RG = ?, SEXO = ?, NM = ?")
                    .append(" WHERE ID = ?");
            
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, entity.getCpf());
            pstm.setString(2, entity.getRg());
            pstm.setString(3, entity.getSexo());
            pstm.setString(4, entity.getNome());
            pstm.setInt(5, entity.getCodigo());
                  
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao ATUALIZAR Pessoa Fisica.");
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
            sql.append("DELETE FROM PESSOA_FISICA WHERE ID = " + id);
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            this.connection.rollback();
            System.out.println("Erro ao DELETAR Pessoa Fisica");
            ex.printStackTrace();
        }finally {
            this.connection.commit();
            //this.connection.close();
        }
    }

    @Override
    public PessoaFisica getById(int id) throws SQLException {
        PessoaFisica pf = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT PF.ID, PF.CPF, PF.RG, PF.SEXO, PF.NM");
                sql.append(" FROM PESSOA_FISICA AS PF ");
                sql.append(" WHERE PF.ID = " + id);
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR Pessoa Fisica por ID");
            ex.printStackTrace();
        }finally {
            //this.connection.close();
        }
        return pf;
    }

    @Override
    public List<PessoaFisica> getByName(String name) throws SQLException {
        PessoaFisica pf = null;
        List<PessoaFisica> pfList = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT PF.ID, PF.CPF, PF.RG, PF.SEXO, PF.NM");
                sql.append(" FROM PESSOA_FISICA AS PF ");
                sql.append(" WHERE PF.NM LIKE UPPER('%"+name+"%') ");
                
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            pfList = new ArrayList<>();
            while (rs.next()) {
                pf = new PessoaFisica() {};
                //Sexo sexo = null; // PRA PODER DEFINIR UM SEXO PQ É ENUM               
                pf.setCodigo(rs.getInt("ID"));
                pf.setCpf(rs.getString("CPF"));
                pf.setRg(rs.getString("RG"));
                pf.setNome(rs.getString("NM"));
                pf.setSexo(rs.getString("SEXO")); //PRIMEIRO DEFINO SEXO
                //pf.setSexo(sexo); //ATRIBUO A PF
                pfList.add(pf);                
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR Pessoa Fisica por NOME");
            ex.printStackTrace();
        }finally {
            //this.connection.close();
        }
        return pfList;
    }

    @Override
    public List<PessoaFisica> getAll() throws SQLException {
        PessoaFisica pf = null;
        List<PessoaFisica> pfList = null;
        try {
            this.connection = ConnectionFactory.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT PF.ID, PF.CPF, PF.RG, PF.SEXO, PF.NM");
                sql.append(" FROM PESSOA_FISICA AS PF ");
                
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            pfList = new ArrayList<>();
            while (rs.next()) {
                pf = new PessoaFisica() {};
               // Sexo sexo = null; // PRA PODER DEFINIR UM SEXO PQ É ENUM               
                pf.setCodigo(rs.getInt("ID"));
                pf.setCpf(rs.getString("CPF"));
                pf.setRg(rs.getString("RG"));
                pf.setNome(rs.getString("NM"));
                pf.setSexo(rs.getString("SEXO")); //PRIMEIRO DEFINO SEXO
                //pf.setSexo(sexo); //ATRIBUO A PF
                pfList.add(pf);                
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao SELECIONAR TODAS as Pessoa Fisica");
            ex.printStackTrace();
        }finally {
            //this.connection.close();
        }
        return pfList;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT COALESCE(MAX(PF.ID),0)+1 AS MAIOR FROM PESSOA_FISICA AS PF ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
                return rs.getInt("MAIOR");
              
        }catch (SQLException ex){
            System.out.println("Erro SELECIONAR maior ID de PESSOA_FISICA");
            ex.printStackTrace();
        }finally {
            pstm.close();
            //this.connection.close();
        }
        return 1;
    }

}
