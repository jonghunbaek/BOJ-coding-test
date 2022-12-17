import java.util.Scanner;

public class Main {

	static int n;
	static int k;
	static int[] coins;
	static boolean[] visited;
	static int[] dp;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		coins = new int[n];
		visited = new boolean[n];
		dp = new int[k+1];
		
		for (int i=0; i<coins.length; i++) {
			coins[i] = sc.nextInt();
		}
		
		dp[0] = 1;
		for (int i=0; i<n; i++) {
			for (int j=1; j<k+1; j++) {
				if (j>=coins[i]) {
					dp[j] = dp[j] + dp[j-coins[i]];
				}
			}
		}
		
		System.out.println(dp[k]);
	}
}