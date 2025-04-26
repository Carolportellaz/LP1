public class Calculos {
    public int maior(int n, int maior){
        if(n >= maior){
            maior = n;
        }

        return maior;
    }

    public int menor(int n, int menor){
        if(menor >= n){
            menor = n;
        }

        return menor;
    }

    public int media(int n, int count, int soma){
        int media = (soma + n) / count;
        return media;
    }

    public int soma(int n, int soma){
        int resultado = soma + n;
        return resultado;
    }
}
