// Imprima os números de 1 a 100, mas substitua múltiplos de 3 por "Fizz" e múltiplos de 5 por "Buzz".

public class ImprimirFizzBuzz {
    public static void main(String[] arg) {
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) System.out.println("Fizz");
            else if (i % 5 == 0) System.out.println("Buzz");
            else System.out.printf("%d%n", i);
        }
    }
}
