import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n,m;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		for (int i=0; i<arr.length; i++) {
			arr[i] = i;
		}
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int calculation = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (calculation == 0) {
				union(a, b);
				continue;
			}
			
			a = find(a);
			b = find(b);
			if (a == b) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
	
	public static void union(int a, int b) {
		int first = find(a);
		int second = find(b);
		if (first != second) {
			arr[second] = first; 
		}
	}
	
	public static int find(int element) {
		if (arr[element] == element) {
			return element;
		} else {
			return arr[element] = find(arr[element]);
		}
	}
}