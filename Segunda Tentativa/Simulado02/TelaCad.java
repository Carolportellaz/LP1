import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaCad extends JFrame{
    private JMenu menuCad = new JMenu("Cadastro");
    private JMenu menuDes = new JMenu("Despesas");

    private JMenuItem itemSalvar = new JMenuItem("Salvar");
    private JMenuItem itemReg = new JMenuItem("Registrar despesa");

    private JMenuBar bar = new JMenuBar();

    private JTabbedPane tab = new JTabbedPane();

    private JLabel lNome = new JLabel("Nome");
    private JTextField txtNm = new JTextField(10);

    JButton bntSalvar = new JButton("Salvar");

    JLabel lData = new JLabel("Data de nascimento");
    JLabel lTel = new JLabel("Telefone");

    JLabel lEmail = new JLabel("Email");
    JTextField txtEmail = new JTextField(10);

    JLabel lSal = new JLabel("Salário");
    JLabel lRs = new JLabel("R$");
    JTextField txtSal = new JTextField(10);

    JLabel lmsg = new JLabel("Total gasto até o momento: R$ 0,00 - Saldo restante: R$ 0,00");

    JPanel panelDes = new JPanel();
    JPanel panelInfo = new JPanel();

    GridBagConstraints constraints = new GridBagConstraints();
    GridBagLayout bag = new GridBagLayout();

    GridBagLayout bag2 = new GridBagLayout();


    JFormattedTextField txtData;
    JFormattedTextField txtTel;


    // Tela de despesa //
    JLabel lDesc = new JLabel("Descrição");
    JTextField txtDesc = new JTextField(10);

    JButton bntReg = new JButton("Registrar");

    JLabel lData2 = new JLabel("Data");
    JFormattedTextField txtData2;

    JLabel lValor = new JLabel("Valor   R$");
    JTextField txtValor = new JTextField(10);

    JLabel lGastos = new JLabel("Gastos mensais");
    JTextArea area = new JTextArea(3, 30);

    JLabel lmsg2 = new JLabel("Total de gastos até o momento: R$: 1036,00 - Saldo restante: R$ 464,00");

    // Fazendo a parte de salvamento de dados //
    ArrayList<Pessoa> arrayP = new ArrayList<Pessoa>();

    JPanel panelMsg = new JPanel();

    public TelaCad(){
        setSize(500,220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Adicionando no menu //
        menuCad.add(itemSalvar);
        menuDes.add(itemReg);

        bar.add(menuCad);
        bar.add(menuDes);
        setJMenuBar(bar);

        // Adicionando as mascaras //
        try{
            MaskFormatter maskData = new MaskFormatter("##/##/####");
            MaskFormatter maskTel = new MaskFormatter("(##)#####-####");
            MaskFormatter maskData2 = new MaskFormatter("##/##/####");

            txtData = new JFormattedTextField(maskData);
            txtTel = new JFormattedTextField(maskTel);
            txtData2 = new JFormattedTextField(maskData2);

        }

        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro nas mascaras " + e.getMessage());
        }

        // Adicionando componentes no panel //
        panelInfo.setLayout(bag);

        constraints.fill = GridBagConstraints.BOTH;
        addComponente(lNome, 0, 0, 1,1);
        addComponente(txtNm, 0, 1, 4, 1);
        addComponente(bntSalvar, 0, 5, 1, 1);

        addComponente(lData, 1, 0, 1, 1);
        addComponente(txtData, 1, 1, 2, 1);
        addComponente(lTel, 1, 3, 1, 1);
        addComponente(txtTel, 1, 4, 1, 1);

        addComponente(lEmail, 2, 0, 1, 1);
        addComponente(txtEmail, 2, 1, 4, 1);

        addComponente(lSal, 3, 0, 1, 1);
        addComponente(lRs, 3, 1, 1, 1);
        addComponente(txtSal, 3, 2, 1, 1);

        // Despesas // 
        addComponente2(lDesc, 0, 0, 1, 1);
        addComponente2(txtDesc, 0, 1, 3, 1);
        addComponente2(bntReg, 0, 4, 1, 1);

        addComponente2(lData2, 1, 0, 1, 1);
        addComponente2(txtData2, 1, 1, 1, 1);
        addComponente2(lValor, 1, 2, 1, 1);
        addComponente2(txtValor, 1, 3, 1, 1);

        addComponente2(lGastos, 2, 0, 1, 1);

        addComponente2(area, 3, 0, 5, 3);

        tab.addTab("Cadastro", panelInfo);
        tab.addTab("Despesas", panelDes);

        panelDes.setLayout(bag2);

        panelMsg.add(lmsg);

        panelMsg.setLayout(new FlowLayout(FlowLayout.LEFT));

        add(tab, BorderLayout.CENTER);
        add(panelMsg, BorderLayout.SOUTH);


        setVisible(true);
        

        // Lógica //
        bntSalvar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                try{
                    // Realizando cadastro //
                    String nome = txtNm.getText();
                    String email = txtEmail.getText();
                    Double salario = 0.0;

                    try{
                        salario = Double.parseDouble(txtSal.getText());
                    }

                    catch(Exception e){
                        System.out.println("Informe valores válidos para o salário");
                    }

                    String data = txtData.getText();
                    String telefone = txtTel.getText();

                    Pessoa p = new Pessoa(nome, data, email, salario, telefone);


                    // Tratamento de erro para o nome //
                    if( (txtNm.getText().equals("")) || (txtData.getText().equals("")) || (txtSal.getText().equals("")) || (txtTel.getText().equals("")) || (txtEmail.getText().equals("")) ){
                        System.out.println("Não informe campos vazios");
                    }

                    else{
                        arrayP.add(p);
                    }
                }

                catch(Exception e){
                    System.out.println("Ocorreu o seguinte erro no cadastro de dados" + e.getMessage());
                }
                
                Serializacao ser = new Serializacao();
                ser.add(arrayP);
            }
            
        });
    }

    public void addComponente(Component c, int x, int y, int width, int height){
        constraints.gridx = y;
        constraints.gridy = x;
        constraints.gridwidth = width;
        constraints.gridheight = height;

        panelInfo.add(c);
        bag.setConstraints(c, constraints);
    }

    public void addComponente2(Component c, int x, int y, int width, int height){
        constraints.gridx = y;
        constraints.gridy = x;
        constraints.gridwidth = width;
        constraints.gridheight = height;

        panelDes.add(c);
        bag2.setConstraints(c, constraints);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new TelaCad();
            }
        });
    }
}