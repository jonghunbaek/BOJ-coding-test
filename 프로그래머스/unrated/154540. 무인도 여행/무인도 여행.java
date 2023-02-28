import java.util.*;

class Solution {
    static int[] ax = {1,-1,0,0};
    static int[] ay = {0,0,1,-1};
    static int[][] map;
    static boolean[][] visited;
    static int cnt;
    
    public int[] solution(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        List<Integer> stayDay = new ArrayList<Integer>();
        
        for (int i=0; i<maps.length; i++) {
            String temp = maps[i];
            for (int j=0; j<temp.length(); j++) {
                if (temp.charAt(j) == 'X') {
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = temp.charAt(j) - '0';
            }
        }
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[i].length; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                   dfs(i, j); 
                   stayDay.add(cnt);
                   cnt = 0;
                }
            }
        }
        Collections.sort(stayDay);
        int[] answer;
        if (stayDay.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        answer = stayDay.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
    public void dfs(int x, int y) {
        visited[x][y] = true;
        cnt += map[x][y];
        for (int i=0; i<4; i++) {
            int nx = ax[i] + x;
            int ny = ay[i] + y;
            
            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[x].length) {
                if (!visited[nx][ny] && map[nx][ny] != 0) {
                    dfs(nx, ny);              
                }  
            }  
        }
    }
}