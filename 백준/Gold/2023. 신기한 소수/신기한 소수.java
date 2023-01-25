import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] primeNums = {2,3,5,7};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i=0; i<primeNums.length; i++) {
			StringBuilder sb = new StringBuilder();
			dfs(sb.append(primeNums[i]));
		}
	}
	
	public static void dfs(StringBuilder num) {
		if (num.length() == N) {
			System.out.println(num);
			return;
		}

		for (int i=1; i<10; i++) {
			int temp = Integer.parseInt(num.append(i).toString());
			boolean isPrime = true;
			
			for (int j=2; j<temp; j++) {
				if (temp%j == 0) {
					isPrime = false;
					break;
				}
			}
			
			if (isPrime) {
				dfs(num);
			}
			num.deleteCharAt(num.length()-1);
		}
	}
}