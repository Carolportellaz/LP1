public class Atividade03 {
    static int  maior;
    static int valor;
    public static void main(String[] args) {
        try{

            maior = Integer.parseInt(args[0]);

            for(int i = 0; i < args.length; i++){
                valor = Integer.parseInt(args[i]);
                if(maior < valor){
                    maior = valor;
                }
            }

            System.out.println("O maior valor é " + maior);
        }

        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro " + e.getMessage());
        }
    }
}
