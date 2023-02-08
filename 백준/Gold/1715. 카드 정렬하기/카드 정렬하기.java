import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	static int N;
	static int[] cards;
	static PriorityQueue<Long> pq;
	static long sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cards = new int[N];
		pq = new PriorityQueue<Long>();
		for (int i=0; i<N; i++) {
			pq.add(Long.parseLong(br.readLine()));
		}
		
		while (pq.size() > 1) {
			long temp =  pq.poll() + pq.poll();
			sum += temp;
			pq.add(temp);
		}
		System.out.println(sum);
	}
}
