package structuredonnees.ensemble;

import java.util.TreeSet;
import java.util.ArrayList;

public class Pays {
	
	private String nom;
	
	private TreeSet<String> voisins;

	public Pays(String nom) {
		if (nom == null || nom.isBlank()) {
			throw new IllegalArgumentException("nom de pays invalide");
		}
		this.nom = nom;
		this.voisins = new TreeSet<>();
	}

	public Pays(String nom, String[] voisins) {
		if (nom == null || nom.isBlank()) {
			throw new IllegalArgumentException("nom de pays invalide");
		}
		
		this.nom = nom;
		this.voisins = new TreeSet<>();
		
		for (String voisin : voisins) {
			if (nom == null || nom.isBlank()) {
				throw new IllegalArgumentException("nom de pays invalide");
			}
			this.voisins.add(voisin);
		}
	}
	
	public String toString() {
		return "nom pays : " + this.nom + "\n liste des voisins: " + this.voisins;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void ajouterVoisin(String voisin) {
		this.voisins.add(voisin);
	}

	public boolean aPourVoisin(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public String nombreVoisin() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean aPourVoisin(ArrayList<String> listeATester) {
		// TODO Auto-generated method stub
		return false;
	}

	public int nombreCommun(ArrayList<String> listeATester) {
		// TODO Auto-generated method stub
		return 0;
	}

}
