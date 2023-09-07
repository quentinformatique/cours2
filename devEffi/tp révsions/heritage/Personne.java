/**
 * classe permettant de gerer une personne 
 * Personne.java                                        06/09/2023
 */

package heritage;

import java.util.Scanner;

/**
 * classe permettant de reprensenter une personne 
 * @author Cotes quentin
 */

public class Personne extends Individu {

    private String email;

    private Telephone telephone;

    public Personne() {
        super();
        this.email = "inconnu";
        this.telephone = new Telephone();
    }

    public Personne(String nom, String prenom) {
        super(nom, prenom);
        this.email = "inconnu";
        this.telephone = new Telephone();
    }

    public Personne(String nom, String prenom, String email, Telephone telephone) {
        super(nom, prenom);
        this.email = "inconnu";
        this.telephone = telephone;
    }

    public void afficher() {
        System.out.println(super.toString());
        System.out.println("email :" + this.email);
        System.out.println("telephone :" + this.telephone);
    }

    public void saisir() {
        super.saisir();
        Scanner entree = new Scanner(System.in);
        System.out.println("email :");
        this.email = entree.nextLine();
        this.telephone.saisir();
    }

    public String information() {
        return super.toString() + " " + this.email + " " + this.telephone;
    }

}