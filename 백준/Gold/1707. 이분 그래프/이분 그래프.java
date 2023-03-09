import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int K,V,E;
	static List<Integer>[] nodes;
	static boolean[] visited;
	static boolean[] checkBinary;
	static boolean isBinary;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		for (int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			visited = new boolean[V+1];
			checkBinary = new boolean[V+1];
			nodes = new ArrayList[V+1];
			isBinary = true;
			
			for (int j=1; j<=V; j++) {
				nodes[j] = new ArrayList<Integer>();
			}
			for (int j=0; j<E; j++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				nodes[start].add(end);
				nodes[end].add(start);
			}

			for (int j=1; j<=V; j++) {
				if (!visited[j]) {
					dfs(j);					
				} else if (!isBinary) {
                    break;
                }
			}
			if (isBinary) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	
	public static void dfs(int node) {
		visited[node] = true;
		for (int next : nodes[node]) {
			if (!visited[next]) {
				checkBinary[next] = !checkBinary[node];
				dfs(next);
			} else {
				if (checkBinary[node] == checkBinary[next]) {
					isBinary = false;
				}
			}
		}
	}
}