import java.util.Random;

public class Monstre implements Combatent {
    Random rand = new Random();

    private String nom;
    private int vida;
    private int penalitzacio = rand.nextInt(4);
    private int valorExperiencia =  vida * 2;

    public Monstre(String nom, int vida) {
        this.nom = nom;
        this.vida = vida;
    }

    @Override
    public String toString() {
        return "Nom: " + nom + ", vida:" + vida;
    }

    @Override
    public int calcularAtac() {
        return rand.nextInt(1, (vida+1));
    }

    @Override
    public void rebreDany(int quantitat) {
        this.vida -= quantitat;
    }

    @Override
    public boolean estaViu() {
        return false;
    }
}
