import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] words = new String[N];
		int cnt = 0;
		
		for (int i=0; i<N; i++) {
			words[i] = sc.next();
		}
		
		for (int i=0; i<N; i++) {
			boolean isGroupChar = false;
			String temp = words[i];
			if (temp.length() < 3) {
				cnt++;
			} else {
				for (int j=0; j<temp.length()-2; j++) {
					char tempChar = temp.charAt(j);
					if (temp.charAt(j) != temp.charAt(j+1)) {
						if (temp.substring(j+2).contains(String.valueOf(tempChar))) {
							isGroupChar = true;
							break;
						}
					} 
				}
				
				if (!isGroupChar) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}