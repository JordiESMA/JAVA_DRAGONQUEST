import java.util.Random;

public class Monstre implements Combatent {
    Random rand = new Random();

    // ATRIBUTOS

    private String nom;
    private int vida;
    private int penalitzacio = rand.nextInt(4);
    private int valorExperiencia;

    // CONSTRUCTOR

    /**
     * Cuando nos manden el tipus nosotros de aqui generamos el monstruo a la sala
     * @param tipus
     */
    public Monstre(int tipus) {

        switch (tipus) {
            case 1:
                
            case 2:
        
            case 3:
        }
    }

    public Monstre(String nom, int vida) {
        this.nom = nom;
        this.vida = vida;
        this.valorExperiencia = this.vida * 2;
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
}
