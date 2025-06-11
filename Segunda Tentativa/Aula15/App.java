import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class App extends JFrame{
    JLabel lCpf = new JLabel("CPF");
    JTextField txtCpf = new JTextField(10);

    JLabel lTel = new JLabel("Telefone");
    JTextField txtTel = new JTextField(10);

    JLabel lNome = new JLabel("Nome");
    JTextField txtNome = new JTextField(10);

    JLabel lEmail = new JLabel("Email");
    JTextField txtEmail = new JTextField(10);

    JButton bntSalvar = new JButton("Salvar");
    JButton bntSair = new JButton("Sair");

    JPanel panelCad = new JPanel();
    JPanel panelCon = new JPanel();

    GridBagLayout bag = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();

    public App(){
        super("Aplicação web");
        setSize(400,400);
        addComponent(lCpf, 0, 0, 1, 1);
        addComponent(txtCpf, 0, 1, 1, 1);
        addComponent(lTel, 1, 0, 1, 1);
        addComponent(txtTel, 1, 1, 1, 1);

        panelCad.setLayout(bag);


        add(panelCad);

        setVisible(true);


        
    }

    // Adicionando componentes //
    public void addComponent(Component c, int row, int col, int width, int height){
        constraints.gridx = col;
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        
        bag.setConstraints(c, constraints);
        panelCad.add(c, constraints);
    }

    public static void main (String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new App();
            }
        });
    }
}