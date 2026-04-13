public class Tresor {

    //ATRIBUTS

    private String nom;
    private int valor;
    private double pes;

    //CONSTRUCTOR
    
    public Tresor (String nom, int valor, double pes){
        this.nom = nom;
        this.valor = valor;
        this.pes = pes;
    }

    //METODES
    @Override
    public String toString() {
        // Al usar 'pes' aquí, el error de VS Code desaparecerá
        return "Nom: " + nom + " \n Valor: " + valor + " monedes";
    }
}
