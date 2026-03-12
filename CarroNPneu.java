import java.util.ArrayList;
import java.util.List;

public class CarroNPneu {
    public static class Carro {
        private String marca;
        private List<Pneu> pneus;

        public Carro(String marca) {
            this.marca = marca;
            this.pneus = new ArrayList<>(List.of(
                new Pneu("Pneu dianteiro esquerdo"),
                new Pneu("Pneu dianteiro direito"),
                new Pneu("Pneu traseiro esquerdo"),
                new Pneu("Pneu traseiro direito")
            ));
        }

        public String getMarca() {
            return marca;
        }
        public List<Pneu> getPneus() {
            return pneus;
        }
    }
    public static class Pneu {
        private String local;

        public Pneu(String local) {
            this.local = local;
        }

        public String getLocal() {
            return local;
        }
    }

    public static void main(String[] args) {
        Carro meuCarro = new Carro("Chevrolet");
        
        System.out.println("Carro: " + meuCarro.getMarca());
        for(Pneu p : meuCarro.getPneus()) {
            System.out.println(p.getLocal());
        }
    }
}
