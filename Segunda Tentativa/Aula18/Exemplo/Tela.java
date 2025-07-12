import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class Tela extends JFrame{
    private JLabel lCodigo = new JLabel("Código");
    private JTextField txtCodigo = new JTextField(10);

    private JLabel lNm = new JLabel("Nome");
    private JTextField txtNm = new JTextField(10);

    private JLabel lAno = new JLabel("Ano de lançamento");
    private JTextField txtAno = new JTextField(10);

    private JLabel lGen = new JLabel("Gênero");
    String vetGen [] = {"Ação", "Romance", "Terror", "Suspense", "Comédia", "Fantasia", "Drama"};
    private JComboBox<String> combo = new JComboBox<>(vetGen);

    private JLabel lAutor = new JLabel("Autor");
    private JTextField txtAutor = new JTextField(10);

    private JButton bntPri = new JButton("Primeiro");
    private JButton bntAnt = new JButton("Anterior");
    private JButton bntProx = new JButton("Próximo");
    private JButton bntUl = new JButton("Último");

    private JButton bntNovo = new JButton("Novo");
    private JButton bntSalvar = new JButton("Salvar");
    private JButton bntCan = new JButton("Cancelar");
    private JButton bntExc = new JButton("Excluir");
    private JButton bntAlt = new JButton("Alterar");

    private JPanel panelContent = new JPanel();
    private JPanel panelBnt = new JPanel();

    private GridBagLayout bag = new GridBagLayout();
    private GridBagConstraints constraints = new GridBagConstraints();
    

    public Tela(){    
        super("Cadastro de filmes");
        setSize(400,200);
        setLayout(new BorderLayout());
        setResizable(true);

        panelContent.setLayout(bag);

        // Adicionando o content //
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        addComponent(lCodigo, 0,0,1,1);
        addComponent(txtCodigo, 1,0,1,1);

        addComponent(lAno, 0, 1, 1, 1);
        addComponent(txtAno, 1, 1, 1, 1);


        addComponent(lNm, 0, 2, 1, 1);
        addComponent(txtNm, 1, 2, 1, 1);

        addComponent(lAutor, 0, 3, 1, 1);
        addComponent(txtAutor, 1, 3,1, 1);

        addComponent(lGen, 0, 4, 1, 1);
        addComponent(combo, 1, 4, 1, 1);

        // Por que está sem espaço entre os botões? //
        JPanel boxBnt = new JPanel();
        boxBnt.setLayout(new FlowLayout(FlowLayout.CENTER));
        boxBnt.add(bntAnt);
        boxBnt.add(bntProx);
        boxBnt.add(bntPri);
        boxBnt.add(bntUl);

        JPanel boxBnt2 = new JPanel();
        boxBnt2.setLayout(new FlowLayout(FlowLayout.CENTER));
        boxBnt2.add(bntNovo);
        boxBnt2.add(bntSalvar);
        boxBnt2.add(bntCan);
        boxBnt2.add(bntExc);
        boxBnt2.add(bntAlt);

        panelBnt.setLayout(new GridLayout(2, 1));
        panelBnt.add(boxBnt);
        panelBnt.add(boxBnt2);

        add(panelContent, BorderLayout.CENTER);
        add(panelBnt, BorderLayout.SOUTH);

        setVisible(true);
        

        // O que isso faz? Proque preciso fazer isso para todos os componentes? Teria uma forma de fazer com se fosse o contraints? //
        // jlN.setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    public void addComponent(Component c, int x, int y, int width, int height){
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = width;
        constraints.gridheight = height;

        bag.setConstraints(c, constraints);
        panelContent.add(c);
    }

    public void iniciar(){
        txtCodigo.setEnabled(false);
        txtAno.setEnabled(false);
        combo.setEnabled(false); 

    }
}