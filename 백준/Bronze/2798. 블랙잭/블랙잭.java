import java.util.Scanner;

public class Main {

	public static int N;
	public static int M;
	public static int arr[];
	public static int ans[];
	public static boolean check[];
	public static int result;
	
	public static void compare(int cnt) {
		int sum = 0;

		if (cnt == 3) {
			sum = ans[0] + ans[1] + ans[2];
			
			if (sum <= M) {
				result = Math.max(sum, result);
			} 
			
		} else {
			for (int i=0; i<N; i++) {
				if (!check[i]) {					
					ans[cnt] = arr[i];
					check[i] = true;
					compare(cnt + 1);
					check[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		ans = new int[N];
		check = new boolean[N];
		
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		compare(0);
		
		System.out.println(result);
	}
}