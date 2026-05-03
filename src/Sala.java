import java.util.Random;

public abstract class Sala {


    // ---------------------------------
    // ---------- ATRIBUTOS ------------
    // ---------------------------------



    private Random rand = new Random();

    private boolean esExplorada;
    private Monstre monstre;
    private Tresor tresor;
    private Arma arma;


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

        if (rand.nextInt(1, 11) <= 3) {
            int tipus = rand.nextInt(3);
            arma = new Arma(tipus);
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
        if (monstre != null && tresor != null && arma != null) {
            return "Hay un monstruo, un tesoro y un arma en la sala";
        } else if (monstre != null && tresor != null) {
            return "Hay un monstruo y un tesoro en la sala";
        } else if (monstre != null && arma != null) {
            return "Hay un monstruo y un arma en la sala";
        } else if (tresor != null && arma != null) {
            return "Hay un tesoro y un arma en la sala";
        } else if (monstre != null) {
            return "Hay un monstruo en la sala";
        } else if (tresor != null) {
            return "Hay un tesoro en la sala";
        } else if (arma != null) {
            return "Hay un arma en la sala";
        } else {
            return "En la sala no hay monstruos, tesoros ni armas";
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

    public Arma getArma() {
        return arma;
    }

    public boolean getExplorada() {
        return this.esExplorada;
    }

}
