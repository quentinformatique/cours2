

import java.util.Scanner;

class GestionNotes {
    
  private static Utilisateur[] utilisateursEnregistres ;

  /**
   * main(): Initialise les données puis affiche un menu permettant à l'utilisateur de se connecter 
   * et d'exécuter les opérations qu'il est autorisé à exécuter selon sa catégorie. 
   * Séquence des traitements effectués : 
   * - Appelle verrouDonneesFerme() pour determiner si les données sont verrouillées et attendre 
   * que le verrouillage soit levé.
   * - Appelle verrouillerDonnees() et initialiserDonnees() pour créer ou charger les données.
   * - Affiche un menu permettant à l'utilisateur de se connecter à l'aide de son identifiant et
   * son mot de passe. 
   * - Appelle sessionEnseignant() ou sessionEtudiant() selon le type de l'utilisateur connecté 
   * si la connexion est réussie et enregistre les données sur fichier après une session enseignant.
   * - Lève le verrouillage lorsque la session enseignant ou étudiant est terminée et met fin 
   * à l'application.
   */

  // Dans cette version : le verrouillage et l'enregistrement et la restauration des données
  // n'est pas géré.
  // Après la fin d'une session Enseignant ou Etudiant, on ne quitte pas l'application pour
  // ne pas perdre les modifications des données

  public static void main(String[] args) {
      
    // 1. Attendre si nécessaire que les données ne soient plus verrouillées
    if (verrouDonneesFerme()) {
        System.out.println("Données en cours d'utilisation. Attendez...");
        while (verrouDonneesFerme());
    }
    
    // 2. Verrouilage puis initialisation des données
    verrouillerDonnees();
    initialiserDonnees();
    
    // 3. Menu pour se connecter ou quitter. Appel sessionEnseignant() ou sessionEtudiant() selon le 
    // type de l'utilisateur connecté et enregistrement des données après une session enseignant. 
    Scanner scan = new Scanner(System.in);
    boolean quitter = false;
    String choix;
    while (!quitter) {
        System.out.println("(1) - Se connecter");
        System.out.println("(2) - Quitter");
        System.out.print("Votre choix ? ");
        choix = scan.next();
        switch (choix) {
        case "1" :   
            String identifiant, motDePasse;
            Utilisateur utilisateur;
            System.out.print("Votre identifiant ? ");
            identifiant = scan.next();
            System.out.print("Votre mot de passe ? ");
            motDePasse = scan.next();
            try {
                utilisateur = connecter(identifiant, motDePasse);
                if (utilisateur instanceof Enseignant) {
                    sessionEnseignant((Enseignant)utilisateur);
                    enregistrerDonnees();
                }
                else if (utilisateur instanceof Etudiant) 
                    sessionEtudiant((Etudiant)utilisateur);
            } 
            catch(IdentificationException e) {
                System.out.println("Identifiant ou mot de passe incorrect !");
            }
            break;
        case "2" :
            quitter = true;
            break;
        default :
            System.out.println("Choix mal saisi !");
        }
    }
    // 4. Lever le verrou sur les données
        deverrouillerDonnees();
    }

    /**
     * Affiche en boucle le menu des opérations possibles pour un enseignant.
     * Opérations possibles : afficher, saisir ou modifier les notes d'une matière qu'il enseigne.
     */   
    private static void sessionEnseignant(Enseignant enseignant) {
      Matiere[] matieres = enseignant.matieresEnseignees;
      Scanner scan = new Scanner(System.in);
      boolean finSession = false;
      String choix ;
      
      while (!finSession) {
        
        // 1. Menu pour choisir une des matières enseignées
        
        System.out.println("Sélectionnez la matière dont vous voulez manipuler les notes :");
        int n = 1;
        for(Matiere m: matieres)
          System.out.println("("+ n++ +") - "+ m.intitule);
        System.out.println("("+n+") - Quitter la session");
        System.out.print("Votre choix ? ");
        choix = scan.next();
        try {
          n = Integer.parseInt(choix);
          
        // 2. Si choix d'une matière
        
          if (n <= matieres.length) {
            // Matière choisie = matieres[n-1]
            matieres[n-1].modifierNotes();
          }
          
        // 3. Si choix de quitter la session
          
          else if (n == matieres.length+1) finSession = true;
          
        // 4. Choix en dehors des options du menu
          
          else System.out.println("Choix mal saisi !");
        }
        
        // 5. Le choix saisi n'est pas un entier
        
        catch(NumberFormatException e) {System.out.println("Choix mal saisi !");}
      }
    }

