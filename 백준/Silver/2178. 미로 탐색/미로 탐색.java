import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
	static int[] ax = {1,-1,0,0};
	static int[] ay = {0,0,1,-1};
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i=0; i<N; i++) {
			String temp = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}
		
		bfs(0,0);
		System.out.println(map[N-1][M-1]);
	}
	
	public static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(x, y));
		
		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp.x == N-1 && temp.y == M-1) {
				return;
			}
			for (int i=0; i<4; i++) {
				int nx = temp.x + ax[i];
				int ny = temp.y + ay[i];
				
				if (nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny] == 1) {
					q.add(new Node(nx, ny));
					map[nx][ny] += map[temp.x][temp.y];
				}
			}
		}
	}
	
	static class Node {
		private int x;
		private int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
}