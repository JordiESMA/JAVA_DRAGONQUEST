import java.util.Random;

public class SalaTeranyina extends Sala {

    // ---------------------------------
    // ---------- ATRIBUTOS ------------
    // ---------------------------------

    Random rand = new Random();

    // ---------------------------------
    // ----- FUNCIONES OBLIGATORIOS ----
    // ---------------------------------


    @Override
    public boolean intentarSortir(Personatge p) {
        if(rand.nextInt(1, 13) <= p.getForsa()) {
            return true;
        }
        return false;
    }

}