    /**
     * Affiche les notes d'un étudiant dans toutes les matières où il est inscrit.
     */  
    private static void sessionEtudiant(Etudiant etudiant) {
        System.out.print(etudiant.notesToString());
    }

    /**
     * Vérifie l'existence d'un utilisateur possédant l'identifiant id et le mot de passe pass
     * et renvoie cet utilisateur s'il en existe. Lève IdentificationException sinon.
     */  
    private static Utilisateur connecter(String identifiant, String motDePasse) throws IdentificationException {
      for(Utilisateur u : utilisateursEnregistres) {
        if (u.identifiant.equals(identifiant) & u.motDePasse.equals(motDePasse))
          return u;
      }
      throw new IdentificationException();
    }

    /**
     * Initialiser toutes les données de l'application. 
     * Si données enregistrées sur fichier, les charger. Sinon, créer les données initiales.
     */
    
    private static void initialiserDonnees() {

        // 1. Cas données enregistrées sur fichier dont le nom est défini dans nomFichierdonnees
        // To do : les charger. 

        // 2. Cas données non déjà enregistrées
        //--- 2.1 Créer Matières
        Matiere math = new Matiere("Mathématiques");
        Matiere java = new Matiere("Programmation Java");
        Matiere coo = new Matiere("Conception Objet");
        Matiere anglais = new Matiere("Anglais");

        //--- 2.2 Créer Enseignants et matières enseignées
        Enseignant e1 = new Enseignant("DUPOND", "Paul", "dupondpaul", "123");
        e1.setMatieresEnseignees(math);
        Enseignant e2 = new Enseignant("MACHIN", "Rémy", "machinremy", "456");
        e2.setMatieresEnseignees(java, coo);
        Enseignant e3 = new Enseignant("JOHNSON", "Boris", "johnsonboris", "789");
        e3.setMatieresEnseignees(anglais);

        //--- 2.3 Créer Etudiants et matières auxquelles ils sont inscrits
        Etudiant et1 = new Etudiant("CARTIER", "Axel","cartieraxel","1");
        Etudiant et2 = new Etudiant("BARTHEZ", "Enzo","barthezenzo","2");
        Etudiant et3 = new Etudiant("MANOUKIAN", "Léa","manoukianlea","3");
        Etudiant et4 = new Etudiant("PETRUZZI", "Tony","petruzzitony","4");
        Etudiant et5 = new Etudiant("DUTRONC", "Maxime","dutroncmaxime","5");
        Etudiant et6 = new Etudiant("MONTALBAN", "Maéva","montalbanmaeva","6");
        math.setEtudiantsInscrits(et1, et2, et3);
        java.setEtudiantsInscrits(et1, et2, et3, et4, et5, et6);
        coo.setEtudiantsInscrits(et1, et2, et3, et4, et5, et6);
        anglais.setEtudiantsInscrits(et4, et5, et6);

        //--- 2.4 Créer Utilisateurs enregistrés
        utilisateursEnregistres = new Utilisateur[]{e1, e2, e3, et1, 
          et2, et3, et4, et5, et6};
      
    }

    /**
     * Enregisrer les données dans le fichier "donnees" sous la forme d'objets sérialisés 
     * dans le dossier du projet.
     */  
    private static void enregistrerDonnees() {
      // To do
      System.out.println("==> Appel enregistrerDonnees()");
    }

    /**
     * Vérifie si les données sont verrouillées.
     */   
    private static boolean verrouDonneesFerme() {
      // To do
      System.out.println("==> Appel verrouDonneesFerme()");
      return false;
    }

    /**
     * Pose un verrou (fermé) sur les données.
     */   
    private static void verrouillerDonnees() {
      // To do
      System.out.println("==> Appel verrouillerDonnees()");
    }

    /** 
      * Lever le verrou sur les données.
      */    
    private static void deverrouillerDonnees(){
      // To do
      System.out.println("==> Appel deverrouillerDonnees()");
    }

}
