import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] cnt = new int[T];

		for (int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			for (int j=0; j<N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int max = 0;
				for (int k=0; k<3; k++) {
					int temp = Integer.parseInt(st.nextToken());
					if (temp < 0) {
						continue;
					}
					
					if (max < temp) {
						max = temp;
					}
				}
				cnt[i] += max;
			}
		}
		
		for (int i=0; i<T; i++) {
			System.out.println(cnt[i]);
		}
	}
}
