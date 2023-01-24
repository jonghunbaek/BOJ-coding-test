import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static boolean[] visited;
	static int[][] map;
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		map = new int[N+1][N+1];
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;
		}
		
		for (int i=1; i<=N; i++) {
			if (!visited[i]) {
				dfs(i);
				ans++;				
			}
		}
		
		System.out.println(ans);
	}
	
	public static void dfs(int start) {
		if (visited[start]) {
			return;
		}
		visited[start] = true;
		for (int i=1; i<=N; i++) {
			if (!visited[i] && map[start][i] == 1) {
				dfs(i);
			}
		}
	}
}
