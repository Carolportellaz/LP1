import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;

public class Tela extends JFrame{
    private JLabel lNmA = new JLabel("Nome do aluno");
    private JTextField txtA = new JTextField(10);

    private JLabel lNmDis = new JLabel("Disciplina");
    JComboBox<String> comboDis = new JComboBox<>();

    private GridBagLayout bag = new GridBagLayout();
    private GridBagConstraints constraints = new GridBagConstraints();

    private JButton bntSalvar = new JButton("Salvar");

    ProvaF prova = new ProvaF();
    ArrayList<String> arrayDis = new ArrayList<>();
    String [] vet;

    int qtd = 0;

    public Tela(){
        super("Cadastro de alunos");
        setLayout(bag);
        setSize(500,150);

        // Adicionando no combo //
        try{
            arrayDis = prova.carregaDis();
            int tamanho = arrayDis.size();

            vet = new String[tamanho];

            for(int i = 0; i < vet.length; i++){
                vet[i] = arrayDis.get(i);
            }

            comboDis = new JComboBox<String>(vet);
        }

        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro ao tentar carregar as disciplinas " + e.getMessage());
        }

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        panel.add(bntSalvar);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        addComponent(lNmA, 0, 0, 1, 1);
        addComponent(txtA, 1, 0, 2, 1);

        addComponent(lNmDis, 0, 1, 1, 1);
        addComponent(comboDis, 1, 1, 1, 1);

        addComponent(new JLabel(""), 0, 2, 1, 1);
        addComponent(panel, 1, 2, 1, 1);

        setVisible(true);

        bntSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
               String nomeA = txtA.getText();
               String nomeD = String.valueOf(comboDis.getSelectedItem());

               try{
                    prova.inserir(nomeA, nomeD);
               }

               catch(Exception e){
                    System.out.println("Ocorreu o seguinte erro ao tentar inserir " + e.getMessage());
               }
            }
        });

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
