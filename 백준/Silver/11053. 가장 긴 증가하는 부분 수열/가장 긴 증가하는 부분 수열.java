import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int[] sequence = new int[A];
		int[] dp = new int[A+1];
		int max = 0;
		
		for (int i=0; i<A; i++) {
			sequence[i] = sc.nextInt();
		}
		
		for (int i=0; i<A; i++) {
			dp[i] = 1;
			for (int j=0; j<A; j++) {
				if (sequence[i] > sequence[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		for (int i=0; i<A; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}