import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long[] arr = new long[(int) Math.sqrt(B)+1];
		List<Long> list = new ArrayList<Long>();
		for (int i=1; i<arr.length; i++) {
			arr[i] = i;
		}
		for (int i=2; i<=Math.sqrt(B); i++) {
			if (arr[i] == 0) {
				continue;
			}
			for (int j=i+i; j<arr.length; j+=i) {
				arr[j] = 0;
			}
		}
		
		for (int i=2; i<arr.length; i++) {
			long temp = 0;
			if (arr[i] != 0) {
				temp = arr[i];
				while (arr[i] <= B/temp) {
					temp *= arr[i];						
					if (temp >= A) {
						list.add(temp);					
					} 
					if (temp > B) {
						break;
					}
				}
			}
		}
		System.out.println(list.size());
	}
}