import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        if (enemy.length <= k) {
            return enemy.length;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i=0; i<enemy.length; i++) {
            pq.add(enemy[i]);
            
            if (pq.size() > k) {
                n -= pq.poll();
            }
            if (n < 0) {
                return i;
            }
        }
        return enemy.length;
    }
}