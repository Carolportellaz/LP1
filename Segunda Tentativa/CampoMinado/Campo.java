import java.util.Random;
public class Campo {
    Random gerador = new Random();
    int n;
    int [] vet = new int[3];
    int cot;
    boolean verf = false;

    public int [] gerarBombar(){
        
        while(cot < 3){
            n = gerador.nextInt(9);
            verf = true;

            for(int i = 0; i < vet.length; i++){
                if(vet[i] == n){
                    verf = false;
                    break;
                }

            }

            if(verf == true){
                vet[cot] = n;
                cot++;
            }

        }

        return vet;
    }

    public boolean verf(int valor){
        for(int i = 0; i < vet.length; i++){
            if(vet[i] == 0){
                return true;
            }            
        }

        return  false;
    }
}
