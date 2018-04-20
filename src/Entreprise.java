import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by TreVi1732721 on 2018-01-22.
 */
public class Entreprise implements Serializable {
    private String nom ;
    private Adresse adresseEntreprise = new Adresse() ;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresseEntreprise() {
        return adresseEntreprise;
    }

    public void setAdresseEntreprise(Adresse adresseEntreprise) {
        this.adresseEntreprise = adresseEntreprise;
    }

    public void NewEntreprise() {
        System.out.println("L'entreprise");
        System.out.print("  Quel est le nom de l'entreprise?");
        nom = VerifierLettre();
        adresseEntreprise.NewAdresse();

    }
    public void ModEntreprise() {
        System.out.println("L'entreprise");
        System.out.print("  Quel est le nom de l'entreprise("+nom+")?");
        String nouveau = VerifierLettre();
        if(nouveau.toUpperCase() != "NA") {
            nom = nouveau;
        }
        adresseEntreprise.ModAdresse();

    }
    public void PrintEntreprise(){
        System.out.println("Entreprise" +
                "\n     "+ nom);
        adresseEntreprise.PrintAdresse();
    }
    public static String VerifierLettre() {
        boolean test = true;
        String choix = "";
        Scanner sc = new Scanner(System.in);
        do {
            try {
                choix = sc.next();
                for (int i = 0; i < choix.length(); i++) {
                    if((int) choix.toUpperCase().charAt(i) > 90 || (int) choix.toUpperCase().charAt(i) < 65) {
                        throw new Main.WrongTypeExeption();
                    }
                }
                return choix;
            }catch (Main.WrongTypeExeption one) {
                System.out.print("Entrée selement des lettres valide svp.\n");
            }
        }
        while(test);
        return choix;

    }

}
