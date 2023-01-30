import java.util.*;
import java.io.*;

public class Main {

	static int V;
	static Map<Integer, Integer>[] tree;
	static boolean[] visited;
	static int max;
	static int maxNode;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		tree = new HashMap[V+1];
		visited = new boolean[V+1];
		
		for (int i=1; i<=V; i++) {
			tree[i] = new HashMap<Integer, Integer>();
		}
		
		for (int i=1; i<=V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			
			for (int j=0; j<V; j++) {
				int tempKey = Integer.parseInt(st.nextToken());
				if (tempKey == -1) {
					break;
				}
				int tempVal = Integer.parseInt(st.nextToken());
				tree[idx].put(tempKey, tempVal);
			}
		}
		
		int temp = dfs(2, 0);
		visited = new boolean[V+1];
		temp = dfs(maxNode, 0);
		
		System.out.println(max);
	}
	
	public static int dfs(int node, int distance) {
		visited[node] = true;
		if (max < distance) {
			max = distance;
			maxNode = node;
		} 
		Iterator<Integer> tempKey = tree[node].keySet().iterator();
		
		while (tempKey.hasNext()) {
			int temp = tempKey.next();
			if (!visited[temp]) {
				dfs(temp, distance + tree[node].get(temp));
			}
		}

		return node;
	}
}