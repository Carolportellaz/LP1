public class Atividade05 {
    static float n;
    static double area;
    public static void main(String[] args) {
        n = Integer.parseInt(args[0]);
        area = 3.14 * Math.pow(n, 2);

        System.out.println("O valor da área é " + area);
    }
}
