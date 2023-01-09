import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int[] arr = new int[N.length()];
		
		for (int i=0; i<N.length(); i++) {
			arr[i] = N.charAt(i)-'0';
		}
		
		for (int i=0; i<arr.length; i++) {
			int max = 0;
			int idx = 0;
			for (int j=i; j<arr.length; j++) {
				if (arr[j] > max) {
					max = arr[j];
					idx = j;
				}
			}
			arr[idx] = arr[i];
			arr[i] = max;
            System.out.print(arr[i]);
		}
	}
}