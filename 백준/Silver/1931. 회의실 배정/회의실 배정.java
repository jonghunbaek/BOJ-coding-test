import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static Convention[] conventions;
	static int cnt;
	
	static class Convention implements Comparable<Convention> {
		long start;
		long end;

		public Convention(long start, long end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Convention o) {
			if (this.end == o.end) {
				return (int)(this.start - o.start);
			}
			return (int)(this.end - o.end);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		conventions = new Convention[N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int gap = end - start;
			conventions[i] = new Convention(start, end);
		}
		Arrays.sort(conventions);
		
		long end = -1;
		for (int i=0; i<N; i++) {
			if (conventions[i].start >= end) {
				end = conventions[i].end;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}