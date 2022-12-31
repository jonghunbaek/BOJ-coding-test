import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int S = sc.nextInt();
		int P = sc.nextInt();
		String st = sc.next();
		int[] dna = new int[4];
		int[] check = new int[4];
		
		for (int i=0; i<dna.length; i++) {
			dna[i] = sc.nextInt();
		}
		
		int si = 0;
		int ei = P-1;
		int cnt = 0;
		
		for (int i=si; i<=ei; i++) {
			if (st.charAt(i) == 'A') {
				check[0]++;
			} else if (st.charAt(i) == 'C') {
				check[1]++;
			} else if (st.charAt(i) == 'G') {
				check[2]++;
			} else if (st.charAt(i) == 'T') {
				check[3]++;
			}
		}
		
		while (ei<S) {
			if (si-1 >=0) {
				if (st.charAt(si-1) == 'A') {
					check[0]--;
				} else if (st.charAt(si-1) == 'C') {
					check[1]--;
				} else if (st.charAt(si-1) == 'G') {
					check[2]--;
				} else if (st.charAt(si-1) == 'T') {
					check[3]--;
				}
				
				if (st.charAt(ei) == 'A') {
					check[0]++;
				} else if (st.charAt(ei) == 'C') {
					check[1]++;
				} else if (st.charAt(ei) == 'G') {
					check[2]++;
				} else if (st.charAt(ei) == 'T') {
					check[3]++;
				}
			}
			
			int temp = 0;
			
			for (int k=0; k<dna.length; k++) {
				if (dna[k] <= check[k]) {
					temp++;
				}
			}
			
			if (temp == 4) {
				cnt++;
			}
			
			ei++;
			si++;
		}
		
		System.out.println(cnt);
	}
}