import java.util.Random;

public abstract class Sala {
    
     Random rand = new Random();

    // ATRIBUTOS
    
    private boolean teTresor;
    private boolean teMonstre;
    private boolean esExplorada;

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
}