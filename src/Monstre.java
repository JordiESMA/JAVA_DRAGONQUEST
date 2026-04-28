import java.util.Random;

public class Monstre implements Combatent {
    private Random rand = new Random();

    // ATRIBUTOS

    private String nom;
    private int vida;
    private int penalitzacio;
    private int valorExperiencia;

    // CONSTRUCTOR

    public Monstre(String nom, int vida) {
        this.nom = nom;
        this.vida = vida;
        this.penalitzacio = rand.nextInt(4);
        this.valorExperiencia = vida * 2;


    }

    /**
     * Cuando nos manden el tipus nosotros de aqui generamos el monstruo a la sala
     *
     * @param tipus
     */
    public Monstre(int tipus) {
        switch (tipus) {
            case 0:
                Monstre demon = new Monstre("Demon", 6);
//                crearMonstre("Demon", 6);
                break;
            case 1:
                Monstre skeleton = new Monstre("Skeleton", 3);
//                crearMonstre("Skeleton", 3);
                break;
            case 2:
                Monstre troll = new Monstre("Troll", 3);
//                crearMonstre("Troll", 3);
                break;
        }
    }

    // MÉTODOS

    @Override
    public String toString() {
        return "Nom: " + nom + ", vida:" + vida;
    }

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

//    private void crearMonstre(String nom, int vida) {
//        this.nom = nom;
//        this.vida = vida;
//        this.valorExperiencia = this.vida * 2;
//    }

    public int getVida() {
        return this.vida;
    }

    public String getNom() {
        return this.nom;
    }

}
