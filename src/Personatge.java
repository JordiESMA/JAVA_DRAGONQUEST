import java.awt.*;
import java.util.Random;

public class Personatge implements Combatent {
    Random rand = new Random();
    Monstre monstre;

    private String nom;
    private int vida = rand.nextInt(5, 21);
    private int atac = rand.nextInt(1, 5);
    private int experiencia = 0;
    private int agilitat = rand.nextInt(4, 12);
    private int forsa = rand.nextInt(4, 12);
    private int[] posicio = new int[2];
    private Tresor[] tresor = new Tresor[forsa];

    public Personatge(String nom) {
        this.nom = nom;
    }

    public void atacar(Monstre m) {
        m.rebreDany(calcularAtac());
        System.out.println(m.getNom() + " - " + m.getVida());
    }

    public void explorar() {

    }

    public void moure(char direccio) {

        switch (direccio) {
            case 'N':
                System.out.println("NORTE");
                setPosicio(this.posicio[0]+1, this.posicio[1]);
                break;
            case 'S':
                System.out.println("SUR");
                setPosicio(this.posicio[0]-1, this.posicio[1]);
                break;
            case 'E':
                System.out.println("ESTE");
                setPosicio(this.posicio[0], this.posicio[1]+1);
                break;
            case '0':
                System.out.println("OESTE");
                setPosicio(this.posicio[0], this.posicio[1]-1);
                break;

        }
        // FALTA IMPLEMENTAR ESTE METODO PARA QUE EL PERSONAJE SE MUEVA

        // SI SE MUEVE Y HAY UN MONSTRUO EN ESA SALA Y NO LO HA DERROTADO OENALIZAR LA
        // VIDA (NUMERO 0-3)
    }
private void equipar(){
    
}
    
    @Override
    public int calcularAtac() {
        return rand.nextInt(1, (atac + 1));
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

    public int getForsa() {
        return this.forsa;
    }

    public int getAgilitat() {
        return this.agilitat;
    }

    public void setPosicio(int x, int y) {
        this.posicio[0] = x;
        this.posicio[1] = y;
    }

    public int[] getPosicio() {
        return this.posicio;
    }

    public String getNom() {
        return this.nom;
    }

}
