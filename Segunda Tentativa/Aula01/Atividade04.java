public class Atividade04 {
    public static void main(String[] args) {
        try{
            int valor = Integer.parseInt(args[0]);

            switch(valor){
                case 1: 
                    System.out.println("O dia é domingo");
                    break;
                case 2:
                    System.out.println("O dia é segunda");
                    break;
                case 3:
                    System.out.println("O dia é terça");
                    break;
                case 4:
                    System.out.println("O dia é quarta");
                    break;
                case 5: 
                    System.out.println("O dia é quinta");
                    break;
                case 6:
                    System.out.println("O dia é sexta");
                    break;
                default:
                    System.out.println("Informe um valor válido");
            }
        }

        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro " + e.getMessage());
        }
    }
}
