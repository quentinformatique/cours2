package recursivite;

public class OutilEntierRecursif {
	
	public static int fibonnacci(int i) {
		if (i <= 1) {
			return 1;
		} 
		return fibonnacci(i - 1) + fibonnacci(i - 2);
	}
}
