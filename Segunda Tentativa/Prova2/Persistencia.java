import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Persistencia {
    public void gravarJog(ArrayList<Jogador> arrayJog, String filename) throws FileNotFoundException, IOException{
        File arq = new File(filename);

        arq.delete();
        arq.createNewFile();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arq));
        out.writeObject(arrayJog);
        out.close();
    }

    public ArrayList<Jogador> carregarJog(String filename) throws FileNotFoundException, IOException, ClassNotFoundException{
        File arq = new File(filename);

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(arq));
        @SuppressWarnings("unchecked")
        ArrayList<Jogador> array = (ArrayList<Jogador>)input.readObject();

        input.close();
        return array;
    }
}
