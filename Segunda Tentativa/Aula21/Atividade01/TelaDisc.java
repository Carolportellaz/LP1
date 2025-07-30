import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaDisc extends JInternalFrame{
    private JLabel lPer = new JLabel("Período");
    private String [] vetPer = new String[8];
    private JComboBox<String> comboPer;
    private int qtdPer = 8;

    private JLabel lDesc = new JLabel("Descrição");
    private JTextField txtDesc = new JTextField(5);

    private JLabel lCH = new JLabel("Carga horária");
    private JTextField txtCH = new JTextField(5);

    private JLabel lEmenta = new JLabel("Ementa");
    private JTextArea areaEmenta = new JTextArea(40,40);

    private JButton bntSalvar = new JButton("Salvar");

    private JPanel panelBnt = new JPanel();
    private JPanel panelEmenta = new JPanel();

    private GridBagLayout bag = new GridBagLayout();
    private GridBagConstraints constraints = new GridBagConstraints();

    BD bd;
    boolean isCorreto;

    private int id;
    private int periodo;
    private String descricao;
    private String ementa;
    private int ch;

    private Connection con;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;

    public TelaDisc(){
        super("Cadastro de disciplinas",true, true, true, true);
        setSize(500,210);
        setLayout(bag);

        // Adicionando os períodos no combobox //
        for(int i = 0; i < qtdPer; i++){
            vetPer[i] = (i+ 1) + "º";
        }

        comboPer = new JComboBox<String>(vetPer);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(1, 1, 1, 1);
        addComponent(lPer, 0, 0, 1, 1);
        addComponent(comboPer, 1, 0, 1, 1);

        addComponent(lDesc, 0, 1, 1, 1);
        addComponent(txtDesc, 1, 1, 3, 1);

        addComponent(lCH, 0, 2, 1, 1);
        addComponent(txtCH, 1, 2, 1, 1);
        addComponent(new JLabel("      "), 2,2,1,1);

        panelEmenta.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelEmenta.add(areaEmenta);

        panelBnt.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelBnt.add(bntSalvar);

        addComponent(lEmenta, 0, 3, 1, 1);
        addComponent(areaEmenta,1, 3, 3, 4);
        
        addComponent(new JLabel("           "), 0, 4, 1, 1);
        addComponent(new JLabel("           "), 0, 5, 1, 1);
        addComponent(new JLabel("           "), 0, 6, 1, 1);


        addComponent(panelBnt, 3, 7, 1, 1);

        bntSalvar.addActionListener(new Eventos());

        // Criando uma instância com o banco de dados //
        bd = new BD();
    }


    public void addComponent(Component c, int x, int y, int width, int height){
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridheight = height;
        constraints.gridwidth = width;

        bag.setConstraints(c, constraints);
        add(c);
    }

    private class Eventos implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == bntSalvar){
                try{
                    periodo = comboPer.getSelectedIndex() + 1;
                    descricao = txtDesc.getText();
                    ementa = areaEmenta.getText();
                    ch = Integer.parseInt(txtCH.getText());
                    isCorreto = true;
                }

                catch(Exception e){
                    isCorreto = false;
                    System.out.println("Informe um valor válido para os campos");
                }
                
                if(isCorreto == true){
                    try{
                        con = bd.conectar();
                    }

                    catch(Exception e){
                        System.out.println("Ocorreu o seguinte erro ao tentar conectar no banco " + e.getMessage());
                    }

                    try{
                        pst = con.prepareStatement("insert into (periodo, descricao, ementa, ch) values (?, ?, ? , ?)");
                    }

                    catch(Exception e){
                        System.out.println("Ocorreu o seguinte erro ao realizar a consulta " + e.getMessage());
                    }
                }
            }
        }
    }
}
    
