import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		
		for (int i=2; i<N+1; i++) {
			arr[i] = i;
		}
	
		for (int i=2; i<=Math.sqrt(N); i++) {
			if (arr[i] == 0) {
				continue;
			}
			for (int j=i+1; j<N+1; j++) {
				if (arr[j]%arr[i] == 0) {
					arr[j] = 0;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i=M; i<arr.length; i++) {
			if (arr[i] != 0) {
				sb.append(arr[i] + "\n");
			}
		}
		
		System.out.println(sb);
	}
}