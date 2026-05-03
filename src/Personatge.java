import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Personatge implements Combatent{



    // ---------------------------------
    // ---------- ATRIBUTOS ------------
    // ---------------------------------



    private Random rand = new Random();

    private String nom;
    private int vida;
    private int atac;
    private int experiencia;
    private int agilitat;
    private int forsa;
    private int[] posicio;
    private ArrayList<Tresor> equipament;
    private Arma arma;



    // ---------------------------------
    // --------- CONSTRUCTOR -----------
    // ---------------------------------



    public Personatge(String nom) {
        this.nom = nom;
        this.vida = rand.nextInt(5, 21);
        this.atac = rand.nextInt(1, 5);
        this.experiencia = 0;
        this.agilitat = rand.nextInt(4, 12);
        this.forsa = rand.nextInt(4, 12);
        this.posicio = new int[2];
        this.equipament = new ArrayList<>();
    }



    // ---------------------------------
    // ----- FUNCIONES OBLIGATORIOS ----
    // ---------------------------------



    public void atacar(Monstre m) {
        m.rebreDany(calcularAtac());

        if (m.estaViu()) {
            rebreDany(m.calcularAtac());
            System.out.println(m.getNom() + " - " + m.getVida());
        } else {
            this.experiencia += m.getValorExperiencia();
            System.out.println(m.getNom() + " ha muerto");
        }
    }

    public void explorar(Sala salaActual) {
        Scanner sc = new Scanner(System.in);
        Tresor t = salaActual.getTresor();
        Arma a = salaActual.getArma();

        if (t != null && equipament.size() < forsa) {
            equipament.add(t);
            System.out.println("Has encontrado y equipado: " + t);
            salaActual.setTresor(null);
        } else if (!(equipament.size() < forsa)) {
            System.out.println("Inventario lleno, no puedes coger el tresor.");
        } else {
            System.out.println("No hay tresor en esta sala.");
        }

        if (a != null) {
            if (arma == null) {
                arma = a;
                System.out.println("Has encontrado y equipado: " + a.getNom());
                salaActual.setArma(null);
            } else {
                System.out.println("Has encontrado " + a.getNom());
                System.out.println("Actualmente, tienes " + arma.getNom());
                System.out.println("¿Quieres cambiar el arma actual por una nueva? (S / N)");
                char resp = sc.next().charAt(0);

                if (resp == 'S') {
                    arma = a;
                    salaActual.setArma(null);
                }
            }
        }


    }

    public void moure(char direccio) {
        switch (direccio) {
            case 'W':
                setPosicio(this.posicio[0] - 1, this.posicio[1]);
                break;
            case 'S':
                setPosicio(this.posicio[0] + 1, this.posicio[1]);
                break;
            case 'D':
                setPosicio(this.posicio[0], this.posicio[1] + 1);
                break;
            case 'A':
                setPosicio(this.posicio[0], this.posicio[1] - 1);
                break;
        }
    }

    @Override
    public int calcularAtac() {
        int bonus = 0;

        if (this.arma != null) {
            if (arma.getTipus() == 1) {
                bonus = 1;
            }

            if (arma.getTipus() == 2 && rand.nextBoolean()) {
                bonus = 2;
            }

            if (arma.getTipus() == 3 && rand.nextInt(1, 11) <= 3) {
                bonus = 3;
            }
        }

        return rand.nextInt(1, (atac + 1)) + bonus;
    }

    @Override
    public void rebreDany(int quantitat) {
        this.vida -= quantitat;
    }

    @Override
    public boolean estaViu() {
        if (this.vida > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Nom: " + nom +
                " | Vida: " + vida +
                " | Agilitat: " + agilitat +
                " | Força: " + forsa +
                " | Posició: [" + posicio[0] + ", " + posicio[1] + "]" +
                " | Equipament: " + equipament.toString();
    }






    // ---------------------------------
    // ------ GETTERS + SETTERS --------
    // ---------------------------------




    public void setPosicio(int x, int y) {
        this.posicio[0] = x;
        this.posicio[1] = y;
    }

    public int getForsa() {
        return this.forsa;
    }

    public int getAgilitat() {
        return this.agilitat;
    }

    public int[] getPosicio() {
        return this.posicio;
    }

    public int getExperiencia() {
        return this.experiencia;
    }

    public int getTresorTotal() {
        return equipament.size();
    }

    public int getMonedas() {
        int monedas = 0;

        for (Tresor t : equipament) {
            monedas += t.getValor();
        }

        return monedas;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return this.vida;
    }

}
