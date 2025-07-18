import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela extends JFrame{
    JTextArea txt = new JTextArea(5,30);
    JButton bntCon = new JButton("Executar consulta");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable();

    Query consulta = new Query();

    public Tela(){
        super("Query Browser");
        setSize(550,300);
        setLayout(new FlowLayout());
        setResizable(true);

        add(txt);
        add(bntCon);
        add(table);

        // Adicionando o jtable //
        try{
            consulta.executeMeta("select user, host from mysql.user");
            preencheTable(table, consulta);
        }

        catch(Exception e){
            System.out.println("Ocorreu erro " + e.getMessage());
        }

        setVisible(true);

        bntCon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                try{
                    preencheTable(table, consulta);
                }

                catch(Exception e){
                    System.out.println("Ocorreu o seguinte ao tentar carregar os dados " + e.getMessage());
                }
            }
        });
    }


    public void preencheTable(JTable table, Query consulta)  throws Exception{
        if(consulta.conectado == false){
            throw new Exception("Sem conexão");
        }

        int qtd = consulta.meta.getColumnCount();
        String colunas[] = new String[qtd];

        // A numeração das colunas inicia em 1 //
        for(int i = 1; i < colunas.length; i++){
            colunas[i-1] = consulta.meta.getColumnName(i);
        }

        // Verificando se está vazio //
        if(consulta.rs == null){
            System.out.println("Não há dados cadastrados no banco");
        }

        else{
            // Adicionando na table //
            Object [] linha = new Object[qtd];

            while(consulta.rs.next()){
                for(int i = 0; i < qtd; i++){
                    linha[i] = consulta.rs.getString(i+1);
                }

                model.addRow(linha);
            }

            table.setModel(model);
        }
    }
}
