import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	static int N; 
	static PriorityQueue<Integer> plusPq;
	static PriorityQueue<Integer> minusPq;
	static int sum;
	static int zero = 0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		plusPq = new PriorityQueue<Integer>(Collections.reverseOrder());
		minusPq = new PriorityQueue<Integer>();
		
		for (int i=0; i<N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (temp >= 1) {
				plusPq.add(temp);
				continue;
			} 
			if (temp < 0) {
				minusPq.add(temp);
				continue;
			}
			zero++;
		}
		
		findMaxSum(plusPq);
		findMaxSum(minusPq);
		System.out.println(sum);
	}
	
	public static void findMaxSum(PriorityQueue<Integer> pq) {
		while (pq.size() > 1) {
			int first = pq.poll();
			int second = pq.poll();
			if (first == 1 || second == 1) {
				sum += first + second;
				continue;
			}
			sum += first * second;
		}
		if (!pq.isEmpty()) {
			if (zero > 0 && pq.peek() < 0) {
				sum += pq.poll() * 0;
				zero--;
				return;
			}
			sum += pq.poll();
			return;
		}
	}
}