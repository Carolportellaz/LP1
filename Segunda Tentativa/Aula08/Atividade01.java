// Salvar os dados

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// Fazer classe interna anônima e lambida 

public class Atividade01 extends JFrame {
    JPanel panel = new JPanel();

    JLabel lNome = new JLabel("Nome");
    JTextField txtNome = new JTextField(5);

    JLabel lGenero = new JLabel("Gênero");

    String [] vet_genero = {"Feminino", "Masculino"};

    JComboBox<String> combo_genero = new JComboBox<String>(vet_genero);

    JLabel lFuma = new JLabel("Fuma?");

    ButtonGroup groupFuma = new ButtonGroup();
    JRadioButton radioFumaS = new JRadioButton("Sim");
    JRadioButton radioFumaN = new JRadioButton("Não");

    JLabel lBebe = new JLabel("Bebe?");

    ButtonGroup groupBebe = new ButtonGroup();
    JRadioButton radioBebeS = new JRadioButton("Sim");
    JRadioButton radioBebeN = new JRadioButton("Não");

    JLabel lHist = new JLabel("Histórico familiar");


    JCheckBox boxCan = new JCheckBox("Câncer");
    JCheckBox boxOst = new JCheckBox("Osteporose");
    JCheckBox boxHem = new JCheckBox("Hemorroida"); 
    JCheckBox boxAnem = new JCheckBox("Anemia"); 
    JCheckBox boxDiab = new JCheckBox("Diabetes");
    JCheckBox boxDalt = new JCheckBox("Daltonismo");
    JCheckBox boxHep = new JCheckBox("Hepatite");
    JCheckBox boxSind = new JCheckBox("Síndrome de Patau");


    GridLayout grid = new GridLayout(13,2);

    JLabel lValor = new JLabel("Valor Total");
    JTextField txtValor = new JTextField(5);

    JButton bnt = new JButton("Limpar");

    int valor;

    public Atividade01(){
        super("Seguro de Vida");
        
        panel.add(lNome);
        panel.add(txtNome);
        panel.add(lGenero);
        panel.add(combo_genero);

        // Adicionando no group //
        groupBebe.add(radioBebeN);
        groupBebe.add(radioBebeS);

        groupFuma.add(radioFumaN);
        groupFuma.add(radioFumaS);

        panel.add(lFuma);
        panel.add(new JLabel(""));
        panel.add(radioFumaS);
        panel.add(radioFumaN);

        panel.add(lBebe);
        panel.add(new JLabel(""));
        panel.add(radioBebeS);
        panel.add(radioBebeN);

        // Adicionando no checkbox //
        panel.add(lHist);
        panel.add(new JLabel(""));

        panel.add(boxCan);
        panel.add(boxOst);
        panel.add(boxHem);
        panel.add(boxAnem);
        panel.add(boxDiab);
        panel.add(boxDalt);
        panel.add(boxHep);
        panel.add(boxSind);

        try{
            
        }

        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro " + e.getMessage());
        }

        panel.add(lValor);
        panel.add(txtValor);

        panel.add(new JLabel(""));
        panel.add(bnt);

        panel.setLayout(grid);        

        setContentPane(panel);
        pack();

        primeira_rodada();
        setVisible(true);

        // Classe interna anônima //
        combo_genero.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event){

                // DÚVIDAS PARA O LEO //
                // Nesse caso eu preciso desse if ou ele só vai fazer no combo? //
                if(event.getStateChange() == ItemEvent.SELECTED){
                    String genero = combo_genero.getSelectedItem().toString();

                    if(genero.equals("Feminino")){
                        valor = valor - 200;
                        txtValor.setText("" + valor);
                    }

                    else{
                        valor = valor + 200;
                        txtValor.setText("" + valor);
                    }
                }
            }
        });

        radioBebeS.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event){
                if(event.getStateChange() == ItemEvent.SELECTED){
                    valor = valor + 250;
                    txtValor.setText(""+valor);
                }
            }
        });

        radioBebeN.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event){
                if(event.getStateChange() == ItemEvent.SELECTED){
                    valor = valor - 250;
                    txtValor.setText("" + valor);
                }
            }
        });

        boxCan.addItemListener(new Eventos());
        boxAnem.addItemListener(new Eventos());
        boxDalt.addItemListener(new Eventos());
        boxDiab.addItemListener(new Eventos());
        boxHem.addItemListener(new Eventos());
        boxHep.addItemListener(new Eventos());
        boxOst.addItemListener(new Eventos());
        boxSind.addItemListener(new Eventos());

        bnt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                if(event.getSource() == bnt){
                    primeira_rodada();
                }
            }
        });

    }

    // Classe interna //
    public class Eventos implements ItemListener{
        public void itemStateChanged(ItemEvent event){
            if(event.getStateChange() == ItemEvent.SELECTED){

                if(boxAnem.isSelected() == true){
                    valor = valor + 50;
                }

                valor = valor + 100;
                txtValor.setText("" + valor);
                
            }

            if(event.getStateChange() == ItemEvent.DESELECTED){
                if(event.getItem() == boxAnem){
                    valor = valor - 50;
                }

                valor = valor - 100;
                txtValor.setText("" + valor);
            }
        }
    }

    // Primeira rodada //
    public void primeira_rodada(){

        try{
            valor = 1000;

            radioBebeN.setSelected(true);
            radioFumaN.setSelected(true);            

            boxAnem.setSelected(false);
            boxCan.setSelected(false);
            boxDalt.setSelected(false);
            boxDiab.setSelected(false);
            boxHem.setSelected(false);
            boxHep.setSelected(false);
            boxOst.setSelected(false);
            boxSind.setSelected(false);
    
            txtNome.setText("");
            txtValor.setText(String.valueOf(valor));

        }
        
        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro " + e.getMessage());
        }
    }


    public static void main (String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new Atividade01();
            }
        });
    }
}
