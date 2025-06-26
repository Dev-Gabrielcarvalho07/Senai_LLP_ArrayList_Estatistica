import java.util.HashMap;
import java.util.Scanner;


public class ArrayList {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double[] valores = new double[10];             int contador = 0;
           
            System.out.println("Digite os valores (pressione Enter sem valor para calcular):");
            while (true) {
                String entrada = scanner.nextLine().trim();
                if (entrada.isEmpty()) {
                    break;
                }
                try {
                    double valor = Double.parseDouble(entrada);
                    if (contador >= valores.length) {
                                                double[] novoArray = new double[valores.length * 2];
                        System.arraycopy(valores, 0, novoArray, 0, valores.length);
                        valores = novoArray;
                    }
                    valores[contador] = valor;
                    contador++;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, digite um número válido ou pressione Enter para calcular.");
                }
            }
           
            if (contador == 0) {
                System.out.println("Nenhum valor foi informado!");
                scanner.close();
                return;
            }
           
                       double[] valoresFinais = new double[contador];
            System.arraycopy(valores, 0, valoresFinais, 0, contador);
           
            double media = calcularMedia(valoresFinais);
            double moda = calcularModa(valoresFinais);
            double minimo = calcularMinimo(valoresFinais);
            double maximo = calcularMaximo(valoresFinais);
            double desvioPadrao = calcularDesvioPadrao(valoresFinais, media);
           
            System.out.printf("Média = %.2f%n", media);
            System.out.printf("Moda = %.2f%n", moda);
            System.out.printf("Mínimo = %.2f%n", minimo);
            System.out.printf("Máximo = %.2f%n", maximo);
            System.out.printf("Desvio padrão = %.3f%n", desvioPadrao);
        }
    }
   
    public static double calcularMedia(double[] valores) {
        double soma = 0;
        for (double valor : valores) {
            soma += valor;
        }
        return soma / valores.length;
    }
   
    public static double calcularModa(double[] valores) {
        HashMap<Double, Integer> frequencias = new HashMap<>();
        int maxFrequencia = 0;
        double moda = valores[0];
       
        for (double valor : valores) {
            int frequencia = frequencias.getOrDefault(valor, 0) + 1;
            frequencias.put(valor, frequencia);
            if (frequencia > maxFrequencia) {
                maxFrequencia = frequencia;
                moda = valor;
            }
        }
        return moda;
    }
   
    public static double calcularMinimo(double[] valores) {
        double minimo = valores[0];
        for (double valor : valores) {
            if (valor < minimo) {
                minimo = valor;
            }
        }
        return minimo;
    }
   
    public static double calcularMaximo(double[] valores) {
        double maximo = valores[0];
        for (double valor : valores) {
            if (valor > maximo) {
                maximo = valor;
            }
        }
        return maximo;
    }
   
    public static double calcularDesvioPadrao(double[] valores, double media) {
        double somaDesvios = 0;
        for (double valor : valores) {
            somaDesvios += Math.pow(valor - media, 2);
        }
        return Math.sqrt(somaDesvios / valores.length);
    }
}
