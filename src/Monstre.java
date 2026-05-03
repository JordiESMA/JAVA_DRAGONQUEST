import java.util.Random;

public class Monstre implements Combatent {


    // ---------------------------------
    // ---------- ATRIBUTOS ------------
    // ---------------------------------



    private Random rand = new Random();

    private String nom;
    private int vida;
    private int penalitzacio;
    private int valorExperiencia;




    // ---------------------------------
    // --------- CONSTRUCTOR -----------
    // ---------------------------------



    public Monstre(int tipus) {
        switch (tipus) {
            case 0:
                crearMonstre("Demon", 6);
                break;
            case 1:
                crearMonstre("Skeleton", 3);
                break;
            case 2:
                crearMonstre("Troll", 3);
                break;
        }
    }





    // ---------------------------------
    // ----- FUNCIONES OBLIGATORIOS ----
    // ---------------------------------




    @Override
    public int calcularAtac() {
        return rand.nextInt(1, (vida + 1));
    }

    @Override
    public void rebreDany(int quantitat) {
        this.vida -= quantitat;
    }

    @Override
    public boolean estaViu() {
        if (this.vida > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Nom: " + nom + ", vida:" + vida;
    }




    // ---------------------------------
    // ----- FUNCIONES ADICIONALES -----
    // ---------------------------------




    private void crearMonstre(String nom, int vida) {
        this.nom = nom;
        this.vida = vida;
        this.valorExperiencia = this.vida * 2;
        this.penalitzacio = rand.nextInt(4);
    }




    // ---------------------------------
    // ------ GETTERS + SETTERS --------
    // ---------------------------------




    public int getVida() {
        return this.vida;
    }

    public String getNom() {
        return this.nom;
    }

    public int getPenalitzacio(){
        return this.penalitzacio;
    }

    public int getValorExperiencia() {
        return this.valorExperiencia;
    }

}
