import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {
    public Connection conectar() throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdProvaF", "root", "12345678");
        return con;
    }

   
}
