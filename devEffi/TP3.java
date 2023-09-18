import java.util.ArrayList;
import java.util.TreeSet;

public class Pays {
    private String nom;
    private TreeSet<String> paysLimitrophes;

    // Constructeur avec le nom du pays
    public Pays(String nom) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom du pays est invalide.");
        }
        this.nom = nom;
        this.paysLimitrophes = new TreeSet<>();
    }

    // Constructeur avec le nom du pays et un tableau de noms de pays voisins
    public Pays(String nom, String[] voisins) {
        this(nom); // Appel du constructeur précédent pour valider le nom du pays
        for (String voisin : voisins) {
            ajouterVoisin(voisin);
        }
    }

    // Méthode pour ajouter un pays limitrophe
    public void ajouterLimitrophe(Pays limitrophe) {
        if (limitrophe == null) {
            throw new IllegalArgumentException("Le pays limitrophe ne peut pas être nul.");
        }
        if (limitrophe.equals(this)) {
            throw new IllegalArgumentException("Un pays ne peut pas être limitrophe de lui-même.");
        }
        this.paysLimitrophes.add(limitrophe.getNom());
    }

    // Méthode pour déterminer si un pays est limitrophe
    public boolean estLimitrophe(Pays autrePays) {
        if (autrePays == null) {
            throw new IllegalArgumentException("Le pays à vérifier ne peut pas être nul.");
        }
        return this.paysLimitrophes.contains(autrePays.getNom());
    }

    // Méthode pour obtenir le nombre de pays limitrophes
    public int getNombreLimitrophes() {
        return this.paysLimitrophes.size();
    }
    // Méthode pour ajouter un pays voisin
    public void ajouterVoisin(String voisin) {
        if (voisin == null || voisin.isBlank()) {
            throw new IllegalArgumentException("Le nom du voisin est invalide.");
        }
        this.paysLimitrophes.add(voisin);
    }

    // Méthode pour vérifier si un pays est voisin
    public boolean estVoisin(String autrePays) {
        return this.paysLimitrophes.contains(autrePays);
    }

    // Méthode pour obtenir le nombre de pays limitrophes
    public int getNombreLimitrophes() {
        return this.paysLimitrophes.size();
    }

    // Méthode pour vérifier si une liste de noms correspond aux pays limitrophes
    public boolean correspondentLimitrophes(ArrayList<String> listeNoms) {
        return this.paysLimitrophes.containsAll(listeNoms);
    }

    // Méthode pour compter combien de pays de la liste sont des pays limitrophes
    public int compterLimitrophes(ArrayList<String> listeNoms) {
        int count = 0;
        for (String nom : listeNoms) {
            if (this.paysLimitrophes.contains(nom)) {
                count++;
            }
        }
        return count;
    }

    // Accesseur sur le nom du pays
    public String getNom() {
        return nom;
    }

    // Accesseur sur l'ensemble des pays limitrophes
    public TreeSet<String> getPaysLimitrophes() {
        return paysLimitrophes;
    }

    // Méthode toString pour afficher la description du pays
    @Override
    public String toString() {
        return nom + " a pour voisin : " + paysLimitrophes;
    }
}
