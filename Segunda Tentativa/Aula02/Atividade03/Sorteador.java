import java.util.Random;
public class Sorteador {
    public int sorteador(){
        Random gerador = new Random();
        int n = gerador.nextInt(12) + 1;

        return n;
    }
}
