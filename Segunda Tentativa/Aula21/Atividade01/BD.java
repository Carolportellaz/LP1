import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {
    private boolean conectado;
    
    public boolean isConectado() {
        return conectado;
    }

    public Connection conectar() throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdEscola", "root", "12345678");
        conectado = true;
        return con;
    }
}
