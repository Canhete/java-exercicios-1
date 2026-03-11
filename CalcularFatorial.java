import java.util.Scanner;

public class CalcularFatorial {
    public static int fatorial(int n) {
        if (n == 0 || n == 1) return 1;

        return n * fatorial(n - 1);
    }

    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite um número natural para calcular fatorial: ");

        int num = input.nextInt();

        int fator = fatorial(num);

        System.out.printf("%d! = %d%n", num, fator);
    }
}
