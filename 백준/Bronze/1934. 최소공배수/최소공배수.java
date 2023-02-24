import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] numbers = new int[T][2];

		StringTokenizer st;
		for (int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if (A >= B) {
				numbers[i][0] = A;
				numbers[i][1] = B;
				continue;
			}
			numbers[i][0] = B;
			numbers[i][1] = A;
		}

		for (int i=0; i<T; i++) {
			int gcd = modSwap(numbers[i][0], numbers[i][1]);
			
			System.out.println((numbers[i][0]/gcd)*(numbers[i][1]/gcd)*gcd);
		}
	}
	
	public static int modSwap(int A, int B) {
		int mod = A%B;
		int temp = 0;

		while (mod != 0) {
			temp = mod;
			mod = B%temp;
			B = temp;
		}
		return B;
	}
}