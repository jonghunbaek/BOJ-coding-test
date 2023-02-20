import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1004000];
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
		
		StringBuilder sb = new StringBuilder();
		for (int i=N; i<arr.length; i++) {
			sb.setLength(0);
			if (arr[i] != 0) {
				int temp = arr[i];
				while (temp != 0) {
					sb.append(temp%10);
					temp /= 10;
				}		
				if (Integer.parseInt(sb.toString()) == arr[i]) {
					System.out.println(sb.toString());
					return;
				} 
			}
		}
	}
}