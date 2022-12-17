import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] ax = {1,-1,0,0};
	static int[] ay = {0,0,1,-1};
	static int max;
	
	public static void dfs(int[][] temp, int x , int y) {
		visited[x][y] = true;
		
		for (int i=0; i<4; i++) {
			int nx = x+ax[i];
			int ny = y+ay[i];
			
			if (nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny]) {
				if (temp[nx][ny] != 0) {
					dfs(temp, nx, ny);
				}
			}
		}
		
	}
	
	public static void heightCheck(int height) {
		int count = 0;
		int temp[][] = new int[N][N];
		
		for (int i=0; i<N; i++) {
			temp[i] = map[i].clone();
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (temp[i][j] <= height) {
					temp[i][j] = 0;
				}
			}
		}
		
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (temp[i][j] != 0 && !visited[i][j]) {	
					dfs(temp,i,j);
					count++;
				}
			}
		}
		
		if (max < count) {
			max = count;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		for (int i=0; i<=100; i++) {
			heightCheck(i);
			visited = new boolean[N][N];
		}
		
		System.out.println(max);
	}

}