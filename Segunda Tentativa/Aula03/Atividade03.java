import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Atividade03 extends JFrame{
    JLabel ln1 = new JLabel("Nota 01");
    JTextField txtn1 = new JTextField(5);

    JLabel ln2 = new JLabel("Nota 02");
    JTextField txtn2 = new JTextField(5);

    JLabel ln3 = new JLabel("Nota 03");
    JTextField txtn3 = new JTextField(5);

    JButton bntR = new JButton("Calcular");

    public Atividade03(){
        setTitle("Disciplina LP1");
        setSize(130,150);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        add(ln1);
        add(txtn1);
        add(ln2);
        add(txtn2);
        add(ln3);
        add(txtn3);
        add(bntR);

        bntR.addActionListener(new Eventos());

        setVisible(true);
    }

    public static void main(String args[]){
        Atividade03 at = new Atividade03();
    }

    private class Eventos implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == bntR){
                try{
                    double nota1 = Double.parseDouble(txtn1.getText());
                    double nota2 = Double.parseDouble(txtn2.getText());
                    double nota3 = Double.parseDouble(txtn3.getText());

                    if(nota1 > 3 || nota1 < 0 || nota2 > 3 || nota2 < 0){
                        JOptionPane.showMessageDialog(null, "Informe um valor entre 0 e 3");
                    }

                    else{
                        if(nota3 > 4 || nota3 < 0){
                            JOptionPane.showMessageDialog(null, "Informe um valor entre 0 e 4");
                        }
    
                        else{
                            double nota = Double.parseDouble(txtn1.getText()) + Double.parseDouble(txtn1.getText()) + Double.parseDouble(txtn1.getText());
                    
                            if(nota >= 6){
                                JOptionPane.showMessageDialog(null, "Aprovado");
                            }
        
                            else{
                                if(nota >= 4){
                                    JOptionPane.showMessageDialog(null, "Prova final");
                                }
        
                                else{
                                    JOptionPane.showMessageDialog(null, "Reprovado");
                                }
                            }
                        }
                    }

                }

                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }

        
    }

}
