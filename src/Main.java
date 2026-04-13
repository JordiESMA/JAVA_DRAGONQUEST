import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();

        // ATRIBUTOS

        private boolean teTresor = rand.nextBoolean();
        private boolean teMonstre = rand.nextBoolean();
        private boolean esExplorada = rand.nextBoolean();
        Monstre monstre;


        // CONSTRUCTOR
        public Sala() {
            if(teMonstre) {
                int nMonstre = rand.nextInt(3);

                if(nMonstre == 0) {
                    monstre = new Monstre("Test", 3);
                } else if(nMonstre == 1) {
                    monstre = new Monstre("Test2", 3);
                } else {
                    monstre = new Monstre("Test3", 3);
                }
            }
        }

        // MÉTODOS
        public abstract boolean intentarSortir(Personatge p);

        public void setEsExplorada(boolean explorada) {
            this.esExplorada = explorada;
        }

        String sala = "sala";
        for(int i = 0; i < 3;i++) {
            sala += i;
        }

    }
}
