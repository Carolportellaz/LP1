import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Atividade01 extends JFrame{
    JLabel lN1 = new JLabel("Informe o n1");
    JTextField txtN1 = new JTextField(5);

    JLabel lR = new JLabel("Resultado");
    JTextField txtR = new JTextField(5);

    JButton bntFat = new JButton("Fatorial");

    FlowLayout flow = new FlowLayout();

    public Atividade01(){
        setTitle("Fatorial");
        setLayout(flow);
        setSize(300,100);

        add(lN1);
        add(txtN1);
        add(lR);
        add(txtR);
        add(bntFat);

        bntFat.addActionListener(new Eventos());

        txtR.setEnabled(true);

        setVisible(true);
    }

    public static void main (String args []){
        Atividade01 app = new Atividade01();
    }

    private class Eventos implements ActionListener{
        public void actionPerformed(ActionEvent event){

            try{
                int n1 = Integer.parseInt(txtN1.getText());
                int fat = 1;
    
                if(event.getSource() == bntFat){
                    while(n1 > 0){
                        fat = fat * n1;
                        n1--;
                    }
                }

                txtR.setText("");
                txtR.setText(String.valueOf(fat));
            }

            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro " + e.getMessage());
            }
            
        }
    }
}

// 3 * 3 * 3