import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int [N];
		boolean[] visited = new boolean[N];
		
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int cnt = 0;
		
		for (int i = 0; i<N; i++) {
			int si = 0;
			int ei = N-1;
			while (si < ei) {
				if (arr[si] + arr[ei] == arr[i]) {
					if (si != i && ei != i) {
						cnt++;
						break;
					} else if (si == i) {
						si++;
					} else {
						ei--;
					}
					
				} else if (arr[si] + arr[ei] < arr[i]) {
					si++;
				} else {
					ei--;
				}
			}
			
		}
		
		System.out.println(cnt);
	}
}