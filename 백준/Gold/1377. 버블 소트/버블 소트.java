import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static Pair[] arr;
	
	static class Pair implements Comparable<Pair>{
		private int val;
		private int idx;
		
		public Pair(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}
		
		public int compareTo(Pair p) {
			return this.val - p.val;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new Pair[N];
		
		for (int i=0; i<N; i++) {
			arr[i] = new Pair(Integer.parseInt(br.readLine()), i);
		}
		
		Arrays.sort(arr);
		int max = 0;
		for (int i=0; i<N; i++) {
			if (max < arr[i].idx - i) {
				max = arr[i].idx - i;
			}
		}

		System.out.println(max + 1);
	}
}