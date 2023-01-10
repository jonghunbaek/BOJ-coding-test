import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N];
		int sum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<P.length; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=1; i<N; i++) {
			for (int j=0; j<i; j++) {
				if (P[i] < P[j]) {
					int temp = P[i];
					
					for (int k=i-1; k>=j; k--) {
						P[k+1] = P[k];
					}
					
					P[j] = temp;
					break;
				}
			}
		}
		
		for (int i=1; i<N; i++) {
			P[i] = P[i] + P[i-1];
			sum += P[i];
		}
		
		System.out.println(sum + P[0]);
	}
}