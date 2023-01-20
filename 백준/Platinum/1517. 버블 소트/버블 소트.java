import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long result;
	static int[] arr;
	static int[] temp;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		temp = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		mergeSort(1, N);
		
		System.out.println(result);
	}
	
	public static void mergeSort(int start, int end) {
		if (end-start<1) {
			return;
		}
		
		int mid = start + (end-start)/2;
		mergeSort(start, mid);
		mergeSort(mid+1, end);
		
		for (int i=start; i<=end; i++) {
			temp[i] = arr[i];
		}
		
		int k = start;
		int i = start;
		int j = mid + 1;
		while (i<=mid && j<=end) {
			if (temp[i] > temp[j]) {
				arr[k] = temp[j];
				result += j-k;
				k++;
				j++;
			} else {
				arr[k] = temp[i];
				k++;
				i++;
			}
		}
		
		while (i<=mid) {
			arr[k] = temp[i];
			k++;
			i++;
		}
		
		while (j<=end) {
			arr[k] = temp[j];
			k++;
			j++;
		}
	}
}