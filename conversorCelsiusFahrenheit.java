import java.util.Scanner;

public class conversorCelsiusFahrenheit {
    public static float converterCparaF(float celsius) {
        float fahrenheit = celsius * 1.8f + 32.0f;

        return fahrenheit;
    }
    
    public static float converterFparaC(float fahrenheit) {
        float celsius = (fahrenheit - 32.0f) / 1.8f;

        return celsius;
    }

    public static void main(String[] arg) {
        char temp;
        Scanner input;

        do {
            System.out.printf("Escolha a unidade da temperatura %nC -> Celsius%nF -> Fahrenheit%n");
            input = new Scanner(System.in);

            temp = input.next().charAt(0);

        } while (temp != 'C' && temp != 'c' && temp != 'F' && temp != 'f');

        if (temp == 'C' || temp == 'c') {
            System.out.print("Digite a temperatura em Celsius: ");
            input = new Scanner(System.in);

            float valor = input.nextFloat();
            float convertido = converterCparaF(valor);

            System.out.println(valor + "C = " + convertido + "F");
        }
        else if (temp == 'F' || temp == 'f') {
            System.out.print("Digite a temperatura em Fahrenheit");
            input = new Scanner(System.in);

            float valor = input.nextFloat();
            float convertido = converterFparaC(valor);

            System.out.println(valor + "F = " + convertido + "C");
        }
    }
}