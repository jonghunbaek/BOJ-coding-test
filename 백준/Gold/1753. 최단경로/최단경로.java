import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int V,E,start;
	static int[] shortest;
	static List<Node>[] nodes;
	static boolean[] visited;
	
	static class Node implements Comparable<Node> {
		int node;
		int edge;
		public Node (int node, int edge) {
			this.node = node;
			this.edge = edge;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.edge - o.edge;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		shortest = new int[V+1];
		nodes = new ArrayList[V+1];
		
		Arrays.fill(shortest, 10000000);
		shortest[start] = 0;
		for (int i=1; i<=V; i++) {
			nodes[i] = new ArrayList<Node>();
		}
		for (int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			nodes[u].add(new Node(v, w));
		}
		
		dijkstra();
		for (int i=1; i<=V; i++) {
			if (i == start) {
				System.out.println(0);
				continue;
			}
			if (!visited[i]) {
				System.out.println("INF");
				continue;
			}
			System.out.println(shortest[i]);
		}
	}
	
	public static void dijkstra() {
		visited = new boolean[V+1];
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.add(new Node(start, 0));
		//visited[start] = true;
		
		while (!q.isEmpty()) {
			Node now = q.poll();
			if (visited[now.node]) {
				continue;
			}
			visited[now.node] = true;
			for (Node next : nodes[now.node]) {
				/*if (!visited[next.node]) {*/
					shortest[next.node] = Math.min(shortest[next.node], shortest[now.node] + next.edge);
					q.add(new Node(next.node, shortest[next.node]));	
					//visited[next.node] = true;
				//}
			}
		}
	}
}
