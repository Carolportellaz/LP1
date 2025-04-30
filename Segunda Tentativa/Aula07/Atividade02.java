import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame{
    private JTextField txtCal = new JTextField(10);

    int altura = 50;
    int largura = 50;

    int x = 5;
    int y = 5;

    int cot = 1;

    String [] vet1 = {"/", "*", "-"};
    String [] vet2 = {"0", ".", "=", "+"};

    public App(){
        super("Calculador");
        JPanel panel = new JPanel();

        setLayout(new FlowLayout());
        setSize(new Dimension(200,200));

        panel.setLayout(null);
        setPreferredSize(new Dimension(100,100));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        for(int i = 1; i < 4; i++){
            for(int j = 1; j < 4; j++){
                JButton bnt = new JButton(String.valueOf(cot));
                
                bnt.setBounds(x,y,50,50);
                x += 53;

                panel.add(bnt);
                bnt.setActionCommand(String.valueOf(cot));
                bnt.addActionListener(new Eventos());
                cot++;

            }

            x = 5;
            y +=53;
        }

        for(int i = 0; i < vet1.length; i++){
            JButton bnt = new JButton(vet1[i]);
            bnt.addActionListener(new Eventos());
            bnt.setActionCommand(String.valueOf(i));

            ujhjj
        }

        setContentPane(panel);

        setVisible(true);
    }

    private class Eventos implements ActionListener{
        public void actionPerformed(ActionEvent event){
            
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                App app = new App();
            }
        });
    }
}