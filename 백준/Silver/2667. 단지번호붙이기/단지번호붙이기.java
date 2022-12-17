import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] house;
	static boolean[][] visited;
	static int[] dfsX = {-1, 1, 0, 0};
	static int[] dfsY = {0, 0, -1, 1};
	static int count;
	static List<Integer> estate = new ArrayList<Integer>();
	
	public static int dfs(int x, int y) {
		visited[x][y] = true;
		
		for (int i=0; i<4; i++) {
			int nextX = x + dfsX[i];
			int nextY = y + dfsY[i];
			
			if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
				if (!visited[nextX][nextY] && house[nextX][nextY] == 1) {
					dfs(nextX, nextY);
					count++;
				}
			}
		}
		
		return count;
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		house = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i=0; i<N; i++) {
			String temp = sc.next();
			for (int j=0; j<N; j++) {
				house[i][j] = temp.charAt(j)-'0';
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (house[i][j] == 1 && !visited[i][j]) {
					count = 1;
					estate.add(dfs(i, j));
				}
			}
		}
		
		Collections.sort(estate);
		System.out.println(estate.size());
		
		for (int i=0; i<estate.size(); i++) {
			System.out.println(estate.get(i));
		}
		
	}
}