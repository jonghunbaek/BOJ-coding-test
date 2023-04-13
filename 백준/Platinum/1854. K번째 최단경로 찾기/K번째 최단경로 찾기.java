import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n,m,k;
	static List<Node>[] nodes;
	static PriorityQueue<Integer>[] dijkstra;
	
	static class Node implements Comparable<Node>{
		int node;
		int val;
		public Node(int node, int val) {
			this.node = node;
			this.val = val;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.val - o.val;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		nodes = new ArrayList[n+1];
		dijkstra = new PriorityQueue[n+1];
		for (int i=1; i<=n; i++) {
			nodes[i] = new ArrayList<Node>();
			dijkstra[i] = new PriorityQueue<Integer>(Collections.reverseOrder());
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			nodes[start].add(new Node(end, val));
		}
		
		dijkstra();
		for (int i=1; i<=n; i++) {
			if (dijkstra[i].size() == k) {
				System.out.println(dijkstra[i].peek());
			} else {
				System.out.println(-1);
			}
		}
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(1, 0));
		dijkstra[1].add(0);
		
		while (!pq.isEmpty()) {
			Node now = pq.poll();

			for (Node next : nodes[now.node]) {
				if (dijkstra[next.node].size() < k) {
					dijkstra[next.node].add(now.val+next.val);
					pq.add(new Node(next.node, now.val+next.val));
				} else if (dijkstra[next.node].peek() > now.val+next.val) {
					dijkstra[next.node].poll();
					dijkstra[next.node].add(now.val+next.val);
					pq.add(new Node(next.node, now.val+next.val));
				}
			}
		}
	}
}
