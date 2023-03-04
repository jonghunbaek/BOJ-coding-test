import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M,K,X;
	static int[] visited;
	static List<Integer>[] city;
	static List<Integer> result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		city = new ArrayList[N+1];
		result = new ArrayList<Integer>();
		visited = new int[N+1];
		for (int i=1; i<=N; i++) {
			city[i] = new ArrayList<Integer>();
		}
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			city[start].add(end);
		}
		for (int i=0; i<=N; i++) {
			visited[i] = -1;
		}
		bfs(X);
		for (int i=0; i<=N; i++) {
			if (visited[i] == K) {
				result.add(i);
			}
		}
		if (result.isEmpty()) {
			System.out.println(-1);
		}
		Collections.sort(result);
		for (Integer ans : result) {
			System.out.println(ans);				
		}
	}
	
	public static void bfs(int node) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(node);
		visited[node]++;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i=0; i<city[now].size(); i++) {
				if (visited[city[now].get(i)] == -1) {
					visited[city[now].get(i)] = visited[now] + 1;
					q.add(city[now].get(i));
				}
			}
		}
	}
}