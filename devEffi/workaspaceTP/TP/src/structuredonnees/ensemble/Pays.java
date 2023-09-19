package structuredonnees.ensemble;

import java.util.TreeSet;
import java.util.ArrayList;

public class Pays {
	
	private String nom;
	
	private TreeSet<String> voisins;

	public Pays(String nom) throws IllegalArgumentException {
		if (nom == null || nom.isBlank()) {
			throw new IllegalArgumentException("nom de pays invalide");
		}
		this.nom = nom;
		this.voisins = new TreeSet<>();
	}

	public Pays(String nom, String[] voisins) throws IllegalArgumentException {
		if (nom == null || nom.isBlank()) {
			throw new IllegalArgumentException("nom de pays invalide");
		}
		
		this.nom = nom;
		this.voisins = new TreeSet<>();
		
		for (String voisin : voisins) {
			if (voisin == null || voisin.isBlank()) {
				throw new IllegalArgumentException("nom de pays invalide");
			}
			this.voisins.add(voisin);
		}
	}
	
	public String toString() {
		return "nom pays : " + this.nom + "\n liste des voisins: " + this.voisins;
	}
	
	
	public void ajouterVoisin(String voisin)  {
		if (voisin == null || voisin.isBlank()) {
			throw new IllegalArgumentException("voisin invalide");
		}
		if (! this.voisins.contains(voisin)) {
			this.voisins.add(voisin);
		}
	}
	
	public boolean aPourVoisin(String voisin) throws IllegalArgumentException {
		if (voisin == null || voisin.isBlank()) {
			throw new IllegalArgumentException("voisin invalide");
		}
		return this.voisins.contains(voisin);
	}
	
	public int nombreVoisin() {
		return this.voisins.size();
	}

	
	public boolean aPourVoisin(ArrayList<String> listeATester) {
		boolean resultat;
		if (listeATester.size() != this.voisins.size()) {
			return false;
		}
		resultat = true;
		for (String voisin : voisins) {
			if (voisin == null || voisin.isBlank()) {
				throw new IllegalArgumentException("nom de pays invalide");
			}
			if (! listeATester.contains(voisin)) {
				resultat = false;
			}
		}
		return resultat;
		
	}


	public int nombreCommun(ArrayList<String> listeATester) {
		int resultat;
		
		resultat = 0;
		for (String voisin : voisins) {
			if (voisin == null || voisin.isBlank()) {
				throw new IllegalArgumentException("nom de pays invalide");
			}
			if (listeATester.contains(voisin)) {
				resultat++;
			}
		}
		return resultat;
	}

}
