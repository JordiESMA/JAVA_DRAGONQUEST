import java.util.Random;
import java.util.Scanner;

public class Masmorra {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Sala[][] mapaSalas = crearMasmorra();

		
		Personatge p1 = new Personatge("messi");
		
		mostrarMasmorra(mapaSalas, p1);
		
		
		
	}

	// METODES
/**
 * 
 * @return NOS DEVUELVE LA MAZMORRA TAL COMO NOS PIDE EL JUEGO 
 */
	public static Sala[][] crearMasmorra() {
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

	/**
	 * 
	 * @param mapaSalas p1
	 * NOS MUESTRA COMO ESTA LA MAZMORRA HASTA AHORA (EXLORAR, SIN EXPLORAR, PERSONAJE)
	 */
	public static void mostrarMasmorra(Sala[][] mapaSalas, Personatge p1) {
	    
		//COGEMOS LOS DOS NUMEROS DE POSICION QUE EQUIVALEN A X I Y 
		int posX = p1.getPosicio()[0];
	    int posY = p1.getPosicio()[1];

	    for (int fil = 0; fil < mapaSalas.length; fil++) {
	        for (int col = 0; col < mapaSalas[fil].length; col++) {
	            
	            //PRIMERO MIRAMOS SI ESTA EL PERSONAJE Y YA LUEGO SI ESTA O NO EXPLORADA
	            if (fil == posX && col == posY) {
	                System.out.print("| & |");
	            } 
	            
	            else if (mapaSalas[fil][col].getExplorada()) {
	                System.out.print("| * |");
	            } 
	            
	            else {
	                System.out.print("| - |");
	            }
	        }
	        System.out.println(); 
	    }
	}
	
	
	
	
}


