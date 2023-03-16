import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] result = new long[1001];
        long[] duplicate = new long[1001];
        Arrays.sort(weights);
        for (int i=0; i<weights.length; i++) {
            duplicate[weights[i]]++;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        for (int i=0; i<weights.length; i++) {
            int current = weights[i];
            if (current*2 < result.length) {
                result[current*2] += duplicate[current*2];
            }
            if ((current*3)/2 < result.length && (current*3)%2 == 0) {
                result[(current*3)/2] += duplicate[(current*3)/2];
            }
            if ((current*4)/3 < result.length && (current*4)%3 == 0) {
                result[(current*4)/3] += duplicate[(current*4)/3];
            } 
            set.add(current);
        }
        int previous = 0;
        for (int i=0; i<weights.length; i++) {
            int current = weights[i];
            if (previous == current) {
                result[current] += --duplicate[current];
            }
            previous = current;
        }
        for (int i : set) {
            answer += result[i];
        }
        return answer;
    }
}