import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		int startIndex = 0;
		int endIndex = 1;
		int cnt = 0;
		
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		while (startIndex != N-2) {
			if (arr[startIndex]+arr[endIndex] == M) {
				cnt++;
				startIndex++;
				endIndex = startIndex + 1;
			} else if (endIndex == N-1){
				startIndex++;
				endIndex = startIndex + 1;
			} else {
				endIndex++;
			}
		}
		
		System.out.println(cnt);
	}
}