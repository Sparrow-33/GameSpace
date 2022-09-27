import lombok.Getter;
import lombok.ToString;
import java.util.UUID;


@Getter
@ToString

public final class Joueur {
    private String nom;
    private String prenom;
    private String code = UUID.randomUUID().toString();;
    private String duree;
    private int poste;
    private double prix;

    public static int numDeJoueur = 0;

    public Joueur(String nom, String prenom, String duree, double prix, int poste){
        numDeJoueur++;
        this.nom = nom;
        this.prenom = prenom;
        this.duree = duree;
        this.prix = prix;
        this.poste = poste;

    }



}
