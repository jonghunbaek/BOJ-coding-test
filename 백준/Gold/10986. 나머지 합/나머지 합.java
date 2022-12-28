import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] sum = new long[N];
		long[] dp = new long[M];
		long total = 0;
		
		sum[0] = sc.nextInt();
		for (int i=1; i<N; i++) {
			sum[i] = sum[i-1] + sc.nextInt();
		}
		
		for (int i=0; i<N; i++) {
			int temp = (int)(sum[i] % M);
			
			if (temp == 0) {
				total++;
			}
			dp[temp]++;
		}
		
		for (int i=0; i<M; i++) {
			total = total + (dp[i]*(dp[i]-1))/2;
		}
		
		System.out.println(total);
	}
}
