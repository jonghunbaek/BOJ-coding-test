import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		int sum = 0;
		int m = 1;
		
        if (N == 1) {
			System.out.println(1);
			return;
		}
        
		for (int i=m; i<=N; i++) {
			sum += i;
			if (sum > N) {
				m++;
				i = m;
				sum = i;
				continue;
			}
			
			if (sum == N) {
				cnt++;
				m++;
				i = m;
				sum = i;
			}
			
		}
		System.out.println(cnt+1);
	}
}