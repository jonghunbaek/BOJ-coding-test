import java.util.Scanner;

public class Main {

	static int N;
	static String[][] originImage;
	static String[][] specialImage;
	static boolean[][] ordinaryVisited;
	static boolean[][] specialVisited;
	static int[] ax = {1,-1,0,0};
	static int[] ay = {0,0,1,-1};
	static int ordinaryCount;
	static int specialCount;
	
	public static void ordinaryDfs(int x, int y) {
		ordinaryVisited[x][y] = true;
		
		for (int i=0; i<4; i++) {
			int nx = x+ax[i];
			int ny = y+ay[i];
			
			if (nx>=0 && ny>=0 && nx<N && ny<N && !ordinaryVisited[nx][ny]) {
				if (originImage[x][y].equals(originImage[nx][ny])) {
					ordinaryDfs(nx, ny);
				}
			}
		}
	}
	
	public static void specialDfs(int x, int y) {
		specialVisited[x][y] = true;
		
		for (int i=0; i<4; i++) {
			int nx = x+ax[i];
			int ny = y+ay[i];
			
			if (nx>=0 && ny>=0 && nx<N && ny<N && !specialVisited[nx][ny]) {
				if (specialImage[x][y].equals(specialImage[nx][ny])) {
					specialDfs(nx, ny);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		originImage = new String[N][N];
		specialImage = new String[N][N];
		ordinaryVisited = new boolean[N][N];
		specialVisited = new boolean[N][N];
		
		for (int i=0; i<N; i++) {
			String temp = sc.next();
			for (int j=0; j<N; j++) {
				originImage[i][j] = String.valueOf(temp.charAt(j));
			}
		}
		
		for(int i=0; i<N; i++) {
			specialImage[i] = originImage[i].clone();
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (specialImage[i][j].equals("G")) {
					specialImage[i][j] = "R";
				}
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!ordinaryVisited[i][j]) {
					ordinaryDfs(i, j);
					ordinaryCount++;
				}
				if (!specialVisited[i][j]) {
					specialDfs(i, j);	
					specialCount++;
				}
			}
		}
		
		System.out.println(ordinaryCount + " " + specialCount);
	}
}