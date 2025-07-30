import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Usuarios {
    BD bd = new BD();
    Connection con;
    ResultSet rs;
    PreparedStatement pst;

    public Usuarios() throws Exception{
        con = bd.conectar();

    }

    public boolean logar(String usuario, String senha) throws Exception{
        
        if(bd.isConectado() == true){
            pst = con.prepareStatement("select * from tbUsuarios where usuario=? and senha=md5(?)");
            pst.setString(1, usuario);
            pst.setString(2, senha);
            rs = pst.executeQuery();

            if(rs.isBeforeFirst()){
                return true;
            }

            else{
                return false;
            }
        }

        else{
            System.out.println("Entrou no else");
            return false;
        }

    }


}
