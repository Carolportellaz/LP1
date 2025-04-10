public class Atividade02{
    private static int n1;

    public static void main(String[] args) {
        try{
            n1 = Integer.parseInt(args[0]);

            if(n1 % 2 == 0){
                System.out.println("O valor é par");
            }

            else{
                System.out.println("O valor é ímpar");
            }
        }

        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro " + e.getMessage());
        }

    }
}