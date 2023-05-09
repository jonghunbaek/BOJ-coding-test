import java.util.*;

class Solution {
    static int[] ax = {1,-1,0,0};
    static int[] ay = {0,0,1,-1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        return bfs(maps,n,m);
    }
    
    public int bfs(int[][] maps, int n, int m) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] {0,0});
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            for (int i=0; i<4; i++) {
                int nx = ax[i] + now[0];
                int ny = ay[i] + now[1];
                if (nx < 0 || nx > maps.length-1 || ny < 0 || ny > maps[0].length-1 || maps[nx][ny] == 0) {
                    continue;
                }
                
                if (maps[nx][ny] == 1) {
                   q.add(new int[] {nx,ny});
                    maps[nx][ny] = maps[now[0]][now[1]] + 1; 
                }
            }
        } 
        return (maps[n-1][m-1] == 1) ? -1 : maps[n-1][m-1];
    }
}