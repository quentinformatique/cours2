import java.util.ArrayList;
import java.util.List;



public class GestionNotes {
    
    private static String nomFichierDonnees;

    /**
     * <Enter note text here>
     */
    
    private static List<Utilisateur> utilisateursEnregistres = new ArrayList<Utilisateur> ();

    /**
     * - nomFichierDonnees : chemin d'accès au fichier d'enregistrement des données.
     * - main(): Initialise les données puis affiche un menu permettant à l'utilisateur de se connecter et d'exécuter les opérations qu'il est autorisé à exécuter selon sa catégorie. Séquence des traitements effectués : 
     * 1. Appelle verrouDonneesFerme() pour determiner si les données sont verrouillées et attendre que le verrouillage soit levé.
     * 2. Appelle verrouillerDonnees() et initialiserDonnees() pour créer ou charger les données.
     * 3. Affiche un menu permettant à l'utilisateur de se connecter à l'aide de son identifiant et son mot de passe. 
     * 4. Appelle sessionEnseignant() ou sessionEtudiant() selon le type de l'utilisateur connecté si la connexion est réussie.
     * 5. Enregistre les données sur fichier et lève le verrouillage lorsque la session est terminée.
     */
    
    public static void main(List<String> args) {
    }

    /**
     * sessionEnseignant(e): Affiche en boucle le menu des opérations possibles pour un enseignant e. Opérations possibles : afficher, saisir ou modifier les notes d'une matière qu'il enseigne.
     */
    
    private static void sessionEnseignant(Enseignant enseignant) {
    }

    /**
     * sessionEtudiant(e): Affiche toutes les notes d'un étudiant e.
     */
    
    private static void sessionEtudiant(Etudiant etudiant) {
    }

    /**
     * connecter(id,pass) : Vérifie l'existence d'un utilisateur possédant l'identifiant id et le mot de passe pass et renvoie cet utilisateur s'il en existe. Lève IdentificationException sinon.
     */
    
    private static Utilisateur connecter(String identifiant, String motDePasse) throws IdentificationException {
        // STUB
        return null;
    }

    /**
     * initialiserDonnees(): Initialiser toutes les données de l'application. Si données enregistrées sur fichier, les charger. Sinon, créer les données initiales.
     */
    
    private static void initialiserDonnees() {
        Matiere matiere = new Matiere("statistiques");
    }

    /**
     * enregistrerDonnees(): Enregisrer les données dans le fichier "donnees" sous la forme d'objets sérialisés dans le dossier du projet.
     */
    
    private static void enregistrerDonnees() {
        System.out.println("enregistrement des données");
    }

    /**
     * verrouDonneesFerme(): Vérifie si les données sont verrouillées.
     */
    
    private static boolean verrouDonneesFerme() {
        System.out.println("verrou de données ferme");
        return false;
    }

    /**
     * verrouillerDonnees(): Pose un verrou (fermé) sur les données.
     */
    
    private static void verrouillerDonnees() {
        System.out.println("verouillage des données");
    }

    
    private static void deverrouillerDonnees() {
        System.out.println("deverouillage des données");
    }

}
