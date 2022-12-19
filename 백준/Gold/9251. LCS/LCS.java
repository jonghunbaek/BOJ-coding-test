import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String n = sc.next();
		String k = sc.next();
		int[][] lcs = new int[n.length()+1][k.length()+1];
		
		for (int i=1; i<=n.length(); i++) {
			for (int j=1; j<=k.length(); j++) {
				if (n.charAt(i-1) == k.charAt(j-1)) {
					lcs[i][j] = lcs[i-1][j-1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		System.out.println(lcs[n.length()][k.length()]);
	}
}
