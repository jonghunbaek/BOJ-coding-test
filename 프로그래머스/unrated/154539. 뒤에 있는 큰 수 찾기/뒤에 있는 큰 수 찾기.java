import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);

        for (int i=1; i<numbers.length; i++) {
            if (numbers[i] <= numbers[stack.peek()]) {
                stack.push(i);
                continue;
            }
            if (numbers[i] > numbers[stack.peek()]) {
                while (numbers[i] > numbers[stack.peek()]) {
                    answer[stack.pop()] = numbers[i];
                    if (stack.isEmpty()) {
                        break;
                    }
                }
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        return answer;
    }
}