import java.io.*;
import java.util.*;

public class Main {
	static int N,k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		long start = 1;
		long end = k;
		long res = 0;
		while (start <= end) {
			long mid = (start+end)/2;
			long cnt = 0;
			for (int i=1; i<=N; i++) {
				cnt += Math.min(mid/i, N);
			}
			if (cnt < k) {
				start = mid + 1;
				continue;
			} 
			res = mid;
			end = mid - 1;
		}
		System.out.println(start);
	}
}