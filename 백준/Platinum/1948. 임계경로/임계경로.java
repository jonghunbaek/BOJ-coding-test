import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static int[] indegree;
	static List<Node>[] nodes;
	static List<Node>[] reverseNodes;
	static int[]timeStack;
	static int cnt;
	
	static class Node {
		int target;
		int time;
		public Node (int target, int time) {
			this.target = target;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		indegree = new int[n+1];
		nodes = new ArrayList[n+1];
		reverseNodes = new ArrayList[n+1];
		timeStack = new int[n+1];
		for (int i=1; i<=n; i++) {
			nodes[i] = new ArrayList<Node>();
			reverseNodes[i] = new ArrayList<Node>();
		}
		
		StringTokenizer st;
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			nodes[start].add(new Node(end, time));
			reverseNodes[end].add(new Node(start, time));
			indegree[end]++;
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		topologicalSort(start, end);
		findCriticalPath(start, end);
		
		System.out.println(timeStack[end]);
		System.out.println(cnt);
	}
	
	public static void findCriticalPath(int start, int end) {
	    boolean[] visited = new boolean[n+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(end);
		visited[end] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (Node next : reverseNodes[now]) {
				if (timeStack[next.target] + next.time == timeStack[now]) {
					cnt++;
					if (!visited[next.target]) {
						visited[next.target] = true;
						q.add(next.target);
					}
				}
			}
		}
		
	}
	
	public static void topologicalSort(int start, int end) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for (Node next : nodes[now]) {
				indegree[next.target]--;
				timeStack[next.target] = Math.max(timeStack[next.target], next.time+timeStack[now]);
				if (indegree[next.target] == 0) {
					q.add(next.target);
				}
			}
		}
	}
}