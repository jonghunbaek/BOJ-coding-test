import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] alphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		String inAlphabet = sc.next();
		
		sc.close();
		
		for (int i=0; i<alphabet.length; i++) {
			if (inAlphabet.contains(alphabet[i])) {
				inAlphabet = inAlphabet.replace(alphabet[i], ".");
			}
		}

		System.out.println(inAlphabet.length());
		
	}
}