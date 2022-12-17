import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int A = 0;
		int B = 0;
		
		for (int i=0; i<T; i++) {
			A = sc.nextInt();
			B = sc.nextInt();
			System.out.println(A+B);
		}
		
		sc.close();
	}
}