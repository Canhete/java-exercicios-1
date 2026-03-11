public class CarroEstado {
    public static class Carro {
        // Atributos
        private double kmPorL;
        private double combustivelAtual;

        public Carro(double kmPorL, double combustivelAtual) {
            if (kmPorL <= 0.0f) throw new IllegalArgumentException("kmPorL deve ser positivo!");
            if (combustivelAtual < 0.0f) throw new IllegalArgumentException("combustivelAtual deve ser igual ou maior que 0!");

            this.kmPorL = kmPorL;
            this.combustivelAtual = combustivelAtual;
        }

        public void dirigir(double distancia) {
            if (distancia <= 0.0f) throw new IllegalArgumentException("distancia deve ser positiva!");

            double distanciaPercorrida = getCombustivelAtual() * getKmPorL();
            this.combustivelAtual -= distancia / getKmPorL();

            if (distanciaPercorrida >= distancia) {
                System.out.printf("Distancia percorrida com sucesso! %.2fL restante(s)%n", getCombustivelAtual());
            } else {
                System.out.printf("Distancia não finalizada. Falta(ram) %.2fkm%n", distancia - distanciaPercorrida);
            }
        }

        public void abastecerGas(double volume) {
            if (volume <= 0.0f) throw new IllegalArgumentException("Não é possível abastecer com volume negativo!");

            this.combustivelAtual += volume;

            System.out.printf("Abastecido! +%.2fL(s)%n", volume );
        }

        // Getters
        public double getKmPorL() { return this.kmPorL; }
        public double getCombustivelAtual() { return this.combustivelAtual; }
    }

    public static void main(String arg[]) {
        Carro NovoCarro = new Carro(12.00, 25.75);

        NovoCarro.abastecerGas(10.00);

        NovoCarro.dirigir(10);
        NovoCarro.dirigir(20);
    }
}
