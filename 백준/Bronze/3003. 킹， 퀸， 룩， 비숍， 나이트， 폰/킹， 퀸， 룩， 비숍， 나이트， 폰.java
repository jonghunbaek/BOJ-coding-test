import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		int[] chess = {1, 1, 2, 2, 2, 8};
		int[] inputChess = new int[6];
		
		Scanner scan = new Scanner(System.in);
		
		for(int i=0; i<chess.length; i++) {
			inputChess[i] = scan.nextInt();
			System.out.print((chess[i]-inputChess[i]) + " ");
		}
		
		scan.close();
	}
}