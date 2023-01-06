import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> {
			int first = Math.abs(o1);
			int second = Math.abs(o2);
			if (first == second) {
				return o1 > o2 ? 1 : -1;
			} else {
				return first - second;
			}
		});
		
		while (N-- >= 1) {
			int temp = Integer.parseInt(br.readLine());
			
			if (temp == 0) {
				if (pq.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pq.poll());
				}
			} else {
				pq.add(temp);
			}
		}
	}
}