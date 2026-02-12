import java.util.Scanner;

public class calcularAreaCirculo {
    public static float calculo(float raio) {
        float result = (float) Math.PI * raio * raio;

        return result;
    }

    public static void main(String[] arg) {
        System.out.print("Digite o raio do círculo: ");
        Scanner input = new Scanner(System.in);

        float raio = input.nextFloat();

        float resultado = calculo(raio);

        System.out.println("Area: " + resultado);
    }
}