import java.util.Random;

public abstract class Sala {

    private Random rand = new Random();

    // ATRIBUTOS

    private boolean teTresor;
    private boolean teMonstre;
    private boolean esExplorada;
    private Monstre monstre;
    private Tresor tresor;

    // CONSTRUCTOR
    public Sala() {

        this.teTresor = rand.nextBoolean();
        this.teMonstre = rand.nextBoolean();

        afegirMonstre();
        afegirTresor();
    }

    // MÉTODOS
    public abstract boolean intentarSortir(Personatge p);

    public void setExplorada(boolean explorada) {
        this.esExplorada = explorada;
    }
/**
 * EN ESTA FUNCION DECIMOS QUE SI TIENE MONSTRUO QUE GENER UN RANDOM Y LO MANDE A MONSTRUO(MIRAR MONSTRUO COMO COMPARTIR)
 */
    public void afegirMonstre(){
        if (teMonstre) {
            int tipus = rand.nextInt(3);
            monstre = new Monstre(tipus);
        }
    }

    public void afegirTresor(){
        if (teTresor) {
            int tipus = rand.nextInt(3);
            tresor = new Tresor(tipus);
        }
    }

    public Monstre getMonstre() {
        return monstre;
    }

    public Tresor getTresor() {
        return tresor;
    }
    
    public boolean getExplorada() {
    	return this.esExplorada;
    }
    

}