import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static boolean[][] arr;
	static boolean[] visit;
	static int[] ans;
	static int sum;
	
	public static void compare(int idx, int cnt) {
		
		int count = 0;
		
		if (cnt == 3) {
	
			for (int i=0; i<3; i++) {
				for (int j=i+1; j<3; j++) {
					if (arr[ans[i]][ans[j]]) {
						return;
					}
				}
			}
			
			count++;
			sum += count;

		} else {
			for (int i=idx; i<N; i++) {
				if (!visit[i]) {
					ans[cnt] = i+1;
					visit[i] = true;
					compare(i+1, cnt+1);
					visit[i] = false;
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new boolean[N+1][N+1];
		visit = new boolean[N];
		ans = new int[3];
		
		for (int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a][b] = arr[b][a] = true;
		}
		
		sc.close();
		
		compare(0, 0);
		
		System.out.println(sum);
	}

}