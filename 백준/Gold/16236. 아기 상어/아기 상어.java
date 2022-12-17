import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static Shark shark;
	static int[][] map;
	static int[] ax = {-1,1,0,0};
	static int[] ay = {0,0,-1,1};
	static int eatingCount = 0;
	static int sharkSize = 2;
	static int moveCount = 0;
	
	private static class Shark {
		int x;
		int y;
		int count;
		
		public Shark(int x, int y, int count) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	public static void bfs() {
	
		Queue<Shark> q = new LinkedList<>();
		q.add(shark);
		
		while(true) {
			LinkedList<Shark> feeding = new LinkedList<Shark>();
			int[][] dist = new int[N][N];
			
			while(!q.isEmpty()) {
				
				Shark temp = q.poll();
				
				for (int i=0; i<4; i++) {
					int nx = temp.x + ax[i];
					int ny = temp.y + ay[i];
					
					if (nx >= 0 && ny >= 0 && nx < N && ny < N && dist[nx][ny] == 0 && map[nx][ny] <= sharkSize) {
						dist[nx][ny] = dist[temp.x][temp.y] + 1;
						q.add(new Shark(nx, ny, dist[nx][ny]));
						if (map[nx][ny] > 0 && map[nx][ny] < sharkSize) {
							feeding.add(new Shark(nx, ny, dist[nx][ny]));
						}
					}
				}
			}
			
			if (feeding.size() == 0) {
				System.out.println(moveCount);
				return;
			}
			
			Shark currentPoint = feeding.get(0);
			for (int i=1; i<feeding.size(); i++) {
				if (currentPoint.count > feeding.get(i).count) {
					currentPoint = feeding.get(i);
					
				} else if (currentPoint.count == feeding.get(i).count) {
					
					if (currentPoint.x > feeding.get(i).x) {
						currentPoint = feeding.get(i);
					} else if (currentPoint.x == feeding.get(i).x) {
						if (currentPoint.y > feeding.get(i).y) {
							currentPoint = feeding.get(i);
						}
					}
				}
			}
			
			moveCount += currentPoint.count;
			eatingCount++;
			map[currentPoint.x][currentPoint.y] = 0;
			if (eatingCount == sharkSize) {
				sharkSize++;
				eatingCount = 0;
			}
			q.add(new Shark(currentPoint.x, currentPoint.y, 0));

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
		sc.close();
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (map[i][j] == 9) {
					map[i][j] = 0;
					shark = new Shark(i,j,0);
				}
			}
		}
		
		bfs();
	}
}