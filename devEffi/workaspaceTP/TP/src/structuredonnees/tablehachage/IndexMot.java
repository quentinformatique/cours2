package structuredonnees.tablehachage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class IndexMot {
	
	private HashMap<String, ArrayList<Integer>> index;
	
	public IndexMot() {
		this.index = new HashMap<>();
	}
	
	public boolean ajouterMot(String mot, Integer page) {
		boolean valide = false;
		if (!mot.isBlank() && page >= 0) {
			if (index.containsKey(mot)) {
				ArrayList<Integer> a = index.get(mot);
				if (!a.contains(page)) {
					a.add(page);
					index.put(mot, a);
					valide = true;
				} 
			} else {
				ArrayList<Integer> a = new ArrayList<>();
				a.add(page);
				index.put(mot, a);
				valide = true;
			}
		}
		return valide;
	}
	
	public ArrayList<Integer> getListeNumero(String mot) {
		return index.get(mot);
	}
	
	public ArrayList<String> getListeMot(int i) {
		ArrayList<String> mots = new ArrayList<>();
		Set<String> set = index.keySet();
		ArrayList<String> listeMot = (ArrayList<String>) set;
		for (int j = 0; j < listeMot.size(); j++) {
			// TODO finir
		}
	}
}

