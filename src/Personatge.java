import java.awt.*;
import java.util.Random;

public class Personatge implements Combatent{
    Random rand = new Random();
    Monstre monstre;

    private String nom;
    private int vida = rand.nextInt(5, 21);
    private int atac = rand.nextInt(1, 5);
    private int experiencia = 0;
    private int agilitat = rand.nextInt(4, 12);
    private int forsa = rand.nextInt(4, 12);
    // private int[] posicio; La posicion siempre sera la primera de la matriz
    private Tresor[] equipament = new Tresor[forsa];


    public Personatge(String nom) {
        this.nom = nom;
    }

    public void atacar(Monstre m) {
        m.rebreDany(calcularAtac());
    }

    public void explorar() {

    }

    public void moure(char direccio) {

    }

    @Override
    public int calcularAtac() {
        return rand.nextInt(1, (atac+1));
    }

    @Override
    public void rebreDany(int quantitat) {
        this.vida -= quantitat;
    }

    @Override
    public boolean estaViu() {
        if(this.vida > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getForsa() {
        return this.forsa;
    }
    public int getAgilitat() {
        return this.agilitat;
    }
    
}
