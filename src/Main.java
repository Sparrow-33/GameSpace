import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import com.bethecoder.ascii_table.ASCIITable;
import static java.lang.System.exit;


public class Main {
    private static ArrayList<Joueur> joueurs = new ArrayList<>();
    private static final ArrayList<Poste> postes = new ArrayList<>();
    public static ArrayList<Joueur> listeAttente = new ArrayList<>();



    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choisir : ");
    }

    public static void main(String[] args) {

              String jeu;

        Poste poste1 = new Poste("Xbox","Dell");
        postes.add(poste1);
        Poste poste2 = new Poste("Xbox","Dell");
        postes.add(poste2);
        Poste poste3 = new Poste("Xbox","Dell");
        postes.add(poste3);
        Poste poste4=  new Poste("Xbox","Asus");
        postes.add(poste4);
        Poste poste5 = new Poste("PS5","Hp");
        postes.add(poste5);
        Poste poste6 = new Poste("PS5","Asus");
        postes.add(poste6);
        Poste poste7 = new Poste("PS5","Asus");
        postes.add(poste7);
        Poste poste8 = new Poste("Nintendo","Samsung");
        postes.add(poste8);
        Poste poste9 = new Poste("Nintendo","Samsung");
        postes.add(poste9);

        String[] options = {"1- Poste",
                "2- Nouveau joueur",
                "3- Liste d'attente",
                "4- Tarifs",
                "5- Revenu du jour",
                "6- Revenu de mois",
                "7- Quitter",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option!=7){
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
                   case 1: showPoste(); break;
                   case 2: addGamer(); break;
                   case 3: getListeAttente();  break;
                   case 4:showPrice();break;
                   case 5: revenuJour();break;
                   case 6:;break;
                   case 7: exit(0);
                }
            }
            catch (Exception ex){
                System.out.println("Selectionner entre 1 and " + options.length);
                scanner.next();
            }
        }


        System.out.println("Poste valable : ");



      addGamer();
      addGamer();

      displayGamers();


    }

  private static void showPoste(){
      String [] tableHeaders = { " Poste", "Console", "Ecran","Etat"};
      String[][] tableTest = {
              {""+postes.get(0).getPoste(),""+postes.get(0).getConsole(),""+postes.get(0).getEcran(),""+postes.get(0).isReserve()},
              {""+postes.get(1).getPoste(),""+postes.get(1).getConsole(),""+postes.get(1).getEcran(),""+postes.get(1).isReserve()},
              {""+postes.get(2).getPoste(),""+postes.get(2).getConsole(),""+postes.get(2).getEcran(),""+postes.get(2).isReserve()},
              {""+postes.get(3).getPoste(),""+postes.get(3).getConsole(),""+postes.get(3).getEcran(),""+postes.get(3).isReserve()},
              {""+postes.get(4).getPoste(),""+postes.get(4).getConsole(),""+postes.get(4).getEcran(),""+postes.get(4).isReserve()},
              {""+postes.get(5).getPoste(),""+postes.get(5).getConsole(),""+postes.get(5).getEcran(),""+postes.get(5).isReserve()},
              {""+postes.get(6).getPoste(),""+postes.get(6).getConsole(),""+postes.get(6).getEcran(),""+postes.get(6).isReserve()},
              {""+postes.get(7).getPoste(),""+postes.get(7).getConsole(),""+postes.get(7).getEcran(),""+postes.get(7).isReserve()},
              {""+postes.get(8).getPoste(),""+postes.get(8).getConsole(),""+postes.get(8).getEcran(),""+postes.get(8).isReserve()},
      };
      ASCIITable.getInstance().printTable(tableHeaders, tableTest);
  }
  private static void showPrice(){
      String [] tableHeaders = { "","Duree", "Prix"};
      String[][] tableData = {
              {"1","30 MIN", "5 DH"},
              {"2","1 H", "10 DH"},
              {"3","2 H", "18 DH"},
              {"4","5 H", "40DH"},
              {"5","LUXE", "65 DH"}
      };
      ASCIITable.getInstance().printTable(tableHeaders, tableData);
  }

  private static void addGamer(){
      final  Scanner scan = new Scanner(System.in);
      int poste = 0;

      int choix;
      double prix = 0;

      System.out.println("Poste choisie : ");
     int numPoste = scan.nextInt();
      switch (numPoste) {
          case 1 -> poste = 1;
          case 2 -> poste = 2;
          case 3 -> poste = 3;
          case 4 -> poste = 4;
          case 5 -> poste = 5;
          case 6 -> poste = 6;
          case 7 -> poste = 7;
          case 8 -> poste = 8;
          case 9 -> poste = 9;
          default -> {

          }
      }

      System.out.print("Nom: ");
      scan.nextLine();
      String nom = scan.nextLine();

      System.out.print("Prenom: ");
      String prenom = scan.nextLine();

      showPrice();

      String duree = scan.nextLine();

      switch (duree) {
          case "1" -> prix = 5;
          case "2" -> prix = 10;
          case "3" -> prix = 18;
          case "4" -> prix = 40;
          case "5" -> prix = 65;
          default -> {
          }
      }

      System.out.print("Jeu: ");
      String Jeu = scan.nextLine();

     Joueur gamer = new Joueur(nom,prenom,duree,prix,poste);

     System.out.println("1- Affecter le poste.");
     System.out.println("2- Ajouter en file d'attente.");
     choix = scan.nextInt();

      switch (choix) {
          case 1 -> {
              postes.get(poste - 1).reserve = true;
              Session session = new Session(gamer, postes.get(poste - 1), listeAttente);
          }
          case 2 -> listeAttente.add(gamer);
      }
      joueurs.add(gamer);

  }
  private static void displayGamers(){
      for (Joueur joueur : joueurs) {
          System.out.println(joueur);
      }
  }
  private static void getListeAttente(){
      String [] tableHeaders = { " Ordre", "Nom", "Code","Poste"};
      String[][] tableData = new String[listeAttente.size()][4];

      if (listeAttente.isEmpty()){ System.out.println("La liste est vide pour le moment...");}
      System.out.println("+-----Liste d'attente-------+");
      for (Joueur joueur : listeAttente) {
          System.out.println(joueur);
          System.out.println("        ----");
      }

  }

  private static void revenuJour(){
       double revenu = 0;

       LocalDate date = LocalDate.now();
       LocalTime heureDeDebut = LocalTime.now();
      for (Joueur joueur : joueurs) {
          revenu += joueur.getPrix();
      }
      System.out.println("Revenu d'aujourd'hui le "+ date+". Jusqu'à "+heureDeDebut+": "+revenu);
  }

}