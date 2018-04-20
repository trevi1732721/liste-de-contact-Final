import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by TreVi1732721 on 2018-02-26.
 */
public class Main implements Serializable{

    public static class WrongTypeExeption extends Exception{}

    protected static HashMap<String, Contact> listeContact = new HashMap<String, Contact>();
    protected static Contact nouveauContact = new Contact();
    public static void main(String[] args) {

        //new liste

        boolean run = true, exeption = true;
        String choix = "0";
        int choixInt = 0;

       while(run){
            exeption = true;
           System.out.println("Que voulez vous faire?" +
                   "\n1- Nouveau contact" +
                   "\n2- Afficher les contacts" +
                   "\n3- Modifier et ajouter un numero de téléphone" +
                   "\n4- Modifier un contact" +
                   "\n5- Effacer un contact" +
                   "\n6- Charger la liste");

           switch(VerifierInt()) {
               case 1:
                   nouveauContact.NewContact();
                   listeContact.put(nouveauContact.getPrenom(), nouveauContact);
                   break;
               case 2:
                   System.out.println("Quel est le contact à afficher?");
                   exeption = true;
                   while(exeption){
                       try{
                           choix = VerifierLettre();
                           System.out.println("___________________________________");
                           System.out.println("Contact " + choix);
                           listeContact.get(choix).PrintContact();
                           System.out.println("\n___________________________________");
                           exeption=false;
                       }
                       catch(Exception one){
                           System.out.print("Entrée un contact valide svp.");
                       }
                   }


                   break;
               case 3:
                   System.out.println("Que voulez vous faire?" +
                           "\n 1- modifier un numero" +
                           "\n 2- ajouter un numero");
                   try{
                   choixInt = VerifierInt();
                   if(choixInt==1){
                       System.out.println("modifier quel contact?");
                       exeption = true;
                       while(exeption){
                           try{
                               choix = VerifierLettre();
                               listeContact.get(choix).ModTelephone();
                               exeption=false;
                           }
                           catch(Exception one){
                               System.out.print("Entrée un contact valide svp.");
                           }
                       }


                   }else if(choixInt==2){
                       System.out.println("Ajouter un numero a quel contact?");
                       exeption = true;
                       while(exeption){
                           try{
                               choix = VerifierLettre();
                               listeContact.get(choix).NewTelephone();
                               exeption=false;
                           }
                           catch(Exception one){
                               System.out.print("Entrée un contact valide svp.");
                           }
                       }
                   }else {
                       System.out.println("Selection invalide, veuiller faire un choix valide.");
                   }}catch(Exception one){
                       System.out.print("vous devez entrée une selection valide!");
                   }
                   break;
               case 4:
                   System.out.println("Quel est le contact à modifier?");
                   exeption = true;
                   while(exeption){
                       try{
                           choix = VerifierLettre();
                           listeContact.get(choix).ModContact();
                           exeption=false;
                       }
                       catch(Exception one){
                           System.out.print("Entrée un contact valide svp.");
                       }
                   }
                   break;
               case 5:
                   System.out.print("Quel est le contact à effacer?");
                   exeption = true;
                   while(exeption){
                       try{
                           choix = VerifierLettre();
                           listeContact.remove(choix);
                           exeption=false;
                       }
                       catch(Exception one){
                            System.out.print("Entrée un contact valide svp.");
                       }
                   }
                   break;
               case 6:
                   Charger();
               default:
           }
               Sauvegarder();
               System.out.print("voulez vous continuer la liste de contacts?" +
                       "\n  1- oui" +
                       "\n  2- non \n");
               if (VerifierInt() == 2){
                   run = false;
               }

       }
    }
    public static void Sauvegarder(){
        try {
            ObjectOutputStream sortieListe = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("test.dat")));
            sortieListe.writeObject(listeContact);
            sortieListe.close();
            System.out.println("Le programme a été enregistré !");
        }catch (Exception two){
            System.out.println("Le programme n'a pas été enregistré");
        }
    }
    public static void Charger(){
        try{
            ObjectInputStream entree = new ObjectInputStream(new BufferedInputStream(new FileInputStream("test.dat")));
            listeContact = (HashMap<String, Contact>) entree.readObject();
            entree.close();
            System.out.println("Le programme a été charger !");
        }catch(Exception one){
            System.out.println("Le programme n'a pas trouvé d'enregistrement");
        }
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
                System.out.print("Entrée selement des lettres svp.\n");
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
