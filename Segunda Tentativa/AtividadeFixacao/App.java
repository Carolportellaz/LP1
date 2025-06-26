import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;

import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.InternalFrameListener;

public class App  extends JFrame{
    private JMenu menuOp = new JMenu("Operações");
    private JMenuItem itemCad = new JMenuItem("Cadastro");
    private JMenuItem itemSair = new JMenuItem("Sair");
    private JMenuBar bar = new JMenuBar();

    private JDesktopPane desktop;

    public App(){
        super("Cadastro de filmes");
        setSize(700,700);
        setLocationRelativeTo(null);

        setJMenuBar(bar);

        // Adicionando na barra //
        menuOp.add(itemCad);
        menuOp.add(itemSair);

        bar.add(menuOp);

        desktop = new JDesktopPane();

        setContentPane(desktop);

        setVisible(true);

        // Fazendo o look and feel - Lembrar que precisa estar dentro de um try - catch //
        try{
            for(LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
                System.out.println(info.getName());

                if(("Nimbus").equals(info.getName())){
                    // Por que aqui eu pego o nome da classe? //
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        
        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro " + e.getMessage());
        }

        

        itemCad.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Cadastro cad = new Cadastro();
                desktop.add(cad);
                cad.setVisible(true);
                try {
                    cad.setSelected(true);
                } 
                
                catch (PropertyVetoException e) {
                    e.printStackTrace();
                }
            }
      });
    }


    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new App();
            }
        });
    }
}
