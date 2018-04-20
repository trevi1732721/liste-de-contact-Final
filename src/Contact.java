import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by TreVi1732721 on 2018-01-22.
 */
public class Contact implements Serializable {
    private String prenom;
    private String nom;
    private Adresse adresse = new Adresse();
    private Occupation occupation = new Occupation();
    private List<Telephone> numTélephone = new ArrayList<Telephone>();
    private int telephone = 0,numero;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void NewContact(){
        int i = 0;
        Telephone nouveau = new Telephone();
        boolean choix = true;
        System.out.print("Nouveau contact\n");
        System.out.print("  Quel est le prenom du contact?\n");
        prenom = VerifierLettre();
        System.out.print("  Quel est le nom de famille du contact?\n");
        nom=VerifierLettre();
        adresse.NewAdresse();
        occupation.NewOccupation();
        NewTelephone();
    }
    public void ModContact(){
        System.out.print("Modifier contact\n");
        System.out.print("  Quel est le prenom du contact("+prenom+")?\n");
        if(VerifierLettre().toUpperCase() != "NA") {
            prenom = VerifierLettre();
        }
        System.out.print("  Quel est le nom de famille du contact("+nom+")?\n");
        if(VerifierLettre().toUpperCase() != "NA") {
            nom = VerifierLettre();
        }
        adresse.ModAdresse();
        occupation.ModOccupation();
    }
    public void PrintContact(){
        System.out.println("    nom : "+prenom +" "+nom );
        adresse.PrintAdresse();
        occupation.PrintOccupation();
        System.out.print("Téléphone\n");
        for (int i =0;i<telephone;i++) {
            System.out.println("  "+numTélephone.get(i).getInformation() + " - " + numTélephone.get(i).getNumero());
        }
    }
    public void NewTelephone(){
        telephone++;
        Telephone nouveau = new Telephone();
        boolean choix = true;
        while(choix){
            nouveau.NewTelephone();
            numTélephone.add(0,nouveau);
            System.out.print("  Voulez-vous ajouter un numero de téléphone?" +
                    "\n 1-oui" +
                    "\n 2-non\n");
            if(VerifierInt()== 2){
                choix = false;
            }
        }
    }
    public void ModTelephone(){
        int choix;
        for (Telephone telephone:numTélephone) {
            int i = 1;
            System.out.println(i + " - "+telephone.getNumero());
            i++;
        }
        System.out.println("quel est le contact a modifier?");
        choix = VerifierInt();
        Telephone nouveau = new Telephone();
            numTélephone.set(choix,nouveau);

    }public static String VerifierLettre() {
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
    public static int VerifierInt() {
        boolean test = true;
        int choix = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                choix = sc.nextInt();
                return choix;
            }catch (Exception one) {
                System.out.print("Entrée selement des chiffres svp.\n");
            }
        }
        while(test);
        return choix;

    }

}
