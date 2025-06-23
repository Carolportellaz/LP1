import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class App extends JFrame{
    private JLabel lNm = new JLabel("Nome");
    private JTextField txtNm = new JTextField(10);

    private JLabel lEmail = new JLabel("Email");
    private JTextField txtEmail = new JTextField(10);

    private JLabel lCpf = new JLabel("CPF");
    private JTextField txtCpf = new JTextField(10);

    private JLabel lTel = new JLabel("Telefone");
    private JTextField txtTel = new JTextField(10);

    private JButton bntNovo = new JButton("Novo");
    private JButton bntSalvar = new JButton("Salvar");

    private JButton bntPri = new JButton("Primeiro");
    private JButton bntAnt = new JButton("Anterior");
    private JButton bntProx = new JButton("Próximo");
    private JButton bntUl = new JButton("Último");

    private JPanel panelP = new JPanel();
    private JPanel panelBnt = new JPanel();
    private JPanel panelNv = new JPanel();

    private GridBagLayout bagNav = new GridBagLayout();
    private GridBagLayout bagPri = new GridBagLayout();

    private GridBagConstraints constraints = new GridBagConstraints();
    GridBagConstraints constraintsP = new GridBagConstraints();

    ArrayList<Pessoa> arrayP = new ArrayList<Pessoa>();

    String nome;
    String email;
    int cpf; 
    int telefone;

    public App(){
        setLayout(bagPri);


        
        // Adicionando na nav bar //
        panelNv.setLayout(bagNav);

        constraints.fill = GridBagConstraints.BOTH;
        addComponentNav(bntPri, 0, 1, 1, 1);
        addComponentNav(bntAnt, 0, 2, 1, 1);
        addComponentNav(bntProx, 0, 3, 1, 1);
        addComponentNav(bntUl, 0, 4, 1, 1);


        try{
            TitledBorder border = BorderFactory.createTitledBorder("Navegação");
            border.setTitleJustification(TitledBorder.CENTER);

            panelNv.setBorder(border);
        }

        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro " + e.getMessage());
        }

        // Adicionando no panel principal //
        constraintsP.fill = GridBagConstraints.BOTH;
        addComponentPri(lNm, 0, 0, 1, 1);
        addComponentPri(txtNm, 0, 1, 3, 1);

        addComponentPri(lEmail, 1, 0, 1, 1);
        addComponentPri(txtEmail, 1, 1, 3 ,1);

        addComponentPri(lCpf, 2, 0 ,1, 1);
        addComponentPri(txtCpf, 2, 1, 1, 1);

        addComponentPri(lTel, 3, 0, 1, 1);
        addComponentPri(txtTel, 3, 1, 1, 1);

        addComponentPri(panelBnt, 4, 2, 2, 1);

        addComponentPri(panelNv, 0, 5, 1, 5);

        // Adicionando panel de botões //
        panelBnt.add(bntNovo);
        panelBnt.add(bntSalvar);
        panelBnt.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Adicionando no frame //
        add(panelP);

        pack();
        setVisible(true);

        // Lógica de salvamento //
        bntSalvar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                nome = txtNm.getText();
                email = txtEmail.getText();
                cpf = Integer.parseInt(txtCpf.getText());
                telefone = Integer.parseInt(txtTel.getText());

                Pessoa p = new Pessoa(nome, email, cpf, telefone);

                arrayP.add(p);
            }
            
        });
    }

    public void addComponentPri(Component c, int x, int y, int width, int height){
        constraintsP.gridx = y;
        constraintsP.gridy = x;
        constraintsP.gridheight = height;
        constraintsP.gridwidth = width;

        bagPri.setConstraints(c, constraintsP);
        add(c);
    }

    public void addComponentNav(Component c, int x, int y, int width, int height){
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = width;
        constraints.gridheight = height;

        bagNav.setConstraints(c, constraints);
        panelNv.add(c);
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new App();
            }
        });
    }
}