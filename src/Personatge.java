import javax.swing.text.Position;
import java.awt.*;

public class Personatge implements Combatent{

    String nom;
    int vida, atac, experiencia, agilitat, forsa;
    Point posicio =  new Point(2,2);




    @Override
    public int calcularAtac() {
        return 0;
    }

    @Override
    public int rebreDany(int quantitat) {
        return 0;
    }

    @Override
    public boolean estaViu() {
        return false;
    }
}
