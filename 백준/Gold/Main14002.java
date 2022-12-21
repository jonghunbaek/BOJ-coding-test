import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main14002 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int[] sequence = new int[A];
		int[] dp = new int[A];
		int lengthMax = 0;
		int valueMax = 0;
		List<Integer> temp = new LinkedList<Integer>();
		
		for (int i=0; i<A; i++) {
			sequence[i] = sc.nextInt();
		}

		for (int i=0; i<A; i++) {
			dp[i] = 1;
			
			for (int j=0; j<i; j++) {
				
				if (sequence[j] < sequence[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		for (int i=0; i<dp.length; i++) {
			lengthMax = Math.max(lengthMax, dp[i]);
		}
		System.out.println(lengthMax);

		/*
		 * for (int i=lengthMax; i>=1;) { for (int j=0; j<A; j++) { if (dp[j] == i) {
		 * temp.add(dp[j]); i--; } } }
		 */
		
		
		while (lengthMax>=1) { 
			for (int j=A-1; j>=0; j--) { 
				if (dp[j] == lengthMax) {
					temp.add(sequence[j]); 
					lengthMax--; 
				} 
			} 
		}	 
		
		for (int i=temp.size()-1; i>=0; i--) {
			System.out.print(temp.get(i) + " "); 
		}
	}
}
