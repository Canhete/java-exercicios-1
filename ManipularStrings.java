public class ManipularStrings {
    public static String alterarString(String entrada) {
        if (entrada == null) { return null; }

        String semVogais = entrada.replaceAll("[aeiouAEIOU]", "_"); // Substitui todas vogais por _ underscore

        String semPontos = semVogais.replaceAll("\\p{Punct}", ""); // Apaga todas pontuações

        return semPontos;
    }

    public static void main(String arg[]) {
        String novaString = "Olá, mundo!";

        System.out.println(novaString);

        String stringModificada = alterarString(novaString);

        System.out.println(stringModificada);
    }
}
