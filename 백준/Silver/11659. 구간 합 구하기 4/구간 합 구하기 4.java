import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] numbers = new int[N+1];
		int[] sum = new int[N+1];
		int[][] section = new int[M][2];
		
		for (int i=1; i<=N; i++) {
			numbers[i] = sc.nextInt();
		}
		
		for (int i=0; i<M; i++) {
			for (int j=0; j<2; j++) {
				section[i][j] = sc.nextInt();
			}
		}
		
		for (int i=1; i<=N; i++) {
			sum[i] = sum[i-1] + numbers[i];
		}
		
		for (int i=0; i<M; i++) {
			System.out.println(sum[section[i][1]] - sum[section[i][0] - 1]);
		}
	}
}