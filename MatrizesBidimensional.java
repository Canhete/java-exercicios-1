import java.util.ArrayList;

class MatrizesBidimensional {
    // 3 colunas, cada uma representa as medalhas (ouro, prata e bronze)
    // Cada linha é um país no campeonato
    // Uma 4 coluna é gerada que contém a soma de todas medalhas de um linha, ou seja um país

    public static void main(String[] args) {
        String[] paises = {"Brasil", "Estados Unidos", "Koreia", "Argentina", "Japão", "Alemanha", "Inglaterra", "Espanha", "Portugal", "Rússia"};
        int[][] medalhas = {
                // Ouro, Prata, Bronze
                {3, 2, 1}, // Brasil
                {5, 1, 0}, // Estados Unidos
                {2, 3, 0}, // Koreia
                {1, 1, 2}, // Argentina
                {4, 3, 1}, // Japão
                {2, 2, 1}, // Alemanha
                {2, 3, 0}, // Inglaterra
                {0, 2, 4}, // Espanha
                {1, 0, 3}, // Portugal
                {1, 1, 1}  // Rússia
        };

        // Calcular total de medalhas
        System.out.printf("%-15s %5s %5s %5s %7s%n",
                "País", "Ouro", "Prata", "Bronze", "Total");

        for (int i = 0; i < paises.length; i++) {
            int total = 0;

            System.out.printf("%-15s", paises[i]);

            for (int j = 0; j < medalhas[i].length; j++) {
                System.out.printf("%5d", medalhas[i][j]);
                total += medalhas[i][j];
            }

            System.out.printf("%7d%n", total);
        }
    }
}