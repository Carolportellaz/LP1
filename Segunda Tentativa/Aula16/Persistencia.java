import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Persistencia {
    public static void gravarPessoa(ArrayList<Pessoa> arrayP, String filename) throws Exception{
        File arq = new File(filename);

        try{
            arq.delete();
            arq.createNewFile();

            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(arq));
            obj.writeObject(obj);
            obj.close();
        }

        catch(Exception e){
            throw new Exception("Ocorre o seguinte erro " + e.getMessage());
        }
    }

    public static ArrayList<Pessoa> carregarPessoas(String filename) throws Exception{
        ArrayList<Pessoa> p = new ArrayList<>();

        try{
            File arq = new File(filename);

            if(arq.exists()){
                ObjectInputStream obj = new ObjectInputStream(new FileInputStream(filename));
                p = (ArrayList<Pessoa>)obj.readObject();
            }

            else{
                return null;
            }

            return p;
        }

        catch(Exception e){
            throw new Exception("Ocorreu o seguinte erro " + e.getMessage());
        }
    }
}
