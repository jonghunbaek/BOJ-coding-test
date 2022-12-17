import java.util.Scanner;

public class Main {

	static int n,m;
	static int[][] map;
	static int[][] dp;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n+1][m+1];
		dp = new int[n+1][m+1];

		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				int temp = Math.max(dp[i-1][j], dp[i][j-1]);
				temp = Math.max(temp, dp[i-1][j-1]);
				dp[i][j] = temp+map[i][j];
			}
		}
		System.out.println(dp[n][m]);
	}
}