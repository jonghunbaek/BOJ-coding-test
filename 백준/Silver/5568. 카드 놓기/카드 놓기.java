import java.util.HashSet;
import java.util.Scanner;

public class Main {

	static int N;
	static int k;
	static int[] n;
	static int[] arr;
	static boolean[] visit;
	static HashSet<String> ans = new HashSet<String>();
	
	public static void compare(int cnt) {
		
		String no = "";
		
		if (cnt == k) {
			for (int i=0; i<arr.length; i++) {
				no += arr[i];
			}
		
			ans.add(no);


		} else {
			for (int i=0; i<N; i++) {
				if (!visit[i]) {
					arr[cnt] = n[i];
					visit[i] = true;
					compare(cnt+1);
					visit[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		k = sc.nextInt();
		n = new int[N];
		arr = new int[k];
		visit = new boolean[N];
		
		for (int i=0; i<N; i++) {
			n[i] = sc.nextInt();
		}
		
		sc.close();
		compare(0);
		
		System.out.println(ans.size());
	}
}