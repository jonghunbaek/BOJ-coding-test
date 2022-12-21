import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int n,k;
	static int[][] backpack;
	static int[] dp;
	static int[] temp;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		backpack = new int[n][2];
		dp = new int[k+1];
		temp = new int[k+1];
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<2; j++) {
				backpack[i][j] = sc.nextInt();
			}
		}
		
		for (int i=1; i<=k; i++) {
			for (int j=0; j<4; j++) {
				if (backpack[j][0] <= i) {
					temp[i] = Math.max(backpack[j][1], temp[i]); 
				}
			}
			System.out.print(temp[i] + " ");
		}
		System.out.println();

		for (int i=1; i<=k; i++) {
			for (int j=0; j<=i/2; j++) {
				if (i-j != j) {
					dp[i] = Math.max(temp[i-j] + temp[j], dp[i]);	

				}
			}
			System.out.print(dp[i] + " ");
		}
		System.out.println();

		Arrays.sort(dp);
		System.out.println(dp[k]);
	}
}
