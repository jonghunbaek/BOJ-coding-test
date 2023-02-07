import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		int max = 0;
		int cnt = 0;
		for (int i=0; i<N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
			if (max < coins[i] && coins[i] <= K) {
				max = coins[i];
			}
		}

		while (K > 0) {
			K = K - max;
			cnt++;
			
			if (K < max) {
				for (int i=N-1; i>=0; i--) {
					if (coins[i] <= K) {
						max = coins[i];
						break;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}