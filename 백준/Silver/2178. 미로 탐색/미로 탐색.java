import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N,M;
	static int[][] maze;
	static boolean[][] visited;
	static int[] axisX = {1,-1,0,0};
	static int[] axisY = {0,0,1,-1};
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int noX = now[0];
			int noY = now[1];
			
			for (int i=0; i<4; i++) {
				int neX = noX + axisX[i];
				int neY = noY + axisY[i];
				
				if (neX<0 || neY<0 || neX>=N || neY>=M) {
					continue;
				} 
				if (visited[neX][neY] || maze[neX][neY] == 0) {
					continue;
				} 
				
				q.add(new int[] {neX, neY});
				maze[neX][neY] = maze[noX][noY] + 1;
				visited[neX][neY] = true;
				
			}
		}
		
	}
 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		maze = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i=0; i<N; i++) {
			String temp = sc.next();
			for (int j=0; j<M; j++) {
				maze[i][j] = temp.charAt(j)-'0';
			}
		}
		
		sc.close();
		
		visited[0][0] = true;
		bfs(0, 0);
	
		System.out.println(maze[N-1][M-1]);
	}
}