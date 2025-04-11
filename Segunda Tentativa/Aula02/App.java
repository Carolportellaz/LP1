import java.util.Random;

public class App{
    static Random gerador = new Random();
    static int n1;
    static int n2;
    static int soma;
    static int pontuacao;
    static boolean segunda_rodada = true;
    public static void main (String args[]){
        n1 = gerador.nextInt(5) + 1;
        n2 = gerador.nextInt(5) + 1;
        soma = n1 + n2;

        System.out.println("O valor de n1 é " + n1);
        System.out.println("O valor de n2 é " + n2);

        if(soma == 7 || soma == 11){
            System.out.println("Parabéns, você ganhou!");
        }

        if(soma == 2 || soma == 3 || soma == 12){
            System.out.println("Você perdeu!");
        }

        else{
            pontuacao = soma;

            while((pontuacao != soma || segunda_rodada == true) && (soma != 7)){
                segunda_rodada = false;

                n1 = gerador.nextInt(5) + 1;
                n2 = gerador.nextInt(5) + 1;
                soma = n1 + n2;

                System.out.println("O valor de n1 é " + n1);
                System.out.println("O valor de n2 é " + n2);

            }

            if(soma == 7){
                System.out.println("Você perdeu!");
            }

            else{
                System.out.println("Parabéns, você ganhou!");
            }
        }
    }
}