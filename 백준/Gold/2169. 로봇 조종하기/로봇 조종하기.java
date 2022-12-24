import java.io.*;
import java.util.*;
public class Main {
	public static int N,M;
	public static int board[][];
	public static int dp[][][];
	public static int dir[][] = {{0,1},{1,0},{0,-1}};
	public static boolean visited[][];
	
	public static boolean isBoundry(int y,int x){
		if(y<1 || x<1 || y > N || x>M) return false;
		return true;
	}
	
	public static int dfs(int y,int x,int direction){
		if(y==N && x ==M) return board[N][M];
		if(dp[y][x][direction]!=0) return dp[y][x][direction];
		visited[y][x] = true;
		int ans = -200000;
		for(int i=0;i<3;i++){
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			if(!isBoundry(ny,nx) || visited[ny][nx]) continue;
			ans = Math.max(ans, dfs(ny,nx,i) + board[y][x]);
		}
		visited[y][x] = false;
		return dp[y][x][direction] = ans;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1][M+1];
		board = new int[N+1][M+1];
		dp = new int[N+1][M+1][3];
		
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++){
				board[i][j] = Integer.parseInt(st.nextToken());
				for(int k=0;k<3;k++){
					dp[i][j][k] = 0;
				}
			}
		}
		System.out.println(Math.max(dfs(1,1,0),dfs(1,1,1)));
	}
}