import java.util.Scanner;

public class Main {

	static int N,M;
	static int[][] labMap;
	static int[][] temp;
	static boolean[][] visited;
	static boolean[][] virus;
	static int[] ax = {1,-1,0,0};
	static int[] ay = {0,0,1,-1};
	static int max;
	
	public static void dfs(int cnt, int x, int y) {
		int sum = 0;
		
		if (cnt == 3) {
			
			for (int i=0; i<N; i++) {
				temp[i] = labMap[i].clone();
				for (int j=0; j<M; j++) {
					virus[i][j] = false;
				}
			}
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (temp[i][j] == 2 && !virus[i][j]) {
						change(i,j);
					}
				}
			}
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (temp[i][j] == 0) {
						sum++;
					}
				}
			}
			max = Math.max(max, sum);
			
		} else {
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (labMap[i][j]==0 && !visited[i][j]) {
						labMap[i][j] = 1;
						visited[i][j] = true;
						dfs(cnt+1,i,j);
						labMap[i][j] = 0;
						visited[i][j] = false;
					}
				}
			}
		}
	}
	
	public static void change(int x, int y) {
		virus[x][y] = true;
		
		for (int i=0; i<4; i++) {
			int nx = x+ax[i];
			int ny = y+ay[i];
			
			if (nx>=0 && ny>=0 && nx<N && ny<M) {
				if (!virus[nx][ny] && temp[nx][ny] == 0) {
					temp[nx][ny] = 2;
					change(nx, ny);
				}
			}	
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		labMap = new int[N][M];
		temp = new int[N][M];
		visited = new boolean[N][M];
		virus = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				labMap[i][j] = sc.nextInt();
			}
		}
		
		dfs(0,0,0);
		
		System.out.println(max);
	}
}