public class Arma {


    // ---------------------------------
    // ---------- ATRIBUTOS ------------
    // ---------------------------------

    private String nom;
    private int dany;
    private int tipus;

    public Arma(int tipus) {
        switch (tipus) {
            case 0:
                crearArma("Arc Precís", 1, 1);
                break;
            case 1:
                crearArma("Espasa Llegendària", 2, 2);
                break;
            case 2:
                crearArma("Destral Brutal", 3, 3);
                break;
        }

    }

    // ---------------------------------
    // ---------- FUNCIONES ------------
    // ---------------------------------

    private void crearArma(String nom, int dany, int tipus) {
        this.nom = nom;
        this.dany = dany;
        this.tipus = tipus;
    }

    // ---------------------------------
    // ------ GETTERS + SETTERS --------
    // ---------------------------------

    public String getNom() {
        return nom;
    }

    public int getDany() {
        return dany;
    }

    public int getTipus() {
        return tipus;
    }
}
