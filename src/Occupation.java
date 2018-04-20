import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by TreVi1732721 on 2018-01-22.
 */
public class Occupation implements Serializable{
    private String poste;
    private Entreprise entreprise = new Entreprise();

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public void NewOccupation() {
        System.out.print("  Quel est l'emplois du contact?");
        poste = VerifierLettre();
        entreprise.NewEntreprise();
    }
    public void ModOccupation() {
        System.out.print("  Quel est l'emplois du contact("+poste+")?");
        String nouveau = VerifierLettre();
        if(nouveau.toUpperCase() != "NA") {
            poste = nouveau;
        }
        entreprise.ModEntreprise();
    }
    public void PrintOccupation(){
        System.out.println("    poste : "+ poste);
        entreprise.PrintEntreprise();
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
