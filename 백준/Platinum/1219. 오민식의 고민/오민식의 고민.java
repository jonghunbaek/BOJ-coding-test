import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,M,start,end;
	static long[] money;
	static int[] getMoney;
	static Edge[] edges;
	
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
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		money = new long[N];
		getMoney = new int[N];
		edges = new Edge[M];
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(start, end, cost);
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			getMoney[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.fill(money, Long.MIN_VALUE);
		money[start] = getMoney[start];
		
		bellmanFord();
		if (money[end] == Long.MIN_VALUE) {
			System.out.println("gg");
			return;
		}
		if (money[end] == Long.MAX_VALUE) {
			System.out.println("Gee");
			return;
		}
		System.out.println(money[end]);
		
	}
	
	public static void bellmanFord() {
		for (int i=0; i<=N+50; i++) {
			for (int j=0; j<M; j++) {
				Edge edge = edges[j];
				if (money[edge.start] == Long.MIN_VALUE) {
					continue;
				}
				if (money[edge.start] == Long.MAX_VALUE) {
					money[edge.end] = Long.MAX_VALUE;
					continue;
				}
				if (money[edge.end] < money[edge.start] + getMoney[edge.end] - edge.val) {
					money[edge.end] = money[edge.start] + getMoney[edge.end] - edge.val;
					if (i >= N-1) {
						money[edge.end] = Long.MAX_VALUE; 
					}
				}
			}
		}
	}
}