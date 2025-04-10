public class Atividade06 {
    static String nome;
    static float fixo;
    static float total;
    static float porct = 0.15f;
    
    public static void main(String[] args) {
        nome = args[0];
        fixo = Float.parseFloat(args[1]);
        total = Float.parseFloat(args[2]);

        porct = 0.15f * total;
        total = total + fixo + porct;

        System.out.println("O valor do funcionário " + total);
    }
}
