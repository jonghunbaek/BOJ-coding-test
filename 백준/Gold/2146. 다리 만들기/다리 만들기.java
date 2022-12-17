import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int groupNo = 2;
	static int[] ax = {1,-1,0,0};
	static int[] ay = {0,0,1,-1};
	static int min = Integer.MAX_VALUE;
	
	public static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(x,y,0));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			
			for (int i=0; i<4; i++) {
				int nx = temp.x + ax[i];
				int ny = temp.y + ay[i];
				
				if (nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny]) {
					
					if (map[x][y] != map[nx][ny] && map[nx][ny] != 0) {
						min = Math.min(min, temp.dist);
						return;
					} else if (map[nx][ny] == 0) {
						visited[nx][ny] = true;
						q.add(new Node(nx, ny, temp.dist+1));
					}
				}
			}
		}
		
	}
	
	public static void grouping(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(x, y, 0));
		visited[x][y] = true;
		map[x][y] = groupNo;
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			
			for (int i=0; i<4; i++) {
				int nx = temp.x + ax[i];
				int ny = temp.y + ay[i];
				
				if (nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny] && map[nx][ny] != 0) {
					visited[nx][ny] = true;
					map[nx][ny] = groupNo;
					q.add(new Node(nx, ny, 0));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		visited = new boolean[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					grouping(i,j);
					groupNo++;
				}
			}
		}
		
		visited = new boolean[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					bfs(i, j);
					visited = new boolean[N][N];
				}
			}
		}
		
		System.out.println(min);
		
	}
	
	private static class Node{
		int x,y,dist;
		
		public Node(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
}