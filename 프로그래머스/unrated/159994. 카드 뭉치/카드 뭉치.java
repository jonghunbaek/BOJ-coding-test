class Solution {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";
        int idx1 = 0;
        int idx2 = 0;
        int cnt = 0;
        for (int i=0; i<goal.length; i++) {
            if (goal[i].equals(cards1[idx1])) {
                if (idx1 + 1 < cards1.length) {
                    idx1++;    
                } 
                cnt++;
                continue;
            } 
            if (goal[i].equals(cards2[idx2])) {
                if (idx2 + 1 < cards2.length) {
                    idx2++;    
                }        
                cnt++;
            } 
            
        }    
        if (cnt == goal.length) {
            answer = "Yes";
            return answer;
        } 
        return answer;
    }

}