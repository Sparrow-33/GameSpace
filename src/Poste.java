import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Poste {
    public static int num = 0;
    public int poste;
    public String console;
    public String ecran;
    public boolean reserve = false;

    public Poste(String console, String ecran){
        num++;
        this.poste = num;
        this.console = console;
        this.ecran = ecran;

    }


}
