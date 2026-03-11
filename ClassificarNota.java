// Classificar aluno, notas S, A, B, C, D, F

import java.util.Scanner;

public class ClassificarNota {
    public static char avaliarNota(float nota) {
        if (nota >= 9.5f) return 'S';
        else if (nota >= 9.0f) return 'A';
        else if (nota >= 8.0f) return 'B';
        else if (nota >= 7.0f) return 'C';
        else if (nota >= 6.0f) return 'D';
        else return 'F';
    }

    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite a nota: ");

        float nota = input.nextFloat();

        char letra = avaliarNota(nota);

        System.out.printf("Nota: %.2f%nRank: %c%n", nota, letra);
        if (letra == 'F') System.out.println("Status: Reprovado.");
        else System.out.println("Status: Aprovado!");
    }
}
