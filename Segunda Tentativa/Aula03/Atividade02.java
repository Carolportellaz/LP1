import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Atividade02 extends JFrame {
    JLabel lraio = new JLabel("Informe o raio");
    JTextField txt_raio = new JTextField(5);

    JLabel lr = new JLabel("Resultado");
    JTextField txtR = new JTextField(5);
    JButton bntR = new JButton("Calcular");

    FlowLayout flow = new FlowLayout();

    public Atividade02(){
        setTitle("Área de um círculo");
        setSize(200,120);
        setLayout(flow);
        add(lraio);
        add(txt_raio);
        add(lr);
        add(txtR);
        add(bntR);

        bntR.addActionListener(new Eventos());

        setVisible(true);
    }

    public static void main (String args[]){
        Atividade02 tela = new Atividade02();
    }

    private class Eventos implements ActionListener{
        public void actionPerformed(ActionEvent event){
            try{
                if(event.getSource() == bntR){
                    float raio = Float.parseFloat(txt_raio.getText());

                    float area = 3.14f * (raio * raio);
    
                    txtR.setText(String.valueOf(area));
                }
                
            }

            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro " +e.getMessage());
            }
        }
    }
}
