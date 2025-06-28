import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.*;

public class App extends JFrame {
    private JDesktopPane desk = new JDesktopPane();

    private JMenuBar bar = new JMenuBar();

    private JMenu menuArq = new JMenu("Arquivo");

    private JMenu menuCad = new JMenu("Cadastro");
    private JMenuItem itemJog = new JMenuItem("Jogador");

    private JMenu menuLay = new JMenu("Layout");
    private JCheckBoxMenuItem itemNimbus = new JCheckBoxMenuItem("Nimbus");
    private JCheckBoxMenuItem itemMetal = new JCheckBoxMenuItem("Metal");

    private JToolBar tool = new JToolBar();
    private JMenuItem itemN = new JMenuItem("N");
    private JMenuItem itemM = new JMenuItem("M");

    //private KeyStroke CtrlS = KeyStroke.getKeyStroke(")

    public App() {
        super("Cadastro jogadores de futebol");
        menuCad.add(itemJog);

        menuLay.add(itemNimbus);
        menuLay.add(new JSeparator());
        menuLay.add(itemMetal);

        menuArq.add(menuCad);
        menuArq.add(menuLay);
        
        setContentPane(desk);
        bar.add(menuArq);

        tool.add(itemN);
        tool.add(itemM);

        setSize(700, 700);
        setJMenuBar(bar);


        itemJog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if(event.getSource() == itemJog){
                    Cadastro cad = new Cadastro();
                    cad.dispose();
                         
                    desk.add(cad);
                    cad.setVisible(true);

                    
                    cad.isSelected();
                }
            }
            
        });

        

        itemMetal.addActionListener(new Eventos());
        itemNimbus.addActionListener(new Eventos());

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (info.getName().equals("Nimbus")) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            System.out.println("Entrou no nimbus");
            itemMetal.setSelected(false);

        }

        catch (Exception e) {
            System.out.println("Ocorreu o seguinte erro " + e.getMessage());
        }

        setVisible(true);
    }

    private class Eventos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == itemMetal) {
                try {
                    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if (info.getName().equals("Metal")) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }

                    System.out.println("Entrou no metal");

                }

                catch (Exception e) {
                    System.out.println("Ocorreu o seguinte erro " + e.getMessage());
                }

                itemNimbus.setSelected(false);
            }

            if (event.getSource() == itemNimbus) {
                try {
                    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if (info.getName().equals("Nimbus")) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }

                    System.out.println("Entrou no nimbus");
                    itemMetal.setSelected(false);

                }

                catch (Exception e) {
                    System.out.println("Ocorreu o seguinte erro " + e.getMessage());
                }
            }

        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new App();
            }
        });
    }

}
