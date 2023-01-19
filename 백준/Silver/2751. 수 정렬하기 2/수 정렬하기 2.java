import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static int N;
	static int[] arr;
	static int[] temp;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		temp = new int[N+1];
		for (int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(1, N);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i=1; i<=N; i++) {
			bw.write(arr[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void mergeSort(int start, int end) {
		if (end-start < 1) {
			return;
		}
		int mid = start + (end - start)/2;
		mergeSort(start, mid);
		mergeSort(mid + 1, end);
		
		// 합병할 구간의 arr배열을 temp에 복사
		for (int i=start; i<=end; i++) {
			temp[i] = arr[i];
		}
		
		int i = start;
		int j = mid + 1;
		int k = start;
		while (i <= mid && j <= end) {
			if (temp[i] > temp[j]) {
				arr[k] = temp[j];
				k++;
				j++;
			} else {
				arr[k] = temp[i];
				k++;
				i++;
			}
		}
		while (i <= mid) {
			arr[k] = temp[i];
			k++;
			i++;
		}
		
		while (j <= end) {
			arr[k] = temp[j];
			k++;
			j++;
		}
	}
}