import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class Connect {
    public Connection conectar() throws Exception{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cinema", "root", "Carol2005");
        
        return con;

    }
}
