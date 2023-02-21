import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		int[] arr = new int[1000001];
		for (int i=2; i<arr.length; i++) {
			arr[i] = i;
		}
		for (int i=2; i<Math.sqrt(arr.length); i++) {
			if (arr[i] == 0) {
				continue;
			}
			for (int j=i+i; j<arr.length; j+=i) {
				arr[j] = 0;
			}
		}
		boolean[] answer = new boolean[(int)(max-min+1)];
		for (long i=2; i<arr.length; i++) {
			if (i*i > max) {
				break;
			}
			if (arr[(int)i] == 0) {
				continue;
			}
			long square = i*i;
			long divVal = min/square;
			if (min%square != 0) {
				divVal++;
			}
			for (long j=divVal; j*square<=max; j++) {
				answer[(int)((j*square)-min)] = true;
			}
		}
		
		int cnt = 0;
		for (int i=0; i<answer.length; i++) {
			if (!answer[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}