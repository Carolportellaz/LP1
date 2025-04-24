import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    JLabel lSomaJ1 = new JLabel("Soma do jogador 01");
    JTextField txtSomaJ1 = new JTextField(5);

    JLabel lSomaJ2 = new JLabel("Soma do jogador 02");
    JTextField txtSomaJ2 = new JTextField(5);

    JButton bntJ1 = new JButton("Cartas para J1");
    JButton bntStopJ1 = new JButton("Parar J1");

    JButton bntJ2 = new JButton("Cartas para J2");
    JButton bntStopJ2 = new JButton("Parar J2");

    JButton bntNov = new JButton("Jogar novamente");
    JButton bntSair = new JButton("Sair");

    GridLayout grid = new GridLayout(5, 4);
    int n1;
    int n2;
    int somaJ1;
    int somaJ2;
    boolean continua;

    Sorteador sort = new Sorteador();

    public App() {
        setTitle("Black Jack");
        setLayout(grid);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(lSomaJ1);
        add(txtSomaJ1);
        add(lSomaJ2);
        add(txtSomaJ2);
        add(bntJ1);
        add(bntJ2);
        add(bntStopJ1);
        add(bntStopJ2);
        add(bntSair);
        add(bntNov);

        setVisible(true);
        pack();

        bntJ1.addActionListener(new Eventos());
        bntStopJ1.addActionListener(new Eventos());

        bntJ2.addActionListener(new Eventos());
        bntStopJ2.addActionListener(new Eventos());

        bntSair.addActionListener(new Eventos());
        bntNov.addActionListener(new Eventos());

        inicio();

    }

    public void inicio(){
        somaJ1 = 0;
        somaJ2 = 0;

        txtSomaJ1.setEnabled(false);
        txtSomaJ2.setEnabled(false);

        txtSomaJ1.setText("");
        txtSomaJ2.setText("");

        bntJ2.setEnabled(false);
        bntStopJ2.setEnabled(false);

        bntJ1.setEnabled(true);
        bntStopJ1.setEnabled(true);

        n1 = sort.sorteador();
        n2 = sort.sorteador();
        somaJ1 = n1 + n2;

        txtSomaJ1.setText(String.valueOf(somaJ1));

        continua = msg(somaJ1);
    }

    public boolean msg(int soma) {
        if (soma == 21) {
            JOptionPane.showMessageDialog(null, "Parabéns você ganhou!");
            return false;
        }

        if (soma > 21) {
            JOptionPane.showMessageDialog(null, "Você perdeu!");
            return false;
        }

        else {
            return true;
        }

    }

    private class Eventos implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == bntJ1) {
                if (continua == true) {
                    n1 = sort.sorteador();
                    somaJ1 = n1 + somaJ1;

                    txtSomaJ1.setText(String.valueOf(somaJ1));

                    continua = msg(somaJ1);
                }
            }

            if (event.getSource() == bntStopJ1) {
                bntJ1.setEnabled(false);
                bntStopJ1.setEnabled(false);
                bntJ2.setEnabled(true);
                bntStopJ2.setEnabled(true);

                // Fazendo a primeira roda do jogador 02 //
                n1 = sort.sorteador();
                n2 = sort.sorteador();
                somaJ2 = n1 + n2;

                txtSomaJ2.setText(String.valueOf(somaJ2));

                continua = msg(somaJ2);
            }

            if(event.getSource() == bntJ2){
                if(continua == true){
                    n1 = sort.sorteador();
                    somaJ2 = somaJ2 + n1;
                    
                    txtSomaJ2.setText(String.valueOf(somaJ2));

                    continua = msg(somaJ2);
                }
            }

            if(event.getSource() == bntStopJ2){

                int dist1 = Math.abs(somaJ1 - 21);
                int dist2 = Math.abs(somaJ2 - 21);

                if(dist2 > dist1){
                    JOptionPane.showMessageDialog(null, "O jogador 1 ganhou!");
                }

                else{
                    if(dist1 > dist2){
                        JOptionPane.showMessageDialog(null, "O jogador 2 ganhou!");
                    }
    
                    else{
                        JOptionPane.showMessageDialog(null, "Empate");
                    }
                } 
            }

            if(event.getSource() == bntNov){
                inicio();
            }

            if(event.getSource() == bntSair){
                System.exit(1);
            }



        }
    }

    public static void main(String args[]) {
        new App();
    }
}