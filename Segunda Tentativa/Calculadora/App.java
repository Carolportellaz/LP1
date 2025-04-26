import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame{

    int n;
    int maior;
    int menor;
    int media;
    int soma;

    boolean correto = true;
    int count = 1;

    private JLabel lNumero = new JLabel("Número");
    private JTextField txtNumero = new JTextField(5);

    private JLabel lMaior = new JLabel("Maior");
    private JTextField txtMaior = new JTextField(5);

    private JLabel lMenor = new JLabel("Menor");
    private JTextField txtMenor = new JTextField(5);

    private JLabel lMedia = new JLabel("Média");
    private JTextField txtMedia = new JTextField(5);

    private JLabel lSoma = new JLabel("Soma");
    private JTextField txtSoma = new JTextField(5);

    private JButton bntProcess = new JButton("Processar");

    private GridLayout grid = new GridLayout(11,1);

    Calculos cal = new Calculos();

    public App(){
        setTitle("Números");
        setLayout(grid);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    
        add(lNumero);
        add(txtNumero);
        add(bntProcess);
        add(lMaior);
        add(txtMaior);
        add(lMenor);
        add(txtMenor);
        add(lMedia);
        add(txtMedia);
        add(lSoma);
        add(txtSoma);

        txtMaior.setEnabled(false);
        txtMedia.setEnabled(false);
        txtSoma.setEnabled(false);
        txtMenor.setEnabled(false);


        bntProcess.addActionListener(new Eventos());

        setVisible(true);
        pack();
    }

    public static void main (String args[]){
        App app = new App();
    }


    private class Eventos implements ActionListener{
        public void actionPerformed(ActionEvent event){

            // Tratando entrada de dados //
            try{
                // Número //
                if(event.getSource() == bntProcess){
                    n = Integer.parseInt(txtNumero.getText());
                    correto = true;
                }

            }
    
            catch(Exception e){
                correto = false;
                txtNumero.setText("");
                JOptionPane.showMessageDialog(null, "Informe uma valor válido");
            }

            if(correto == true){

                if(count != 1){
                    media = Integer.parseInt(txtMedia.getText()); 
                    soma = Integer.parseInt(txtSoma.getText());
                    n = Integer.parseInt(txtNumero.getText());
                    maior = Integer.parseInt(txtMaior.getText());
                    menor = Integer.parseInt(txtMenor.getText());
                }

                if(count == 1){
                    media = cal.media(n, count, soma);
                    soma = cal.soma(n, soma);
                    maior = cal.maior(n, maior);
                    menor = cal.menor(n, n);
                }

                count++;
                

                txtMaior.setText(String.valueOf(maior));
                txtMenor.setText(String.valueOf(menor));
                txtMedia.setText(String.valueOf(media));
                txtSoma.setText(String.valueOf(soma));

            }

            
        }

    }
    
} 