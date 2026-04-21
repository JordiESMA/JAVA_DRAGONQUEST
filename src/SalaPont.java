import java.util.Random;

public class SalaPont extends Sala {
    //ATRIBUTS

    //CONSTRUCTOR

    //METODOS
    public boolean intentarSortir(Personatge p) {
         Random tiradaExit = new Random();

         if(teExit( tiradaExit , p)){
            return true;
         }else{
            return false;
         }
    }

    private boolean teExit( Random tirada, Personatge p){

        if(tirada.nextInt(1 ,13) <= p.getAgilitat()){
            return true;
        } else {
            p.rebreDany(1);
            return false;
        }

    }
}
