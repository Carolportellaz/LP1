import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;

public class TelaLogin extends JFrame{
    private JLabel lUser = new JLabel("Usuário");
    private JTextField txtUser = new JTextField("José Mário");

    private JLabel lSenha = new JLabel("Senha");
    private JPasswordField txtSenha = new JPasswordField("123");

    private JButton bntCan = new JButton("Cancelar");
    private JButton bntLogar = new JButton("Logar");

    private GridBagLayout bag = new GridBagLayout();
    private GridBagConstraints constraints = new GridBagConstraints();

    private JPanel panelBnt = new JPanel();

    Usuarios user;
    boolean logado;


    String usuario;
    String senha;

    public TelaLogin(){
        setSize(450,150);
        setTitle("Controle de acesso");
        setResizable(true);
        setLayout(bag);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panelBnt.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelBnt.add(bntCan);
        panelBnt.add(bntLogar);

        // Para maximizar o tamanho da tela //
        //setExtendedState(JFrame.MAXIMIZED_BOTH);

        constraints.insets = new Insets(1, 1, 1, 1);
        
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        addComponent(lUser, 0, 0, 1, 1);
        addComponent(txtUser, 1, 0, 3, 1);

        addComponent(lSenha, 0, 1, 1, 1);
        addComponent(txtSenha, 1, 1, 3, 1);

        addComponent(new JLabel(""), 0, 2, 1, 1);
        addComponent(new JLabel(""), 1, 2, 1, 1);
        addComponent(new JLabel(""), 2, 2, 1, 1);
        addComponent(panelBnt, 3, 2, 1, 1);
        
        setVisible(true);

        // Criando a instância usuários //
        try{
            user = new Usuarios();
        }

        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro " + e.getMessage());
        }

        bntCan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                txtSenha.setText("");
                txtUser.setText("");
            }
        });

        bntLogar.addActionListener((ac) -> {
            try{
                usuario = txtUser.getText();
                senha = new String(txtSenha.getPassword());

                logado = user.logar(usuario, senha);

                if(logado){
                    System.out.println("Você está logado no sistema");
                    TelaEsc escola = new TelaEsc();

                    dispose();
                    escola.setVisible(true);

                }

                else{
                    System.out.println("Vocês não está logado no sistema");
                }
            }

            catch(Exception e){
                System.out.println("Ocorreu o seguinte erro ao tentar logar no sistema " + e.getMessage());
            }

        });
    }

    public void addComponent(Component c, int x, int y, int width, int height){
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridheight = height;
        constraints.gridwidth = width;
        
        bag.setConstraints(c, constraints);
        add(c);
    }
}
