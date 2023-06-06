import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                }
                stack.pop();
            } else {
               stack.push('('); 
            }
        }
        if (!stack.isEmpty()) {
            answer = false;
        }
        return answer;
    }
}