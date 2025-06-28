import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.PopupMenuListener;
import javax.swing.text.MaskFormatter;

public class Cadastro extends JInternalFrame {
    JButton bntNovo = new JButton("Novo");
    JButton bntSalvar = new JButton("Salvar");
    JButton bntOutros = new JButton("Ver outros");
    TitledBorder title = new TitledBorder("Navegação");

    JPanel panelBNT = new JPanel();
    JPanel panelP = new JPanel();

    JLabel lNm = new JLabel("Nome");
    JTextField txtNm = new JTextField(10);

    JLabel lCpf = new JLabel("CPF");
    JFormattedTextField txtCPF;

    JLabel lData = new JLabel("Data de Nascimento");
    JFormattedTextField txtData;

    JButton bntAnt = new JButton("Anterior");
    JButton bntProx = new JButton("Próximo");

    JLabel lPosicao = new JLabel("Posição");

    String vetPos[] = { "Goleiro", "Zagueiro", "Lateral", "Meio-Campo", "Atacante" };
    JComboBox<String> combo = new JComboBox<>(vetPos);

    JPanel panelCombo = new JPanel();

    GridBagLayout bag = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();

    ArrayList<Jogador> arrayJog = new ArrayList<>();

    int ultima_posicao = 0;
    int posicao_atual = 0;

    Persistencia per = new Persistencia();

    JPopupMenu popLimpar = new JPopupMenu();
    JMenuItem itemLimpar = new JMenuItem("Limpar");

