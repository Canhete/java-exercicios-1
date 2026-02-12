import java.util.Scanner;

public class idadeUsuario {
    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome do usuário: ");

        String nome = input.nextLine();

        input = new Scanner(System.in);
        System.out.print("Digite a idade do usuário: ");

        int idade = input.nextInt();

        System.out.println("Olá " + nome + "!");
        System.out.println("Sua idade é " + idade + " anos");
    }
}