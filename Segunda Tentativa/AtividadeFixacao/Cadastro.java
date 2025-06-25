import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.text.MaskFormatter;

public class Cadastro extends JInternalFrame{
    private JLabel lTil = new JLabel("Título");
    private JFormattedTextField txtTil = new JFormattedTextField();

    private JLabel lAno = new JLabel("Ano");
    private JTextField txtAno = new JTextField(10);

    private JLabel lGen = new JLabel("Gênero");
    String vetGen [] = {"Terror", "Ação", "Comédia", "Romance", "Suspense", "Drama"};
    private JComboBox<String> comboGen = new JComboBox<>(vetGen);

    private JLabel lID = new JLabel("ID");
    private JTextField txtID = new JTextField(10);

    GridBagLayout bag = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();

    private JButton bntSalvar = new JButton("Salvar");
    private JButton bntCan = new JButton("Cancelar");

    ArrayList<Filmes> arrayFil = new ArrayList<Filmes>();

    public Cadastro(){
        super("Tela de cadastro", true, true, true, true);
        setSize(500, 300);
        setLayout(bag);

        try{
            MaskFormatter mask = new MaskFormatter("###.###-##");
            txtID = new JFormattedTextField(mask);
        }

        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro ao tentar adicionar a mascára " + e.getMessage());
        }

        // Look and feel //
        try{
            for(LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
                if(("GTK+").equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
        }

        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro " + e.getMessage());
        }
        
        // Adicionando os componentes //
        constraints.fill = GridBagConstraints.BOTH;
        addComponent(lTil, 0, 0, 1, 1);
        addComponent(txtTil, 1, 0, 2, 1);

        addComponent(lAno, 0, 1, 1, 1);
        addComponent(txtAno, 1, 1 ,2, 1);
        
        addComponent(lID, 0, 2, 1, 1);
        addComponent(txtID, 1, 2, 1, 1);
        addComponent(comboGen, 2, 2, 1, 1);

        addComponent(bntSalvar, 1, 3, 1, 1);
        addComponent(bntCan, 2, 3, 1, 1);

        setVisible(true);

        // Tirando a máscara //
        String id1 = txtID.getText().replaceAll("[. -]", "");

        String telefone = txtID.getText().replaceAll("[. -]","");

        System.out.println("O valor do id é " + telefone);

        //int id = Integer.parseInt(id1); 

        //String titulo = txtTil.getText();
        //int ano = Integer.parseInt(txtAno.getText());
        //String genero = String.valueOf(comboGen.getSelectedItem());

        // Fazendo o método salvar //
        //Filmes filmes = new Filmes(titulo, ano, genero, id);

        
    }

    public void addComponent(Component c, int x, int y, int width, int height){
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = width;
        constraints.gridheight = height;

        bag.setConstraints(c, constraints);
        add(c);
    }
}
