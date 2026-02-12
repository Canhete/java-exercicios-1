import java.util.Scanner;

public class imparOuPar {
    public static boolean ehPar(int n) {
        return n % 2 == 0;
    }
    
    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");

        int numero = input.nextInt();

        if (ehPar(numero)) {
            System.out.println(numero + " é par!");
        } else {
            System.out.println(numero + " é ímpar!");
        }
    }
}