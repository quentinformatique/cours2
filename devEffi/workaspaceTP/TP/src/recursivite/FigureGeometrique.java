package recursivite;

public class FigureGeometrique {
	public static void etoile(int n) {
		if (n < 1) {
			System.out.print("\n");
		} else {
			System.out.print("*");
			etoile(n - 1);
		}
	}
	
	public static void piramide(int n) {
		 if (n > 0) {
			 piramide(n-1);
			 etoile(n);
			 
		 }
	}
	
	public static void triangle(int n) {
		 if (n > 0) {
			 for (int i = 0; i <= n-1; i++) {
				System.out.print(" ");
			 }
			 for (int i = 0; i < n; i++) {
					System.out.print("");
			 }
			 
		 }
	}
	
	public static void main(String[] args) {
		piramide(50);
	}
}
