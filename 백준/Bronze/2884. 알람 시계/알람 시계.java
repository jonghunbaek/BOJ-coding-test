import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int hour = sc.nextInt();
		int min = sc.nextInt();
		int hourDiff = hour-1;
		int minDiff = min-45;
		
		if (minDiff < 0) {
			if (hourDiff < 0) {
				System.out.println((hourDiff+24) + " " + (60+minDiff));
			} else {				
				System.out.println((hour-1) + " " + (60+minDiff));
			}
		} else {
			System.out.println(hour + " " + minDiff);
		}
		
		sc.close();
	}
}