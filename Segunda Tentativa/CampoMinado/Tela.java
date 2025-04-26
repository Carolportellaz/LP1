import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame{
    JButton [] vetBnt = new JButton[9];
    JButton bntIniciar = new JButton("Iniciar");

    Campo camp = new Campo();
    GridLayout grid = new GridLayout(4,3);
    int [] vet_minas = new int[3];
    boolean contem;
    int valor;

    public Tela(){
        super("Campo minado");
        setLayout(grid);
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(200,200);

        for(int i = 0; i < vetBnt.length; i++){
            JButton bnt = new JButton(String.valueOf(i));
            add(bnt);
            bnt.addActionListener(new Eventos());
            bnt.setEnabled(false);
            vetBnt[i] = bnt;
            bnt.setActionCommand(""+i);
        }


        add(bntIniciar);

        bntIniciar.addActionListener(new Eventos());

        setVisible(true);

    }

    private class Eventos implements ActionListener{
        public void actionPerformed(ActionEvent event){

            if(event.getSource() == bntIniciar){
                bntIniciar.setEnabled(false);

                try{
                    for(int i = 0; i < vetBnt.length; i++){
                        vetBnt[i].setEnabled(true);
                    }
                }

                catch(Exception e){
                    System.out.println("Ocorreu o seguinte erro " + e.getMessage());
                }

                // Sortea os números //
                vet_minas = camp.gerarBombar();
                contem = false;
                
                try{
                    for(int i = 0; i < vet_minas.length; i++){
                        System.out.println("Os valores das minas são " + vet_minas[i]);
                    }
                }
                
                catch(Exception e){
                    System.out.println("Ocorreu o seguinte erro " + e.getMessage());
                }
            }


            try{
                if(event.getSource() != bntIniciar){
                    int i;

                    for(i = 0; i < vetBnt.length-1; i++){
                        if(event.getActionCommand().equals(String.valueOf(i))){
                            contem = camp.verf(i);
                            break;
                        }
                    }
    
    
                    if(contem == true){
                        vetBnt[i].setText("C");
                    }
        
                    else{
                        vetBnt[i].setText("E");
                    } 
                }
                
            }
            
            catch(Exception e){
                System.out.println("Ocorreu o seguinte erro " + e.getMessage());
            }    
            
        }
    }

    public static void main (String args[]){
        Tela tela = new Tela();
    }

}
