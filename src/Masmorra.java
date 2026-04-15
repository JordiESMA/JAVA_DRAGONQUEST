import java.util.Random;
import java.util.Scanner;

public class Masmorra {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        teclado.close();
    }

    // METODES

    public  crearMasmorra() {
        Sala[][] mapaSalas = new Sala[5][5];

        for(int fil = 0 ; fil <mapaSalas.length; fil ++){
            for(int col = 0; col<mapaSalas[fil].length; col ++){
                Random rand = new Random();

                int num = rand.nextInt(1, 11);

                if (num <= 6) {
                    mapaSalas[fil][col] = new SalaComuna();
                    
                }else if (num == 7 || num == 8 ) {
                    mapaSalas[fil][col] = new SalaPont();
                    
                }else {
                    mapaSalas[fil][col] = new SalaTeranyina();
                }
            }
        }
      return mapaSalas;
    }

    public void mostrarMasmorra(Sala[][] mapaSalas){
        for(int fil= 0 ; fil <mapaSalas.length; fil ++){
            for(int col = 0; col<mapaSalas.length[]; col ++){
                System.out.println(mapaSalas[fil][col]);
            }
        }
    }

}
