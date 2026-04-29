import java.util.Random;
import java.util.Scanner;

public class Masmorra {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Inicializamos la mazmorra y el personaje
        Sala[][] mapaSalas = crearMasmorra();
        Personatge p1 = new Personatge("Messi");

        System.out.println("--- ¡BIENVENIDO A LA MAZMORRA! ---");
        System.out.println("Recuerda: si no atacas cuando hay un monstruo, perderás vida.");

        // Bucle principal del juego
        while (p1.estaViu()) {
            System.out.println("\n--- ESTADO DE LA MAZMORRA ---");
            mostrarMasmorra(mapaSalas, p1);

            System.out.println("\n¿QUÉ DESEAS HACER?");
            System.out.println("1. Moverse");
            System.out.println("2. Atacar");
            System.out.println("3. Explorar");

            int x = p1.getPosicio()[0];
            int y = p1.getPosicio()[1];
            Sala salaActual = mapaSalas[x][y];

            int accio = teclado.nextInt();

            switch (accio) {
                case 1:
                    System.out.println("Indica la dirección (N: Norte, S: Sur, E: Este, O: Oeste):");
                    char direccio = teclado.next().toUpperCase().charAt(0);

                    if (validarMovimiento(p1.getPosicio(), direccio)) {
                        if (salaActual.intentarSortir(p1)) {
                            p1.moure(direccio);
                            System.out.println("Te has movido hacia el " + direccio);
                        } else {
                            Monstre m = salaActual.getMonstre();
                            if (m != null && m.estaViu()) {
                                p1.rebreDany(m.calcularAtac());
                                System.out.println("¡El monstruo te ha atacado!");
                            } else {
                                System.out.println("No puedes salir de la sala.");
                            }
                        }
                    } else {
                        System.out.println("¡Cuidado! Hay un muro infranqueable en esa dirección.");
                    }
                    break;

                case 2:

                    // FUNCIO ATACAR MONSTRE
                    Monstre m = salaActual.getMonstre();

                    if (m != null && m.estaViu()) {
                        p1.atacar(m);
                        System.out.println("¡Has atacado al monstruo!");
                    } else {
                        System.out.println("No hay ningún monstruo vivo en esta sala.");
                    }
                    break;

                case 3:

                    // FUNCIO EXPLORAR
                    mapaSalas[x][y].setExplorada(true);
                    p1.explorar(mapaSalas[x][y] );
                    System.out.println("Has explorado la sala cuidadosamente.");
                    break;

                default:
                    System.out.println("Opción no válida. Introduce un número del 1 al 3.");
                    break;
            }
        }

        // Este mensaje solo sale cuando p1.estaViu() es falso
        System.out.println("\n--- JUEGO TERMINADO ---");
        System.out.println("El personaje " + p1.getNom() + " ha caído en combate.");
        teclado.close();
    }

    /**
     * Valida si el movimiento es posible dentro de un mapa de 5x5.
     */
    public static boolean validarMovimiento(int[] pos, char dir) {
        int fila = pos[0];
        int col = pos[1];

        switch (dir) {
            case 'N':
                return fila > 0;
            case 'S':
                return fila < 4;
            case 'O':
                return col > 0;
            case 'E':
                return col < 4;
            default:
                return false;
        }
    }

    public static Sala[][] crearMasmorra() {
        Sala[][] mapaSalas = new Sala[5][5];
        Random rand = new Random();

        for (int fil = 0; fil < 5; fil++) {
            for (int col = 0; col < 5; col++) {
                int num = rand.nextInt(10) + 1; // Genera de 1 a 10

                if (num <= 6) {
                    mapaSalas[fil][col] = new SalaComuna();
                } else if (num <= 8) {
                    mapaSalas[fil][col] = new SalaPont();
                } else {
                    mapaSalas[fil][col] = new SalaTeranyina();
                }
            }
        }
        return mapaSalas;
    }

    public static void mostrarMasmorra(Sala[][] mapaSalas, Personatge p1) {
        int posX = p1.getPosicio()[0];
        int posY = p1.getPosicio()[1];

        for (int fil = 0; fil < mapaSalas.length; fil++) {
            for (int col = 0; col < mapaSalas[fil].length; col++) {
                if (fil == posX && col == posY) {
                    System.out.print("| & |"); // Posición del jugador
                } else if (mapaSalas[fil][col].getExplorada()) {
                    System.out.print("| * |"); // Sala ya explorada
                } else {
                    System.out.print("| - |"); // Sala oculta
                }
            }
            System.out.println();
        }
    }
}
