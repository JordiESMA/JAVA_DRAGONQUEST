import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Sala[][] masmorra = crearMasmora();

        for (int i=0; i<masmorra.length; i++) {
            for (int j=0; j<masmorra[i].length; j++) {
                System.out.println(masmorra[i][j]);
            }
        }

    }

    public static Sala[][] crearMasmora() {
        Sala[][] masmorra = new Sala[5][5];

        for (int i = 0; i < masmorra.length; i++) {
            for (int j = 0; j < masmorra[i].length; j++) {
                Random rand = new Random();

                int num = rand.nextInt(1,11);

                if(num <= 6) {
                    masmorra[i][j] = new SalaComuna();
                } else if (num == 7 ||  num == 8) {
                    masmorra[i][j] = new SalaPont();
                } else {
                    masmorra[i][j] = new SalaTeranyina();
                }

            }
        }

        return masmorra;
    }


    int[][] posicio = new int[1][1];

}
