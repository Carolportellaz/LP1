import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProvaF {
    BD bd = new BD();
    ArrayList<String> array = new ArrayList<>();

    public ArrayList<String> carregaDis() throws Exception{
        Connection con = bd.conectar();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select nomeD from tbDisciplina");

        while(rs.next()){
            array.add(rs.getString(1));
        }
        
        return array;
    }

    public void inserir(String nomeA, String nomeD) throws Exception{
        Connection con = bd.conectar();
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery();
    }
}
