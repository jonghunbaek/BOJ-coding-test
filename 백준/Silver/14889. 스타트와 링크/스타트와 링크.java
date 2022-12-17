import java.util.Scanner;

public class Main {

	public static int N;
	public static boolean check[];
	public static int status[][];
	public static int result = Integer.MAX_VALUE;
	
	public static void compare(int idx, int cnt) {
		
		int sum = 0;
		int startSum = 0;
		int linkSum = 0;

		
		if (cnt == N/2) {
			
			for (int i=0; i<N-1; i++) {
				for (int j=i+1; j<N; j++) {
					if (check[i] == true && check[j] == true) {
						startSum += status[i][j] + status[j][i];
					}
					else if (check[i] == false && check[j] == false) {
						linkSum += status[i][j] + status[j][i];
					}
				}
			}
			
			sum = Math.abs(startSum - linkSum);

			result = Math.min(result, sum);
			
		} else {
			
			for (int i=idx; i<N; i++) {
				if (!check[i]) {
					check[i] = true;
					compare(i+1, cnt+1);
					check[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		check = new boolean[N];
		status = new int[N][N];
				
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				status[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		compare(0, 0);
		
		System.out.println(result);
	}
}