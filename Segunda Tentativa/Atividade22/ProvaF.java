import java.sql.Statement;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class ProvaF {
    BD bd = new BD();
    ArrayList<String> array = new ArrayList<>();

    public ArrayList<String> carregaDis() throws Exception {
        Connection con = bd.conectar();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select nomeD from tbDisciplina");

        while (rs.next()) {
            array.add(rs.getString(1));
        }

        return array;
    }

    public void inserir(String nomeD, String nomeA) throws Exception {
        Connection con = bd.conectar();
        // No prepare statement tem ordem? //
        PreparedStatement pst = con.prepareStatement("insert into tbDisciplina (nomeD, nomeA) values (?, ?)",
                ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_SENSITIVE);
        pst.setString(1, nomeD);
        pst.setString(2, nomeA);
        pst.executeUpdate();
    }

    public void criarDoc() throws Exception {
        Font fTitulo = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

        Document documento = new Document(PageSize.A4, 50, 50, 60, 60);
        PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream("relatorio_disciplinas.pdf"));

        writer.setPageEvent(new PdfPageEventHelper() {
            // Por que no final da página? //
            public void onEndPage(PdfWriter writer, Document document) {
                // O que essa linha faz? //
                PdfContentByte canvas = writer.getDirectContent();
                Phrase cabecalho = new Phrase("IF Sudeste MG - Campus Manhuaçu", fTitulo);

                ColumnText.showTextAligned(
                        canvas,
                        Element.ALIGN_CENTER,
                        cabecalho,

                        // ???? //
                        (document.right() + document.left()) / 2,
                        document.top() + 20,
                        0);
            }
        });

        // Por aqui abriu o documento?
        documento.open();

        Paragraph titulo = new Paragraph("Resultado final disciplina ", fTitulo);

        titulo.setAlignment(Element.ALIGN_CENTER);
        titulo.setSpacingAfter(20);

        documento.add(titulo);

        PdfPTable tabela = new PdfPTable(3);

        String[] colunas = { "ID", "Nome da Disciplina", "Nome do Estudante"};

        for (int i = 0; i < colunas.length; i++) {

            // Por que nesse caso crio uma frase se já criei uma célula? //
            PdfPCell cell = new PdfPCell(new Phrase(colunas[i]));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.PINK);
            cell.setPadding(5);
            tabela.addCell(cell);
        }
        Connection con = bd.conectar();
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("select id, nomeD, nomeA from tbdisciplina order by nomeD");

        while (rs.next()) {
            tabela.addCell(new PdfPCell(new Phrase(rs.getString("id"))));
            tabela.addCell(new PdfPCell(new Phrase(rs.getString("nomeD"))));
            tabela.addCell(new PdfPCell(new Phrase(rs.getString("nomeA"))));
        }

        documento.add(tabela);
        documento.close();

        File arquivoPDF = new File("relatorio_disciplinas.pdf");

        if (arquivoPDF.exists()) {
            Desktop.getDesktop().open(arquivoPDF);
        }

        else {
            System.out.println("Arquivo não encontrado");
        }

    }
}
