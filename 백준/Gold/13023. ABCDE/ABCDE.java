import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static List<Integer>[] adjacencyList;
	static boolean[] visited;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjacencyList = new ArrayList[N];
		visited = new boolean[N];
		
		for (int i=0; i<N; i++) {
			adjacencyList[i] = new ArrayList<Integer>();
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjacencyList[a].add(b);
			adjacencyList[b].add(a);
		}
		
		for (int i=0; i<N; i++) {
			dfs(i, 0);
			if (ans == 1) {
				break;
			}
		}
		
		System.out.println(ans);
	}
	
	public static void dfs(int node, int depth) {
		if (depth == 4 || ans == 1) {
			ans = 1;
			return;
		}
		
		visited[node] = true;
		for (int i=0; i<adjacencyList[node].size(); i++) {
			if (!visited[adjacencyList[node].get(i)]) {
				
				dfs(adjacencyList[node].get(i), depth + 1);
			}
		}
		visited[node] = false;
	}
}