import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static Edge[] edges;
	static long[] indegree;
	
	static class Edge {
		int start,end,val;
		
		public Edge(int start, int end, int val) {
			this.start = start;
			this.end = end;
			this.val = val;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edges = new Edge[M];
		indegree = new long[N+1];
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(start, end, val);
		}
		Arrays.fill(indegree, Integer.MAX_VALUE);
		indegree[1] = 0;
		
		bellmanFord();
		boolean check = checkCycle();
		
		if (check) {
			System.out.println(-1);
		} else {
			for (int i=2; i<=N; i++) {
				if (indegree[i] == Integer.MAX_VALUE) {
					System.out.println(-1);
				} else {
					System.out.println(indegree[i]);
				}
			}
		}
	}
	
	public static void bellmanFord() {
		for (int i=0; i<N-1; i++) {
			for (int j=0; j<M; j++) {
				Edge now = edges[j];
				if (indegree[now.start] != Integer.MAX_VALUE && indegree[now.start] + now.val < indegree[now.end]) {
					indegree[now.end] = indegree[now.start] + now.val;
				}
			}
		}
	}
	
	public static boolean checkCycle() {
		boolean check = false;
		for (int i=0; i<M; i++) {
			Edge now = edges[i];
			if (indegree[now.start] != Integer.MAX_VALUE && indegree[now.start] + now.val < indegree[now.end]) {
				check = true;
			}
		}
		return check;
	}
}
