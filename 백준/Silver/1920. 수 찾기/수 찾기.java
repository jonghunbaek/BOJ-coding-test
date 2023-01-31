import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[] arr;
	static int[] checkNum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		checkNum = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<M; i++) {
			checkNum[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i=0; i<M; i++) {
			binarySearch(checkNum[i], 0, N-1);
		}
	}
	
	public static void binarySearch(int checkNum, int start, int end) {
		int mid = start+(end-start)/2;
		
		if (checkNum == arr[mid]) {
			System.out.println(1);
			return;
		}
		if (end-start <= 0) {
			System.out.println(0);
			return;
		}
		if (checkNum < arr[mid]) {
			binarySearch(checkNum, start, mid-1);
		} else if (checkNum > arr[mid]){
			binarySearch(checkNum, mid+1, end);
		} 	
	}
}
