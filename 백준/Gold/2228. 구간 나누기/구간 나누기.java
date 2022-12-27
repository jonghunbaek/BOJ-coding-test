import java.util.Scanner;

public class Main {

	static int N,M;
	static int[] arr;
	static int[] sum;
	static int[][] dp;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1];
		sum = new int[N+1];
		dp = new int[M+1][N+1];
		
		for (int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
		}
		
		sum[1] = arr[1];
		for (int i=2; i<=N; i++) {
			sum[i] = sum[i-1] + arr[i];
		}
		
		for (int i=1; i<=M; i++) {
			for (int j=0; j<=N; j++) {
				dp[i][j] = Integer.MIN_VALUE/2;
			}
		}

		dp[1][1] = arr[1];
		for (int i=1; i<=M; i++) {
			for (int j=2; j<=N; j++) {
				dp[i][j] = dp[i][j-1];
				
				int min = 0;
				if (i == 1) {
					min = -1;
				}
				for (int k=j-2; k>=min; k--) {
					if (k < 0) {
						dp[i][j] = Math.max(dp[i][j], sum[j]);
					} else {
						dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + (sum[j] - sum[k+1]));
					}
				}
			}
		}
		
		System.out.println(dp[M][N]);
	}
}
