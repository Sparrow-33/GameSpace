import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

@Getter
@Setter
@ToString

public class Session {
    Timer timer = new Timer();
    private LocalDate date = LocalDate.now();
    private LocalTime heureDeDebut = LocalTime.now();
    private String duree;
    private String code;


    public Session(Joueur joueur, Poste poste, ArrayList<Joueur> list) {
        this.duree = joueur.getDuree();
        this.code = joueur.getCode();

       timer.schedule(new TimerTask() {
            @Override
            public void run() {
                poste.setReserve(false);
                System.out.println("Poste "+poste.getPoste()+" est libre.Session terminee!");

                for (int i=0; i< list.size();i++){
                      if (joueur.getPoste() == list.get(i).getPoste()){
                          poste.setReserve(true);
                          new Session(list.get(i), poste, list );
                          list.remove(i);
                          System.out.println("joueur à pris son poste. debut de la session!");
                          return;
                      }
                }
            }
        },5000);
    }






}
