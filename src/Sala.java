import java.util.Random;

public abstract class Sala {

    Random rand = new Random();

    // ATRIBUTOS

    private boolean teTresor;
    private boolean teMonstre;
    private boolean esExplorada;
    Monstre monstre;

    // CONSTRUCTOR
    public Sala() {

        this.teTresor = rand.nextBoolean();
        this.teMonstre = rand.nextBoolean();
        this.esExplorada = false;
    }

    // MÉTODOS
    public abstract boolean intentarSortir(Personatge p);

    public void setEsExplorada(boolean explorada) {
        this.esExplorada = explorada;
    }
/**
 * EN ESTA FUNCION DECIMOS QUE SI TIENE MONSTRUO QUE GENER UN RANDOM Y LO MANDE A MONSTRUO(MIRAR MONSTRUO COMO COMPARTIR)
 */
    public void tipusMonstre(){
        if (teMonstre) {
            int tipus = rand.nextInt(3);
            monstre = new Monstre(tipus);
        }
    }

}