import javax.swing.text.Position;
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
    // private int[] posicio;
    // private int equipament;


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
        return false;
    }
}
