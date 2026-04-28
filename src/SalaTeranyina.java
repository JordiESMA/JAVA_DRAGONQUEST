import java.util.Random;

public class SalaTeranyina extends Sala {
    //ATRIBUTS

    //CONSTRUCTOR

    //METODOS
    
    public boolean intentarSortir(Personatge p) {

         if (p.teExit(p.getForsa())) {
            return true;
         } else{
            return false;
         }
        }
}
