import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.util.ArrayList;

public class Persistência {
    public void gravarFilmes(ArrayList<Filmes> f, String filename){
        try{
            File arq = new File(filename);

            arq.delete();
            arq.createNewFile();

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arq));
            out.writeObject(f);
            out.close();
        }

        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Filmes> carrgarFilmes(String filename){
        ArrayList<Filmes> f = new ArrayList<>();

        try{
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename));
            f = (ArrayList<Filmes>)input.readObject();

            input.close();
        }

        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro " + e.getMessage());
        }
        

        return f;
    }
}
