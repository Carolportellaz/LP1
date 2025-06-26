import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.text.MaskFormatter;

public class Cadastro extends JInternalFrame {
    private JLabel lTil = new JLabel("Título");
    private JFormattedTextField txtTil = new JFormattedTextField();

    private JLabel lAno = new JLabel("Ano");
    private JTextField txtAno = new JTextField(10);

    private JLabel lGen = new JLabel("Gênero");
    String vetGen[] = { "Terror", "Ação", "Comédia", "Romance", "Suspense", "Drama" };
    private JComboBox<String> comboGen = new JComboBox<>(vetGen);

    private JLabel lID = new JLabel("ID");
    private JTextField txtID = new JTextField(10);

    GridBagLayout bag = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();

    private JButton bntSalvar = new JButton("Salvar");
    private JButton bntCan = new JButton("Cancelar");
    private JButton bntEditar = new JButton("Editar");
    private JButton bntExcluir = new JButton("Excluir");
    private JButton bntProx = new JButton("Próximo");
    private JButton bntAnt = new JButton("Anterior");

    ArrayList<Filmes> arrayFil = new ArrayList<Filmes>();

    int ultimo;
    int posicao;

    Persistência per = new Persistência();
    String filename = "dados.ser";

    public Cadastro() {
        super("Tela de cadastro", true, true, true, true);
        setSize(500, 300);
        setLayout(bag);

        try {
            MaskFormatter mask = new MaskFormatter("###.###-##");
            txtID = new JFormattedTextField(mask);
        }

        catch (Exception e) {
            System.out.println("Ocorreu o seguinte erro ao tentar adicionar a mascára " + e.getMessage());
        }

        // Adicionando os componentes //
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        addComponent(lTil, 0, 0, 1, 1);
        addComponent(txtTil, 1, 0, 2, 1);

        addComponent(lAno, 0, 1, 1, 1);
        addComponent(txtAno, 1, 1, 2, 1);

        addComponent(lID, 0, 2, 1, 1);
        addComponent(txtID, 1, 2, 1, 1);
        addComponent(comboGen, 2, 2, 1, 1);

        addComponent(bntSalvar, 1, 3, 1, 1);
        addComponent(bntCan, 2, 3, 1, 1);

        addComponent(bntEditar, 1, 4, 1, 1);
        addComponent(bntExcluir, 2, 4, 1, 1);

        addComponent(bntProx, 1, 5, 1, 1);
        addComponent(bntAnt, 2, 5, 1, 1);

        carregarFilmes(0);

        setVisible(true);

        bntSalvar.addActionListener(new Eventos());
        bntAnt.addActionListener(new Eventos());
        bntProx.addActionListener(new Eventos());

    }

    public void addComponent(Component c, int x, int y, int width, int height) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = width;
        constraints.gridheight = height;

        bag.setConstraints(c, constraints);
        add(c);
    }

    private class Eventos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == bntSalvar) {
                try{
                    // Tirando a máscara //
                    String id1 = txtID.getText().replaceAll("[. -]", "");

                    int id = Integer.parseInt(id1);

                    String titulo = txtTil.getText();
                    int ano = Integer.parseInt(txtAno.getText());
                    String genero = String.valueOf(comboGen.getSelectedItem());



                    // Fazendo o método salvar //
                    Filmes filmes = new Filmes(titulo, ano, genero, id);

                    arrayFil.add(filmes);

                    per.gravarFilmes(arrayFil, filename);

                    ultimo = arrayFil.size() - 1;

                    carregarFilmes(posicao);
                }

                // Tratamento de erros //
                catch(Exception e){
                    System.out.println("Ocorreu erro o seguinte erro");
                }

                
            }

            if(event.getSource() == bntAnt){
                if(posicao - 1 < 0){
                    System.out.println("Não há anteriores");
                }

                else{
                    posicao = posicao - 1;
                    carregarFilmes(posicao);
                }
            }

            if(event.getSource() == bntProx){
                if(posicao + 1 > arrayFil.size() - 1){
                    System.out.println("Não há próximos filmes");
                }

                else{
                    posicao = posicao + 1;
                    carregarFilmes(posicao);
                }
            }

        }

    }

    public void carregarFilmes(int posicao) {
        if (arrayFil.isEmpty()) {
            System.out.println("Cadastre um usuário para visualizar");
        }

        else {
            arrayFil = per.carrgarFilmes("dados.ser");

            Filmes f = arrayFil.get(posicao);

            comboGen.setSelectedItem(f.getGenero());
            txtAno.setText(String.valueOf(f.getAno()));
            txtID.setText(String.valueOf(f.getId()));
            txtTil.setText(String.valueOf(f.getId()));
        }
    }

}
