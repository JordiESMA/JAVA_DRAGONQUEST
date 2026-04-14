public class Tresor {

    //ATRIBUTS

    private String nom;
    private int valor;
    private double pes;


    //CONSTRUCTOR
    
    public Tresor (int tipus){
        switch (tipus) {
            case 0:
                crearTresor("Cáliz", 80, 4);
                break;
            case 1:
                crearTresor("Diamante", 500, 4);
                break;
            case 2:
                crearTresor("Poción", 250, 4);
                break;
        }
    }

    //METODES
    @Override
    public String toString() {
        // Al usar 'pes' aquí, el error de VS Code desaparecerá
        return "Nom: " + nom + " Valor: " + valor + " monedes";
    }

    private void crearTresor(String nom, int valor, int pes) {
        this.nom = nom;
        this.valor = valor;
        this.pes = pes;
    }
}
