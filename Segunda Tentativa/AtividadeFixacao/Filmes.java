import java.io.Serializable;

public class Filmes implements Serializable{
    private String titulo;
    private int ano;
    private String genero;
    private int id;
    public Filmes(String titulo, int ano, String genero, int id) {
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
