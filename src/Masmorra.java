import java.util.Random;
import java.util.Scanner;

public class Masmorra {


    // ---------------------------------
    // ------------ MAIN ---------------
    // ---------------------------------


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        Sala[][] mapaSalas = crearMasmorra();
        Personatge pers = new Personatge("Caballero");

        boolean fin = false;
        String causaDeLaMort = "";

        System.out.println("--- ¡BIENVENIDO A LA MAZMORRA! ---");
        System.out.println("Recuerda: si no atacas cuando hay un monstruo, perderás vida.");

        while (pers.estaViu() && !fin) {
            System.out.println("--- ESTADO DE LA MAZMORRA ---");

            mostrarMasmorra(mapaSalas, pers);

            System.out.println();

            System.out.println("¿QUÉ DESEAS HACER?");
            System.out.println("1. Moverse");
            System.out.println("2. Descansar");
            System.out.println("3. Atacar");
            System.out.println("4. Explorar");
            System.out.println("5. Personaje info");
            System.out.println("6. Sala actual info");

            int accio =  sc.nextInt();

            int x = pers.getPosicio()[0];
            int y = pers.getPosicio()[1];
            Sala salaActual = mapaSalas[x][y];

            switch (accio) {
                case 1:
                    System.out.println("Indica la dirección (W, A, S, D):");
                    char direccio = sc.next().toUpperCase().charAt(0);

                    if(!esSalidaMasmorra(pers.getPosicio(), direccio, mapaSalas)) {
                        if(salaActual.intentarSortir(pers)) {
                            Monstre m = salaActual.getMonstre();

                            if (m != null && m.estaViu()) {
                                pers.rebreDany(m.getPenalitzacio());
                                System.out.println("¡El monstruo te ha penalizado al salir!");
                                pers.moure(direccio);

                                if(!pers.estaViu()) {
                                    causaDeLaMort = "Monstruo";
                                }


                            } else {
                                pers.moure(direccio);
                                System.out.println("Te has movido hacia el " + direccio);
                            }

                        } else {
                            System.out.println("No has podido salir de la sala");
                            if(!pers.estaViu()) {
                                causaDeLaMort = "Caída del puente";
                            }
                        }
                    } else {
                        estadistica(pers, mapaSalas);
                        fin = true;
                    }

                    break;

                case 2:
                    if(salaActual.getMonstre() == null || !salaActual.getMonstre().estaViu()) {
                        if (pers.getVida() < 5) {
                            pers.setVida(pers.getVida() + 1);
                            System.out.println("Has podido descansar. Vida actual: " +  pers.getVida());
                        } else {
                            System.out.println("Tienes más de 5 puntos de vida");
                        }
                    } else {
                        System.out.println("No puedes descansar mientras haya un monstruo en la sala");
                    }

                    break;
                case 3:
                    Monstre m = salaActual.getMonstre();

                    if (m != null && m.estaViu()) {
                        System.out.println("¡Has atacado al monstruo!");
                        pers.atacar(m);

                        if(!pers.estaViu()) {
                            causaDeLaMort = "Monstruo";
                        }

                    } else {
                        System.out.println("No hay ningún monstruo vivo en esta sala.");
                    }
                    break;

                case 4:
                    if (rand.nextInt(1, 11) == 1) {
                        int r = rand.nextInt(1, 4);
                        pers.rebreDany(r);
                        System.out.println("¡El personaje ha caído en una trampa! Pierde " + r + " puntos de vida.");

                        if (!pers.estaViu()) {
                            causaDeLaMort = "Trampa";
                        }

                    } else {
                        mapaSalas[x][y].setExplorada(true);
                        pers.explorar(mapaSalas[x][y]);
                        System.out.println("Has explorado la sala cuidadosamente.");
                    }

                    break;

                case 5:
                    System.out.println(pers);
                    break;

                case 6:
                    System.out.println(salaActual);
                    break;

                default:
                    System.out.println("Opción no válida. Introduce un número del 1 al 3.");
                    break;
            }
        }

        if (!pers.estaViu()) {
            estadistica(pers, mapaSalas, causaDeLaMort);
        }

    }





    // ---------------------------------
    // ---------- FUNCIONES ------------
    // ---------------------------------







    public static Sala[][] crearMasmorra() {

        Random rand = new Random();
        int filas = 5;
        int columnas = 5;

        Sala[][] mapaSalas = new Sala[filas][columnas];

        for (int fil = 0; fil < mapaSalas.length; fil++) {
            for (int col = 0; col < mapaSalas[fil].length; col++) {

                int num = rand.nextInt(1, 11);

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

    public static boolean esSalidaMasmorra(int[] pos, char dir, Sala[][] mapaSalas) {
        int fila = pos[0];
        int col = pos[1];

        return (dir == 'W' && fila == 0) ||
                (dir == 'S' && fila == mapaSalas.length - 1) ||
                (dir == 'A' && col == 0) ||
                (dir == 'D' && col == mapaSalas[0].length - 1);

    }

    public static double porcentajeMasmorra(Sala[][] mapaSalas) {
        int salasExploradas = 0;

        for (int fila = 0; fila < mapaSalas.length; fila++) {
            for (int col = 0; col < mapaSalas[fila].length; col++) {
                if (mapaSalas[fila][col].getExplorada()) {
                    salasExploradas++;
                }
            }
        }

        return ((double) salasExploradas / (mapaSalas.length * mapaSalas[0].length)) * 100;
    }

    public static void estadistica(Personatge pers, Sala[][] mapaSalas, String causaDeLaMort) {
        System.out.println("============ DERROTA ============");
        System.out.println("=== Estadísticas de la partida ===");
        System.out.println("Experiencia: " + pers.getExperiencia());
        System.out.println("Causa de la muerte: " + causaDeLaMort);
        System.out.println("Masmorra explorada: " + porcentajeMasmorra(mapaSalas) + "%");
    }

    public static void estadistica(Personatge pers, Sala[][] mapaSalas) {
        System.out.println("============ VICTORIA ============");
        System.out.println("=== Estadísticas de la partida ===");
        System.out.println("Experiencia: " + pers.getExperiencia());
        System.out.println("Tesoros: " + pers.getTresorTotal());
        System.out.println("Vida restante: " + pers.getVida());
        System.out.println("Monedas de oro: " + pers.getMonedas());
        System.out.println("Masmorra explorada: " + porcentajeMasmorra(mapaSalas) + "%");
    }

}