    public Cadastro() {
        super("Cadastro jogadores", false, true, false);
        setSize(500, 300);
        setLayout(bag);
        panelBNT.setLayout(new GridLayout(4, 1));
        panelBNT.setBorder(title);
        panelBNT.add(bntNovo);
        panelBNT.add(bntSalvar);
        panelBNT.add(bntOutros);
        panelBNT.add(new JLabel(""));

        // Adicionando mascaras //
        try {
            MaskFormatter mask = new MaskFormatter("###.###-##");
            txtCPF = new JFormattedTextField(mask);

            MaskFormatter mask2 = new MaskFormatter("##/##/####");
            txtData = new JFormattedTextField(mask2);
        }

        catch (Exception e) {
            System.out.println("Ocorreu o seguinte erro " + e.getMessage());
        }

        addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                try {
                    if (arrayJog != null) {
                        per.gravarJog(arrayJog, "dados.ser");
                    }
                }

                catch (Exception er) {
                    System.out.println("Ocorreu o seguinte erro ao tentar salvar " + er.getMessage());
                }
            }
        });

        // Carregando os dados no array //
        try {
            arrayJog = per.carregarJog("dados.ser");

            if (arrayJog != null) {
                txtCPF.setText(String.valueOf(arrayJog.get(0).getCpf()));
                txtData.setText(String.valueOf(arrayJog.get(0).getDataNas()));
                txtNm.setText(arrayJog.get(0).getNome());

                String posicao = arrayJog.get(0).getPosicao();

                combo.setSelectedItem(posicao);
            }
        }

        catch (Exception er) {
            JOptionPane.showMessageDialog(null, "Não há jogadores");
            System.out.println("Ocorreu o seguinte erro ao tentar carregar os dados " + er.getMessage());
        }

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 1;
        addComponent(lNm, 0, 0, 1, 1);
        addComponent(txtNm, 1, 0, 3, 1);

        addComponent(lCpf, 0, 1, 1, 1);
        addComponent(txtCPF, 1, 1, 1, 1);
        addComponent(lData, 2, 1, 1, 1);
        addComponent(txtData, 3, 1, 1, 1);

        // panelCombo.setLayout(new FlowLayout());
        // panelCombo.add(combo);

        addComponent(lPosicao, 0, 2, 1, 1);
        addComponent(combo, 1, 2, 3, 1);

        addComponent(new JLabel(" "), 0, 3, 2, 1);
        addComponent(bntAnt, 2, 3, 1, 1);
        addComponent(bntProx, 3, 3, 1, 1);

        addComponent(panelBNT, 4, 0, 1, 3);

        bntSalvar.addActionListener(new Eventos());
        bntNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                txtCPF.setText("");
                txtData.setText("");
                txtNm.setText("");
                combo.setSelectedItem("Goleiro");

                novo();
            }

        });

        // PRÓXIMO //
        bntProx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                try{
                    if (posicao_atual + 1 == arrayJog.size()) {
                        JOptionPane.showMessageDialog(null, "Não há próximos jogadores");
                    }

                    else {
                        posicao_atual = posicao_atual + 1;
                        exbirDados(posicao_atual);
                    }
                }

                catch(Exception e){
                    System.out.println("Ocorreu o seguinte erro " + e.getMessage());
                }
            }

        });

        // OUTROS //
        bntOutros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try{
                    if (event.getSource() == bntOutros) {
                        ArrayList<String> array = new ArrayList<>();

                        String nome = "";

                        for (int i = 0; i < arrayJog.size(); i++) {
                            nome = " | " + arrayJog.get(i).getNome();
                        }

                        JOptionPane.showMessageDialog(null, nome);

                    }
                }

                catch(Exception e){
                    System.out.println("Ocorreu o seguinte erro " + e.getMessage());
                }
                
            }

        });

        bntAnt.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent event) {

                    try{
                        if (posicao_atual - 1 == -1) {
                            JOptionPane.showMessageDialog(null, "Não há anteriores");
                        }

                        else {
                            posicao_atual = posicao_atual - 1;
                            exbirDados(posicao_atual);
                        }
                    }

                    catch(Exception e){
                        System.out.println("Ocorreu o seguinte erro " + e.getMessage());
                    }
                    
                }

        });


        // MENU POP - LIMPAR //
        popLimpar.add(itemLimpar);


        popLimpar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent event) {
                int x = event.getX();
                int y = event.getY();
            }
        });


        inicial();

        setVisible(true);
    }

    public void inicial() {
        if (arrayJog == null) {
            bntOutros.setEnabled(false);
        }

        bntSalvar.setEnabled(false);
        bntNovo.setEnabled(true);
        bntAnt.setEnabled(true);
        bntProx.setEnabled(true);
        bntOutros.setEnabled(true);

        if (arrayJog == null) {
            bntOutros.setEnabled(false);
            bntProx.setEnabled(false);
            bntAnt.setEnabled(false);
        }
    }

    public void novo() {
        bntSalvar.setEnabled(true);
        bntOutros.setEnabled(false);
        bntNovo.setEnabled(false);
        bntAnt.setEnabled(false);
        bntProx.setEnabled(false);

        if (arrayJog == null) {
            bntOutros.setEnabled(false);
            bntProx.setEnabled(false);
            bntAnt.setEnabled(false);
        }
    }

    public void exbirDados(int posicao_atual) {
        try {
            txtCPF.setText(String.valueOf(arrayJog.get(posicao_atual).getCpf()));
            txtData.setText(String.valueOf(arrayJog.get(posicao_atual).getDataNas()));
            txtNm.setText(String.valueOf(arrayJog.get(posicao_atual).getNome()));
            combo.setSelectedItem(arrayJog.get(posicao_atual).getPosicao());
        }

        catch (Exception e) {
            System.out.println("Ocorreu o seguinte erro " + e.getMessage());
        }

    }

    private class Eventos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            int cpf = 0;
            int data = 0;
            String nome = "";
            String posicao = "";
            boolean valido = true;

            if (event.getSource() == bntSalvar) {
                // Validação CPF //
                try {
                    String cpfS = txtCPF.getText().replaceAll("[.-]", "");
                    cpf = Integer.parseInt(cpfS);
                }

                catch (Exception e) {
                    valido = false;
                    JOptionPane.showMessageDialog(null, "Infome um cpf válido");
                    System.out.println(
                            "Ocoreu o seguinte erro " + e.getMessage() + "\nInforme valores válidos para o CPF");
                }

                try {
                    String dataS = txtData.getText().replaceAll("[/]", "");
                    data = Integer.parseInt(dataS);
                }

                catch (Exception e) {
                    valido = false;
                    JOptionPane.showMessageDialog(null, "Informe uma data válida");
                    System.out.println(
                            "Ocorreu o seguinte erro " + e.getMessage() + " \nInforma valores válidos para a data");
                }

                try {
                    nome = txtNm.getText();
                    posicao = combo.getSelectedItem().toString();
                }

                catch (Exception e) {
                    valido = false;
                    JOptionPane.showMessageDialog(null, "Informe uma posição válida");
                    System.out.println("Ocorreu o seguinte erro ao pegar nomes e posições " + e.getMessage());
                }

                if (valido == true) {
                    arrayJog.add(new Jogador(nome, cpf, posicao, data));

                    try {
                        per.gravarJog(arrayJog, "dados.ser");
                    }

                    catch (Exception e) {
                        System.out.println("Ocoreu o seguinte erro " + e.getMessage());
                    }

                    System.out.println("Jogador adicionado");

                    posicao_atual = arrayJog.size() - 1;
                    exbirDados(posicao_atual);
                    inicial();
                }

                else {
                    System.out.println("Jogador não adicionado");
                }

            }
        }

    }

    public void addComponent(Component c, int x, int y, int width, int height) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = width;
        constraints.gridheight = height;

        bag.setConstraints(c, constraints);
        add(c);
    }
}
