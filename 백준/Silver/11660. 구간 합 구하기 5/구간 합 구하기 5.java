import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    
	static int N;
	static int M;
	static int[][] map;
	static int[][] dpMap;
	static int[][] section;
	static List<Integer> sumList = new ArrayList<Integer>();
	
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N+1][N+1];
        dpMap = new int[N+1][N+1];
        
        for (int i=1; i<=N; i++) {
        	for (int j=1; j<=N; j++) {
        		map[i][j] = sc.nextInt();
        	}
        }
        
        for (int i=1; i<=N; i++) {
        	for (int j=1; j<=N; j++) {
        		dpMap[i][j] = dpMap[i-1][j] + dpMap[i][j-1] - dpMap[i-1][j-1] + map[i][j]; 
        	}
        }
        
        for (int i=1; i<=M; i++) {
        	int x1 = sc.nextInt();
        	int y1 = sc.nextInt();
        	int x2 = sc.nextInt();
        	int y2 = sc.nextInt();
        	
        	int sum = dpMap[x2][y2] - dpMap[x2][y1-1] - dpMap[x1-1][y2] + dpMap[x1-1][y1-1];
        	sumList.add(sum);
        }
        
        for (int i:sumList) {
        	System.out.println(i);
        }
    }
}