import java.util.*;

class Solution {
    static int[] result;
    
    public int solution(int x, int y, int n) {
        int answer = -1;
        int[] cal = {2, 3, n};
        result = new int[y+1];
        bfs(x, y, n, cal);
        if (result[y] != 0) {
            answer = result[y];
        } else if (x == y) {
            answer = 0;
        }
        return answer;
    }
 
    public static void bfs(int x, int y, int n, int[] cal) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(x);
        
        while (!q.isEmpty()) {
            int temp = q.poll();
            int[] tempArr = new int[3];
            Arrays.fill(tempArr, temp);
            
            for (int i=0; i<cal.length; i++) {
                if (i == 2) {
                    tempArr[i] += cal[i];
                } else {
                    tempArr[i] *= cal[i];
                } 
            }
            
            for (int i=0; i<cal.length; i++) {
                if (tempArr[i] > y) {
                    continue;
                }
                if (result[tempArr[i]] == 0 || result[tempArr[i]] > result[temp]+1) {
                    result[tempArr[i]] = result[temp] + 1;  
                    q.add(tempArr[i]);
                }
            }
        }
    }
}