import java.util.Random;

public class SalaPont extends Sala {
    //ATRIBUTS

    //CONSTRUCTOR

    //METODOS
    public boolean intentarSortir(Personatge p) {

         if(p.teExit(p.getAgilitat())){
            return true;
         }else{
            return false;
         }
    }
}
