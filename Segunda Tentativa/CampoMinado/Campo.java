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
        try{
            for(int i = 0; i < vet.length; i++){
                if(vet[i] == valor){
                    return true;
                }            
            }
    
        }
        
        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro no método verificar " + e.getMessage());
        }

        return  false;
    }
}
