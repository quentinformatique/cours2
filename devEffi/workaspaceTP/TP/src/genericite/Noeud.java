package genericite;

public class Noeud<E extends Comparable<E>> {
	
	private E valeur;

	private Noeud<E> filsGauche;
	
	private Noeud<E> filsDroit;
	
	public Noeud(E valeur) {
		this.valeur = valeur;
		filsDroit = null;
		filsDroit = null;
	}
	
	public boolean estPresente(E valeur) {
		if (this.valeur.equals(valeur)) {
			return true;
		} else if (filsDroit!= null && valeur.compareTo(filsDroit.valeur) < 0) {
			return filsDroit.estPresente(valeur); 
		} else if (filsGauche!= null && valeur.compareTo(filsGauche.valeur) < 0) {
			return filsGauche.estPresente(valeur); 
		}
		return false;
	}
	


}
