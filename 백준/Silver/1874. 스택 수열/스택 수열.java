import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	static int n;
	static int[] arr;
	static List<String> res;
	static Stack<Integer> stack;
	static int max = 1;
	static boolean isCheckSequence = true;

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n];
		res = new ArrayList<String>();
		stack = new Stack<Integer>();
		
		for (int i=0; i<n; i++) {
			int sequence = sc.nextInt();
			if (sequence >= max) {
				for (int j=max; j<=sequence; j++) {
					stack.push(j);
					res.add("+");
					max++;
				}
				
				stack.pop();
				res.add("-");
				
			} else if (sequence < max) {
				if (stack.peek() != sequence) {
					isCheckSequence = false;
				} 
				
				stack.pop();
				res.add("-");
			}
		}
		
		if (!isCheckSequence) {
			System.out.println("NO");
			return;
		}
		
		for (int i=0; i<res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}