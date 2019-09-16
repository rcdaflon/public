package veiculosonline.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Marcelo
 */
public class ConnectionFactory {
    
    private static Connection conn;
    
    private static final String url = "jdbc:postgresql://localhost:5432/veiculosonline";
    private static final String user = "postgres";
    private static final String pass = "123";
        
    public static Connection getConnection(){
        
        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return conn;
    }
}
