import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by TreVi1732721 on 2018-01-22.
 */
public class Telephone implements Serializable {
    private String information, numero;

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void NewTelephone() {
        System.out.println("Quel est le type de numero de téléphone?");
        information = VerifierLettre();
        System.out.println("Quel est le numero de téléphone?");
        numero = VerifierNumero();
    }
    public static String VerifierNumero() {
        boolean test = true;
        String choix = "";
        Scanner sc = new Scanner(System.in);
        do {
            try {
                choix = sc.next();
                for (int i = 0; i < choix.length(); i++) {
                    if(i==8|| i==4) {
                        if (choix.charAt(i)=='-'){
                            throw new Main.WrongTypeExeption();
                        }
                    }
                    else{
                        if ((int) choix.toUpperCase().charAt(i) > 57 || (int) choix.toUpperCase().charAt(i) <48) {
                            throw new Main.WrongTypeExeption();
                        }
                    }
                }
                return choix;
            }catch (Main.WrongTypeExeption one) {
                System.out.print("Entrée selement des chiffres valide svp.\n");
            }
        }
        while(test);
        return choix;

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
