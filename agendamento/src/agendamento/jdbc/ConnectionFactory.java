package agendamento.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Norton Wagner Martins  
 * @date 21/11/2018
 */
public class ConnectionFactory {
    
    public static Connection connection;
    
    private static String dsn = "jdbc:postgresql://localhost:5432/agendamentodb";
    private static String username = "postgres";
    private static String password = "postgres";
    
    public static Connection getConnection() { //IMPLEMENTADO SINGLETON NA CONEXÃO
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(dsn, username, password);
            } catch (SQLException ex) {
                System.out.println("Houve um erro ao conectar com o Banco de Dados.");
            }
        }
        
        return connection;
    }
    
}    
