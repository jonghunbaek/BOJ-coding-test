import java.util.Scanner;

public class Main {
	
	static int N;
	static int ans = Integer.MAX_VALUE;
	
	public static void constructor(int res, int M) {
		int temp = 0;
		int result = 0;
		
		if (M > N) {
			ans = 0;
			return;
		}
		
		if (res == N) {
			ans = M-1;
			return;
			
		} else if (res != N){
			temp = result = M;
			
			while (temp != 0) {
				result += temp%10;
				temp /= 10;
			}
			
			M++;
			constructor(result, M);
		} 
		/* 2,2 4,3 6,4 8,5 10,6 12,7 14,8 16,9 18,10 11,11 */
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sc.close();
		
		constructor(0, 1);
		
		System.out.println(ans);
	}
}