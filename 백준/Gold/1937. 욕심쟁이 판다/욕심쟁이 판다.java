import java.util.Scanner;

public class Main {

	static int n;
	static int[][] map;
	static int[][] dp;
	static int[] ax = {1,-1,0,0};
	static int[] ay = {0,0,-1,1};
	static int max;
	
	public static int dfs(int x, int y) {
		
		if (dp[x][y] != 0) {
			return dp[x][y];	
		}
		
		dp[x][y] = 1;
		
		for (int i=0; i<4; i++) {
			int nx = x + ax[i];
			int ny = y + ay[i];
			
			if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] > map[x][y]) {
				dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
			}
		}
		
		return dp[x][y];
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		map = new int[n][n];
		dp = new int[n][n];
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				max = Math.max(max, dfs(i,j));
			}
		}
		System.out.println(max);
	}
}