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

	static int N,M,V;
	static List<Integer>[] arr;
	static List<Integer> dfsList = new ArrayList<Integer>();
	static List<Integer> bfsList = new ArrayList<Integer>();
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N];
		visited = new boolean[N];
		
		for (int i=0; i<N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a-1].add(b-1);
			arr[b-1].add(a-1);
		}
		
		for (int i=0; i<N; i++) {
			Collections.sort(arr[i]);
		}
		dfs(V-1);
		visited = new boolean[N];
		bfs(V-1);
		
		for (int i=0; i<dfsList.size(); i++) {
			System.out.print(dfsList.get(i)+1 + " ");
		}
		System.out.println();
		for (int i=0; i<bfsList.size(); i++) {
			System.out.print(bfsList.get(i)+1 + " ");
		}
	}
	
	public static void dfs(int node) {
		dfsList.add(node);
		visited[node] = true;
		for (int i=0; i<arr[node].size(); i++) {
			if (!visited[arr[node].get(i)]) {
				dfs(arr[node].get(i));
			}
		}
	}
	
	public static void bfs(int node) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(node);
		
		while (!q.isEmpty()) {
			int temp = q.poll();
			visited[temp] = true;
			bfsList.add(temp);
			
			for (int i=0; i<arr[temp].size(); i++) {
				if (!visited[arr[temp].get(i)]) {
					visited[arr[temp].get(i)] = true;
					q.add(arr[temp].get(i));
				}
			}
		}
	}
}