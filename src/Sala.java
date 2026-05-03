import java.util.Random;

public abstract class Sala {


    // ---------------------------------
    // ---------- ATRIBUTOS ------------
    // ---------------------------------



    private Random rand = new Random();

    private boolean esExplorada;
    private Monstre monstre;
    private Tresor tresor;


    // ---------------------------------
    // --------- CONSTRUCTOR -----------
    // ---------------------------------

    public Sala() {
        if (rand.nextBoolean()) {
            int tipus = rand.nextInt(3);
            monstre = new Monstre(tipus);
        }

        if (rand.nextBoolean()) {
            int tipus = rand.nextInt(3);
            tresor = new Tresor(tipus);
        }
    }



    // ---------------------------------
    // ----- FUNCIONES OBLIGATORIOS ----
    // ---------------------------------



    public abstract boolean intentarSortir(Personatge p);



    // ---------------------------------
    // ----- FUNCIONES ADICIONALES -----
    // ---------------------------------


    @Override
    public String toString() {
        if(monstre != null &&  tresor != null) {
            return "Hay un monstruo y un tesoro en la sala";
        } else if (monstre != null) {
            return "Hay un monstruo en la sala";
        } else if (tresor != null) {
            return "Hay un tesoro en la sala";
        } else {
            return "En la sala no hay monstruos ni tesoros";
        }
    }


    // ---------------------------------
    // ------ GETTERS + SETTERS --------
    // ---------------------------------


    public void setExplorada(boolean explorada) {
        this.esExplorada = explorada;
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
