import java.util.Scanner;

public class SomaDoisNumeros {
    public static float soma(float N1, float N2) {
        float sum = N1 + N2;

        return sum;
    }

    public static void main(String[] arg) {
        System.out.print("Digite o primeiro número: ");
        Scanner input = new Scanner(System.in);

        float N1 = input.nextFloat();

        System.out.print("Digite o segundo número: ");
        input = new Scanner(System.in);

        float N2 = input.nextFloat();

        float resultado = soma(N1, N2);

        System.out.println(N1 + " + " + N2 + " = " + resultado);
    }
}