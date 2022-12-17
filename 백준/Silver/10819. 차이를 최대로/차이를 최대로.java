import java.util.Scanner;

public class Main {
	
	public static int N;
	public static int[] A;
	public static int[] B;
	public static boolean[] check;
	public static int answer;
	
	public static void compare(int n) {

		int sum = 0;
		
		if (n==N) {
			for (int i=0; i<N-1; i++) {
				sum += Math.abs(B[i]-B[i+1]);
			}
			answer = Math.max(answer, sum);
			
		} else {
			for (int i=0; i<N; i++) {
				if (!check[i]) {	
					B[n] = A[i];
					check[i] = true;
					compare(n+1);
					check[i] = false;
				}
			}
		}	
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		A = new int[N];
		B = new int[N];
		check = new boolean[N];
		
		for (int i=0; i<A.length; i++) {
			A[i] = sc.nextInt();
		}	
		
		sc.close();
		compare(0);	
		
		System.out.println(answer);
	}
}