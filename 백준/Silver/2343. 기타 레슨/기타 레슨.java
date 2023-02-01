import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[] courses;
	static int start;
	static int end;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		courses = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			courses[i] = Integer.parseInt(st.nextToken());
		}
		for (int i=0; i<N; i++) {
			if (start < courses[i]) {
				start = courses[i];
			}
			end += courses[i];
		}
		while (start <= end) {
			int mid = (start+end)/2;
			int sum = 0;
			int count = 0;
			for (int i=0; i<N; i++) {
				if (sum + courses[i] > mid) {
					count++;
					sum = 0;
				}
				sum += courses[i];
			}
			if (sum != 0) {
				count++;
			}
			if (count > M) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}	
		System.out.println(start);	
	}
}
