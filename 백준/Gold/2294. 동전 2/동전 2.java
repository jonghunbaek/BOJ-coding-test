import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coins = new int[n];
		int[] dp = new int[k+1];
		
		for (int i=0; i<n; i++) {
			coins[i] = sc.nextInt();
		}
		
		for (int i=1; i<=k; i++) {
			dp[i] = Integer.MAX_VALUE-1;
		}
		
		for (int i=0; i<n; i++) {
			for (int j=coins[i]; j<=k; j++) {
				if (coins[i] <= j) {
					dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
				}
			}
		}
		
		if (dp[k] != Integer.MAX_VALUE-1) {
			System.out.println(dp[k]);	
		} else {
			System.out.println("-1");
		}
	}
}