import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = i;
		}
		
		StringTokenizer st;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					union(i, j);
				}
			}
		}
		
		String[] schedule = br.readLine().split(" ");
		result = new int[schedule.length];
		for (int i=0; i<schedule.length; i++) {
			result[i] = find(arr[Integer.parseInt(schedule[i])-1]);
		}
		int pre = result[0];
		for (int i=1; i<result.length; i++) {
			if (pre != result[i]) {
				System.out.println("NO");
				System.exit(0);
			}
			pre = result[i];
		}
		System.out.println("YES");
	}
	
	public static void union(int i, int j) {
		int first = find(i);
		int second = find(j);
		if (first != second) {
			arr[second] = first; 
		}
	}
	
	public static int find(int node) {
		if (arr[node] != node) {
			return arr[node] = find(arr[node]);
		} else {
			return node;
		}
	}
}