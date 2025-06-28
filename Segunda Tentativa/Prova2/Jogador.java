import java.io.Serializable;

public class Jogador implements Serializable {
    private String nome;
    private int cpf;
    private String posicao;
    private int dataNas;
    public Jogador(String nome, int cpf, String posicao, int dataNas) {
        this.nome = nome;
        this.cpf = cpf;
        this.posicao = posicao;
        this.dataNas = dataNas;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public String getPosicao() {
        return posicao;
    }
    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
    public int getDataNas() {
        return dataNas;
    }
    public void setDataNas(int dataNas) {
        this.dataNas = dataNas;
    }
}
