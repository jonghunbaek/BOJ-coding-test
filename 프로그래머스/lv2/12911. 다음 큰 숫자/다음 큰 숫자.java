class Solution {
    public int solution(int n) {
        int answer = n;
        StringBuilder sb = new StringBuilder();
        
        while (n != 0) {
            int temp = n%2;
            sb.append(temp);
            n /= 2;
        }
        
        int count = 0;
        for (int i=0; i<sb.length(); i++) {
            if (sb.charAt(i) == '1') {
                count++;
            }
        }
    
        return findNextBigNum(answer, count);
    }
    
    public int findNextBigNum(int n, int count) {
        int temp = 0;

        for (int i=1; i<1000000-n; i++) {
            int tempCnt = 0;
            n++;
            temp = n;
            while (temp != 0) {
                if (temp%2 == 1) {
                    tempCnt++;
                }
                temp /= 2;
            }
            if (tempCnt == count) {
                break;
            }
        }
        
        return n;
    }
}