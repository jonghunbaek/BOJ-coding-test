import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> qu = new LinkedList<Integer>();
		boolean change = false;
		
		for (int i=1; i<=N; i++) {
			qu.add(i);
		}
		
		while (qu.size() != 1) {
			
			int temp = qu.poll();
			
			if (change) {
				qu.add(temp);
			}

			change = !change;
		}
		
		System.out.println(qu.poll());
	}
}