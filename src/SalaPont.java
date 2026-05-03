import java.util.Random;

public class SalaPont extends Sala {

    // ---------------------------------
    // ---------- ATRIBUTOS ------------
    // ---------------------------------

    Random rand = new Random();

    // ---------------------------------
    // ----- FUNCIONES OBLIGATORIOS ----
    // ---------------------------------

    @Override
    public boolean intentarSortir(Personatge p) {
        if(rand.nextInt(1, 13) <= p.getAgilitat()) {
            return true;
        }

        p.rebreDany(1);
        return false;
    }
}
