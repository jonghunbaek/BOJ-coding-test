import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		word = word.toUpperCase();
		int[] cnt = new int[26];
		char ans = ' ';
		
		for (int i=0; i<word.length(); i++) {
			cnt[word.charAt(i)-'A']++;
		}
		
		int max = 0;
		int maxIdx = 0;
		for (int i=0; i<cnt.length; i++) {
			if (max < cnt[i]) {
				max = cnt[i];
				maxIdx = i;
			}
		}
		
		ans = (char)(maxIdx+'A');
		for (int i=0; i<cnt.length; i++) {
			if (cnt[i] == max && maxIdx != i) {
				ans = '?';
			}
		}
		System.out.println(ans);
	}
}