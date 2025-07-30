import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class TelaEsc extends JFrame{
    private JMenu menuCad = new JMenu("Cadastro");
    private JMenuItem itemDisc = new JMenuItem("Disciplinas");
    private JMenuItem itemProf = new JMenuItem("Professores");
    private JMenuItem itemHor = new JMenuItem("Horários");

    private JMenuItem itemSair = new JMenuItem("Sair");

    private JMenuBar bar = new JMenuBar();

    private JDesktopPane desktop = new JDesktopPane();

    public TelaEsc(){
        setSize(700,500);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        menuCad.add(itemDisc);
        menuCad.add(itemProf);
        menuCad.add(itemHor);

        bar.add(menuCad);
        bar.add(itemSair);

        setJMenuBar(bar);

        setContentPane(desktop);

        itemSair.addActionListener(new Eventos());
        itemDisc.addActionListener(new Eventos());

        setVisible(true);
    }

    private class Eventos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == itemSair){
                int escolha = JOptionPane.showConfirmDialog(null, "Deseja realemente sair do sistema", "Mensagem de confirmação", JOptionPane.YES_NO_OPTION);
                
                if(escolha == 0){
                    System.exit(1);
                }
            }

            if(event.getSource() == itemDisc){
                TelaDisc disc = new TelaDisc();
                disc.setVisible(true);
                desktop.add(disc);
                
            }
        }

    }
}
