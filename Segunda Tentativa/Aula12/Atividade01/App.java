import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class App extends JFrame{
    private JLabel lNome = new JLabel("Nome:");
    private JTextField txtNome = new JTextField(10);

    private JComboBox<String> comboLay = new JComboBox<String>();

    private JLabel lEst = new JLabel("Qual a sua estação preferida?");
    private ButtonGroup groupEst = new ButtonGroup();
    private JRadioButton radioOut  = new JRadioButton("Outono");
    private JRadioButton radioPrimavera = new JRadioButton("Primavera");
    private JRadioButton radioVerao = new JRadioButton("Verao");
    private JRadioButton radioInverno = new JRadioButton("Inverno");

    private JLabel lPerso = new JLabel("Como você definiria a sua personalidade? ");
    private JCheckBox boxCal = new JCheckBox("Calma");
    private JCheckBox boxAn = new JCheckBox("Ansiosa");
    private JCheckBox boxApress = new JCheckBox("Apressada");
    private JCheckBox boxComp = new JCheckBox("Competitiva");
    private JCheckBox boxTrambinqueira = new JCheckBox("Tranbiqueira");
    private JCheckBox boxAmorosa = new JCheckBox("Amorosa");
    private JCheckBox boxTimida = new JCheckBox("Timida");
    private JCheckBox boxAnt = new JCheckBox("Antissocial");
    private JCheckBox boxDesas = new JCheckBox("Desastrada");
    private JCheckBox boxExt = new JCheckBox("Extrovertida");


    private JLabel lEstilo  = new JLabel("Qual desses é o seu estilo");
    private ButtonGroup groupEstilo = new ButtonGroup();
    private JRadioButton radioRitinha = new JRadioButton("Ritinha do Outro Lado do paraíso");
    private JRadioButton radioFatinha = new JRadioButton("Fatinha de malhação");
    private JRadioButton radioSharpay = new JRadioButton("Sharpay Evans (HSM)");
    private JRadioButton radioGab = new JRadioButton("Gabriela (Troy)");
    private JRadioButton radioRav = new JRadioButton("Ravena (Jovens Titãs)");
    private JRadioButton radioBibi = new JRadioButton("Bibi");

    private JButton bnt = new JButton("Resultado");

    private String [] vetEsp = {"Vôlei", "Basquete", "Natação", "Queimada", "Ballet", "Futebol", "Dança", "Outro"};
    private DefaultListModel<String> modelP = new DefaultListModel<String>();
    private JList<String> listEsp = new JList<String>();

    private GridLayout grid = new GridLayout(16, 2);

    // Pontuação //
    Winx [] vetWinx = new Winx[6];


    public App(){
        setLayout(grid);
        setSize(600,600);
        setResizable(true);

        try{
            for(LookAndFeelInfo i : UIManager.getInstalledLookAndFeels()){
                System.out.println(i.getName());   
                
                comboLay.addItem(i.getName());
            }
        }

        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro " + e.getMessage());
        }

        // Adicionando os elementos na lista //
        for(int i = 0; i < vetEsp.length; i++){
            modelP.addElement(vetEsp[i]);
        }

        listEsp.setModel(modelP);

        // Adicionando no frame //
        try{
            add(new JLabel("Escolha o layout"));
            add(comboLay);

            add(lNome);
            add(txtNome);


            // Adicionando os estação //
            groupEst.add(radioOut);
            groupEst.add(radioPrimavera);
            groupEst.add(radioVerao);
            groupEst.add(radioInverno);


            add(lEst);
            add(new JLabel(""));
            add(radioOut);
            add(radioPrimavera);
            add(radioVerao);
            add(radioInverno);

            // Adicionando personalidade //
            add(lPerso);
            add(new JLabel(""));
            add(boxCal); 
            add(boxAn);     
            add(boxApress);     
            add(boxComp);     
            add(boxTrambinqueira);  
            add(boxAmorosa);
            add(boxTimida);  
            add(boxAnt); 
            add(boxDesas);
            add(boxExt);

            // Adicionando o estilo //
            groupEstilo.add(radioFatinha);
            groupEstilo.add(radioRitinha);
            groupEstilo.add(radioSharpay);
            groupEstilo.add(radioGab);
            groupEstilo.add(radioRav);
            groupEstilo.add(radioBibi);

            add(lEstilo);
            add(new JLabel(""));
            add(radioFatinha);
            add(radioRitinha);
            add(radioSharpay);
            add(radioGab);
            add(radioRav);
            add(radioBibi);

            JPanel panel = new JPanel();
            panel.add(bnt);

            panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            add(new JLabel(""));
            add(panel);

            // Lógica //
            radioOut.addItemListener(new Eventos());
            radioPrimavera.addItemListener(new Eventos());
            radioVerao.addItemListener(new Eventos());
            radioInverno.addItemListener(new Eventos());

            boxAmorosa.addItemListener(new Eventos());
            boxAn.addItemListener(new Eventos());
            boxApress.addItemListener(new Eventos());
            boxCal.addItemListener(new Eventos());
            boxComp.addItemListener(new Eventos());
            boxExt.addItemListener(new Eventos());
            boxDesas.addItemListener(new Eventos());
            boxAnt.addItemListener(new Eventos());
            boxTimida.addItemListener(new Eventos());
            boxTrambinqueira.addItemListener(new Eventos());

            setVisible(true);

            // Adicionando os personagens //
            vetWinx[0] = new Winx("Bloom", 0, null);
            vetWinx[1] = new Winx("Stella", 0, null);
            vetWinx[2] = new Winx("Flora", 0, null);
            vetWinx[3] = new Winx("Musa", 0, null);
            vetWinx[4] = new Winx("Tecna", 0, null);
            vetWinx[5] = new Winx("Laila", 0, null);

        }

        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro " + e.getMessage());
        }

        // Olhando os look and feel //

        comboLay.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent event) {
                try{
                    Object escolha = comboLay.getSelectedItem();
        
                    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
                        if(escolha.equals(info.getName())){
                            UIManager.setLookAndFeel(info.getClassName());

                            SwingUtilities.updateComponentTreeUI(App.this);
                            break;
                        }
                    }
                }

                catch(Exception e){
                    System.out.println("Ocorreu o seguinte erro " + e.getMessage());
                }
            }
            
        });

        bnt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                if(event.getSource() == bnt){

                    try{
                        int maiorP = vetWinx[0].getPontos();
                        String maiorN = "";
    
                        for(int i = 0; i < vetWinx.length; i++){
                            if(vetWinx[i].getPontos() >= maiorP){
                                maiorP = vetWinx[i].getPontos();
                                maiorN = vetWinx[i].getNome();
                            }
                        }
    
                        JOptionPane.showMessageDialog(null, maiorN);
                    }

                    catch(Exception e){
                        System.out.println("Ocorreu o seguinte erro no botão " + e.getMessage());
                    }
                    
                }
            }
        });

        
        
    }

    private class Eventos implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent event) {
            try{

                System.out.println("O valor de " + vetWinx[3]);
                if(radioOut.isSelected()){
                    vetWinx[3].setPontos(vetWinx[3].getPontos() + 1);
                    vetWinx[5].setPontos(vetWinx[5].getPontos() + 1);
                }
    
                if(radioInverno.isSelected()){
                    vetWinx[4].setPontos(vetWinx[4].getPontos() + 1);
                }
    
                if(radioVerao.isSelected()){
                    vetWinx[0].setPontos(vetWinx[0].getPontos() + 1);
                    vetWinx[1].setPontos(vetWinx[1].getPontos() + 1);
                }
    
                if(radioPrimavera.isSelected()){
                    vetWinx[2].setPontos(vetWinx[2].getPontos() + 1);
                }

                // Calma //
                if(event.getItem() == boxCal){
                    if(boxCal.isSelected()){
                        vetWinx[2].setPontos(vetWinx[2].getPontos() + 1);
                    }

                    else{
                        vetWinx[2].setPontos(vetWinx[2].getPontos() - 1);

                    }
                }

                // Ansiosa //
                if(event.getItem() == boxAn){
                    if(boxAn.isSelected()){
                        vetWinx[0].setPontos(vetWinx[0].getPontos() + 1);
                    }

                    else{
                        vetWinx[0].setPontos(vetWinx[0].getPontos() - 1);
                    }
                }

                // Apressada //
                if(event.getItem() == boxApress){
                    if(boxApress.isSelected()){
                        vetWinx[1].setPontos(vetWinx[1].getPontos() + 1);
                    }

                    else{
                        vetWinx[1].setPontos(vetWinx[1].getPontos() - 1);
                    }
                }

                // Competitiva //
                if(event.getItem() == boxComp){
                    if(boxCal.isSelected()){
                        vetWinx[4].setPontos(vetWinx[4].getPontos() + 1);

                    }

                    else{
                        vetWinx[4].setPontos(vetWinx[4].getPontos() - 1);
                    }
                }

                // Tranbiqueira //
                if(event.getItem() == boxTrambinqueira){
                    if(boxTrambinqueira.isSelected()){
                        vetWinx[1].setPontos(vetWinx[1].getPontos() + 1);
                    }

                    else{
                        vetWinx[1].setPontos(vetWinx[1].getPontos() - 1);
                    }
                }

                // Amorosa //
                if(event.getItem() == boxAmorosa){
                    if(boxAmorosa.isSelected()){
                        vetWinx[5].setPontos(vetWinx[5].getPontos() + 1);
                    }

                    else{
                        vetWinx[5].setPontos(vetWinx[5].getPontos() - 1);
                    }
                }

                // Timida //
                if(event.getItem() == boxTimida){
                    if(boxTimida.isSelected()){
                        vetWinx[3].setPontos(vetWinx[3].getPontos() + 1);
                    }

                    else{
                        vetWinx[3].setPontos(vetWinx[3].getPontos() - 1);
                    }
                }

                // Antissocial //
                if(event.getItem() == boxAnt){
                    if(boxAnt.isSelected()){
                        vetWinx[4].setPontos(vetWinx[4].getPontos() + 1);
                    }

                    else{
                        vetWinx[4].setPontos(vetWinx[4].getPontos() - 1);
                    }
                }

                // Instrovertido //
                if(event.getItem() == boxDesas){
                    if(boxDesas.isSelected()){
                        vetWinx[0].setPontos(vetWinx[0].getPontos() + 1);
                    }

                    else{
                        vetWinx[0].setPontos(vetWinx[0].getPontos() - 1);
                    }
                }

                // Extrovertido //
                if(event.getItem() == boxExt){
                    if(boxExt.isSelected()){
                        vetWinx[1].setPontos(vetWinx[1].getPontos() + 1);
                    }

                    else{
                        vetWinx[1].setPontos(vetWinx[1].getPontos() - 1);
                    }
                }
            }
            
            catch(Exception e){
                System.out.println("Ocorreu o seguinte erro no item" + e.getMessage());
            }
        }

    }

    public static void main (String args[]){
        App app = new App();
    }
}