import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] structures;
	// 건설에 걸리는 시간
	static int[] time;
	// 건설에 걸리는 누적 시간
	static int[] result;
	static List<Integer>[] nodes;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		structures = new int[N+1];
		time = new int[N+1];
		result = new int[N+1];
		nodes = new ArrayList[N+1];
		for (int i=1; i<N+1; i++) {
			nodes[i] = new ArrayList<Integer>();
		}
		StringTokenizer st;
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			// i번째 건물을 짓는데 걸리는 시간
			time[i] = Integer.parseInt(st.nextToken());
			result[i] = time[i];
			int pre = Integer.parseInt(st.nextToken());
			while (pre != -1) {
				nodes[pre].add(i);
				structures[i]++;
				pre = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i=1; i<=N; i++) {
			if (structures[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int temp = q.poll();
			int max = 0;
			for (int node : nodes[temp]) {
				structures[node]--;
				result[node] = Math.max(time[node] + result[temp], result[node]);
				if (structures[node] == 0) {
					q.offer(node);
				}
			}
		}
		for (int i=1; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}
}