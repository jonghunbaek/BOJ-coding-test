import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,A,B;
	static int[] dijkstra;
	static List<Node>[] nodes;
	static boolean[] visited;
	static int ans;
	
	static class Node implements Comparable<Node> {
		int node;
		int edge;
		public Node(int node, int edge) {
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
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dijkstra = new int[N+1];
		nodes = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i=1; i<=N; i++) {
			nodes[i] = new ArrayList<Node>();
		}
		
		StringTokenizer st;
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			nodes[start].add(new Node(end, val));
		}
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		Arrays.fill(dijkstra, Integer.MAX_VALUE);
		dijkstra[A] = 0;
		
		dijkstra();
		System.out.println(dijkstra[B]);
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(A, 0));
		
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (visited[now.node]) {
				continue;
			}
			visited[now.node] = true;
			for (Node next : nodes[now.node]) {
				if (dijkstra[next.node] > dijkstra[now.node] + next.edge) {
					dijkstra[next.node] = dijkstra[now.node] + next.edge;
					pq.add(new Node(next.node, dijkstra[next.node]));
				}
			}
		}
	}
}