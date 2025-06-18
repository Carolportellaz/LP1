import java.io.Serializable;

public class Pessoa implements Serializable {
    private String nome;
    private String data;
    private String email;
    private Double salario;
    private String tel;
    public Pessoa(String nome, String data, String email, Double salario, String tel) {
        this.nome = nome;
        this.data = data;
        this.email = email;
        this.salario = salario;
        this.tel = tel;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    
}
