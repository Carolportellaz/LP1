import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class Persistencia{

    public ResultSet getAll() throws Exception{
        Connect cinema = new Connect();
        Connection con = cinema.conectar();

        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery("select * from filmes");

        return rs;
    }
}