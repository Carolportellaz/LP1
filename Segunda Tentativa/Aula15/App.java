import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class App extends JFrame {
    JLabel lCpf = new JLabel("CPF");
    

    JLabel lTel = new JLabel("Telefone");

    JLabel lNome = new JLabel("Nome");
    JTextField txtNome = new JTextField(10);

    JLabel lEmail = new JLabel("Email");
    JTextField txtEmail = new JTextField(10);

    JButton bntSalvar = new JButton("Salvar");
    JButton bntSair = new JButton("Sair");

    JPanel panelCad = new JPanel();
    JPanel panelCon = new JPanel();

    GridBagLayout bag1 = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();

    JTabbedPane tab  = new JTabbedPane();

    public App() throws Exception {
        super("Aplicação web");
        setSize(400,200);

        // CPF //
        MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
        JFormattedTextField txtCpf = new JFormattedTextField(maskCpf);

        // Telefone //
        MaskFormatter maskTel = new MaskFormatter("(##)####-####");
        JFormattedTextField txtTel = new JFormattedTextField(maskTel);

        panelCad.setLayout(bag1);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        addComponent(lCpf, 0, 0, 1, 1);
        addComponent(txtCpf, 0, 1, 1, 1);
        addComponent(lTel, 1, 0, 1, 1);
        addComponent(txtTel, 1, 1, 1, 1);
        addComponent(lNome, 2, 0, 1,1);
        addComponent(txtNome, 2, 1,3, 1);
        addComponent(lEmail, 3, 0, 1,1);
        addComponent(txtEmail, 3, 1, 3,1);
        addComponent(bntSalvar, 4, 2,1, 1 );
        addComponent(bntSair, 4, 3, 1, 1);


        tab.addTab("Cadastro de Usuário", panelCad);

        add(tab);

        setVisible(true);
        
    }

    // Adicionando componentes //
    public void addComponent(Component c, int row, int col, int width, int height){
        constraints.gridx = col;
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        
        // Depois perguntar o Leo sobre essa parte //
        bag1.setConstraints(c, constraints);
        panelCad.add(c, constraints);
    }

    public static void main (String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                try{
                    new App();
                }

                catch(Exception e){
                    System.out.println("Ocorreu o seguinte erro " + e.getMessage());
                }
            }
        });
    }
}
