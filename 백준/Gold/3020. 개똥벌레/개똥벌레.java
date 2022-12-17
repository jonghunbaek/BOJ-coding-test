import java.util.Scanner;

public class Main {
	
	static int N,H;
	static int[] stalacmite; // 석순
	static int[] stalactite; // 종유석
	static int min;
	static int cnt;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		H = sc.nextInt();
		stalactite = new int[H];
		stalacmite = new int[H];
		min = N;
		
		for (int i=0; i<N/2; i++) {
			stalacmite[sc.nextInt()]++;
			stalactite[sc.nextInt()]++;
		}
		
		for (int i=1; i<H; i++) {
			stalacmite[i] += stalacmite[i-1];
			stalactite[i] += stalactite[i-1];
		}
		
		for (int i=1; i<=H; i++) {
			int sum = 0;
			sum = stalacmite[H-1] - stalacmite[i-1] + stalactite[H-1] - stalactite[H-i];
			
			if (min > sum) {
				min = sum;
				cnt = 1;
			} else if (min == sum) {
				cnt++;
			}
		}
		
		System.out.println(min + " " + cnt);
		
	}
}