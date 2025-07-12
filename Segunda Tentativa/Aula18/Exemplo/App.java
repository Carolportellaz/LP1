import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        try{
            //Connect con = new Connect();
            //con.conectar();
        }

        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro " + e.getMessage());
        }

        try{
            SwingUtilities.invokeLater(new Runnable(){
                public void run(){
                    new Tela();
                }
            });

            
        }

        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro " + e.getMessage());
        }
        


    }
}
