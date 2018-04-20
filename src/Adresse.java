import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by TreVi1732721 on 2018-01-22.
 */
public class Adresse implements Serializable{
    private String rue, appartement, ville, province, pays, numCivique;

    public String getNumCivique() {
        return numCivique;
    }

    public void setNumCivique(String numCivique) {
        this.numCivique = numCivique;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getAppartement() {
        return appartement;
    }

    public void setAppartement(String appartement) {
        this.appartement = appartement;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void NewAdresse(){
        System.out.print("Adresse\n");
        System.out.print("  Quel est le numero civic?");
        numCivique = VerifierNumCivic();
        System.out.print("  Quel est le nom de rue?");
        rue =VerifierLettre();
        System.out.print("  Quel est l'appartement?(Écrire NA si ça ne s'applique pas)");
        appartement=VerifierLettre();
        System.out.print("  Quel est la ville?");
        ville = VerifierLettre();
        System.out.print("  Quel est la province?");
        province = VerifierLettre();
        System.out.print("  Quel est le pays?");
        pays =VerifierLettre();
    }
    public void ModAdresse(){

        System.out.print("Adresse\n");
        System.out.print("  Quel est le numero civic("+ numCivique +")?");
        String nouveau = VerifierNumCivic();
        if(nouveau != "NA") {
            numCivique = nouveau;
        }
        System.out.print("  Quel est le nom de rue("+ rue +")?");
        nouveau = VerifierLettre();
        if(nouveau.toUpperCase() != "NA") {
            rue = nouveau;
        }
        System.out.print("  Quel est l'appartement("+ appartement +")?");
        nouveau = VerifierLettre();
        if(nouveau.toUpperCase() != "NA") {
            appartement = nouveau;
        }
        System.out.print("  Quel est la ville("+ ville +")?");
        nouveau = VerifierLettre();
        if(nouveau.toUpperCase() != "NA") {
            ville = nouveau;
        }
        System.out.print("  Quel est la province("+ province +")?");
        nouveau = VerifierLettre();
        if(nouveau.toUpperCase() != "NA") {
            province = nouveau;
        }
        System.out.print("  Quel est le pays("+ pays +")?");
        nouveau = VerifierLettre();
        if(nouveau.toUpperCase() != "NA") {
            pays =nouveau;
        }
    }
    public void PrintAdresse(){
        System.out.println("    numero civique : "+ numCivique+
        "\n"+ "     rue : "+rue+
        "\n"+ "     appartement : "+appartement+
        "\n"+ "     ville : "+ville+
        "\n"+ "     privince : "+province+
        "\n"+ "     pays : "+ pays);
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
    public static String VerifierNumCivic() {
        boolean test = true;
        String choix = "";
        Scanner sc = new Scanner(System.in);
        do {
            try {
                choix = sc.next();
                for (int i = 0; i < choix.length(); i++) {
                    if(((int) choix.toUpperCase().charAt(i) > 57 || (int) choix.toUpperCase().charAt(i) < 48) && choix != "NA") {
                        throw new Main.WrongTypeExeption();
                    }
                }
                return choix;
            }catch (Main.WrongTypeExeption one) {
                System.out.print("Entrée selement des caractère valide svp.\n");
            }
        }
        while(test);
        return choix;

    }
}
