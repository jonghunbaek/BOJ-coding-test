import java.util.Scanner;

public class Main {
	static int N;
	static String M;
	
	public static void sequence(String m) {
		
		if (m.length() == N) {
			System.out.println(m);
			System.exit(0);
			
		} else {
			for (int i=1; i<4; i++) {
				if (ischeck(m+i)) {
					sequence(m+i);
				}
			}
		}
	}
	
	public static boolean ischeck(String m) {
		
		int length = m.length()/2;
		
		for (int i=1; i<=length; i++) {
			if (m.substring(m.length()-i).equals(m.substring(m.length()-2*i, m.length()-i))) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sc.close();
		
		sequence("");
		
	}
}