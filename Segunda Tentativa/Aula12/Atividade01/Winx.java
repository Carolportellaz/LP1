public class Winx {
    private String nome;
    private int pontos;
    private String img; 

    public Winx(String nome, int pontos, String img) {
        this.nome = nome;
        this.pontos = pontos;
        this.img = img;
    }

    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getPontos() {
        return pontos;
    }
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
