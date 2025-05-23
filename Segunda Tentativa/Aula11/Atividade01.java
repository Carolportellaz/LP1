import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

public class Atividade01 extends JFrame{
    JMenuBar barP = new JMenuBar();
    
    JMenu menuAr = new JMenu("Arquivo");
    JMenu menuEdt = new JMenu("Editar");
    JMenu menuSel = new JMenu("Seleção");
    JMenu menuVer = new JMenu("Ver");
    JMenu menuAcessar = new JMenu("Acessar");
    JMenu menuEx = new JMenu("Executar");
    JMenu menuTer = new JMenu("Terminal");
    JMenu menuAjud = new JMenu("Ajuda");

    // Parte 01 //
    JMenuItem itemNovArq = new JMenuItem("Novo arquivo de texto");
    JMenuItem itemNov = new JMenuItem("Novo arquivo");
    JMenuItem itemJan = new JMenuItem("Nova janela");
    JMenu menuNovaJanPer = new JMenu("Nova janela com perfil");
    
    // Parte 02 //
    JMenuItem itemAbrArq = new JMenuItem("Abrir arquivo");
    JMenuItem itemAbrPast = new JMenuItem("Abrir pasta");
    JMenuItem itemAbrWork = new JMenuItem("Abrir Workspace a patrtir do Arquivo");
    JMenu menuAbrirRec = new JMenu("Abrir recente");

    public Atividade01(){
        super("VsCode");
        setSize(500,500);
        setLayout(new BorderLayout());
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Não dá para setar só com o setBackground precisa pegar a balor do painel e depois setar // 
        getContentPane().setBackground(Color.BLACK);

        setJMenuBar(barP);

        // Adicionando na barra //
        barP.add(menuAr);
        barP.add(menuEdt);
        barP.add(menuSel);
        barP.add(menuVer);
        barP.add(menuAcessar);
        barP.add(menuEx);
        barP.add(menuTer);
        barP.add(menuAjud);

        // Adicionando na barra de arquivo //
        menuAr.add(itemNovArq);
        menuAr.add(itemNov);
        menuAr.add(itemNovArq);
        menuAr.add(menuNovaJanPer);

        menuAr.add(new JSeparator());
        menuAr.add(itemAbrArq);
 
        setVisible(true);

    }

    public static void main (String [] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new Atividade01();
            }
        });
    }
}
