package utilitaires_ihms;

import donnees.Enseignant;
import donnees.Etudiant;
import donnees.Matiere;
import donnees.Utilisateur;

import java.util.ArrayList;
import java.util.List;

public class GestionNotes {

    private static List<Utilisateur> utilisateurs = new ArrayList();
    private static ArrayList<Matiere> matieres = new ArrayList();

    /**
     * Effectue les traitements suivants :
     * 1. Utilise ConnxionBD pour obtenir une session de connexion à la la base de données.
     * 2. Recherche tous les documents représentant les enseignants avec les matières qui leur sont
     * associées, les traduit en document Json puis en objets instances de la classe Enseignant avant
     * de les mémoriser dans la liste des utilisateurEnregistres.
     * 3. Recherche tous les documents représentant les étudiants avec les notes qui leur sont
     * associées, les traduit en document Json puis en objets instances de la classe Etudiant
     * avant de les mémoriser dans la liste des utilisateurEnregistres.
     * Lève AccesBDException si la session ne peut pas être ouverte ou si la recherche dans la BD
     * échoue.
     */
    public static void chargerDonnees() throws Exception {
        // TO DO

    }

    /**
     * Recherche dans la liste utilisateursEnregistres un utilisateur possédant l'identifiant et
     * le mot de passe spécifés et renvoie l'utilisateur correspondant s'il en existe.
     * Lève IdentificationException sinon.
     */
    public static Utilisateur connecter(String idutilisateur, String motDePasse)
            throws IdentificationException {
        for (Utilisateur u : utilisateurs) {
            if (u.getId().equals(idutilisateur)
                    & u.getMotDePasse().equals(motDePasse))
                return u;
        }
        throw new IdentificationException();
    }

    /**
     * Recherche et renvoie les matières enseignées par un enseigan en exploitant la liste des ids
     * des matières enseignées et la liste des objets instances de la classe Matiere mémorisés dans
     * l'attribut matieres.
     */
    public static ArrayList<Matiere> matieresEnseignees(Enseignant enseignant) {
        ArrayList<Matiere> result = new ArrayList();
        ArrayList<String> idsMatieresEnseignees = enseignant.getIdsMatieresEnseignees();
        for (Matiere matiere : matieres) {
            if (idsMatieresEnseignees.contains(matiere.getId()))
                result.add(matiere);
        }
        return result;
    }

    /**
     * Rechercher les objets Etudiants inscrits dans une matière en exploitant les ids des étudiants
     * inscrits dans la matière et les objets instances de la classe Etudiant mémorisés dans
     * l'attribut utilisateurs.
     */
    public static ArrayList<Etudiant> etudiantsInscrits(Matiere matiere) {
        ArrayList<Etudiant> result = new ArrayList();
        ArrayList<String> idsEtudiantsInscrits
                = matiere.getIdsEtudiantsInscrits();
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur instanceof Etudiant
                    && idsEtudiantsInscrits.contains(utilisateur.getId()))
                result.add((Etudiant) utilisateur);
        }
        return result;
    }

    /**
     * Ajoute une note à un étudiant dans une matière où il n'a aucune note. La note est enregistrée
     * dans la base de donnée et dans l'objet Etudiant  correspondant à l'id spécifié.
     * Ne fait rien si valeur non comprise en 0 et 20 ou si l'étudiant a déjà une note dans la
     * matière. Lève une Exception sans rien ajouter si problème d'accès à la base de données.
     */
    public static void ajouterNote(Etudiant etudiant, String idMatiere,
                                   float valeur) throws Exception {
        // TO DO
    }

    /**
     * Modifie la note d'un étudiant dans une matière où il a déjà une note. Remplace dans la base
     * de données et dans l'objet Etudiant correspondant à l'id spécifié la note dans la matière
     * spécifiée par nouvelleValeur. Ne fait rien si la nouvelle valeur n'est pas comprise en 0 et 20
     * ou si l'étudiant n'a pas déjà une note dans la matière.
     * Lève une Exception sans rien modifier si problème d'accès à la base de données.
     */
    public static void modifierNote(Etudiant etudiant, String idMatiere,
                                    float nouvelleNote) throws Exception {
        // TO DO
    }

    /**
     * Supprime la note d'un étudiant dans une matière. Supprime la note dans la base de données et
     * dans l'objet Etudiant correspondant à l'id spécifié. Ne fait rien si l'étudiant n'a pas de
     * note dans cette matière ou s'il n'a aucune note.
     * Lève une Exception sans rien supprimer si problème d'accès à la base de données.
     */
    public static void supprimerNote(Etudiant etudiant, String idMatiere)
            throws Exception {
        // TO DO
    }
}