import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Query {
    Connection con;
    Statement st;
    ResultSet rs;
    ResultSetMetaData meta;
    boolean conectado;

    public Connection conectar()throws SQLException{
        con = DriverManager.getConnection("jdbc:mysql:3306//localhost/", "root", "12345678");
        conectado = true;
        return con;
    }

    public void executeMeta(String sql) throws SQLException{
        con = conectar();
        st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = st.executeQuery(sql);
        meta = rs.getMetaData();
        conectado = true;
    }

    public boolean isConectado(){
        return conectado;
    }
}

