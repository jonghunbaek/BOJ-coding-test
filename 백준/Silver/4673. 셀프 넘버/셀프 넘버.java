
public class Main {

	public static void main(String[] args) {
		
		int[] selfNumber = new int[10001];
		selfNumber[0] = 1;
		
		for (int i=1; i<10001; i++) {
			int n = d(i);
			
			if (n < 10001) {				
				selfNumber[n] = 1;
			}
		}
		
		for (int i=1; i<10001; i++) {
			if (selfNumber[i] == 0) {
				System.out.println(i);
			}
		}
	}
	
	public static int d(int i) {
		
		int sum = i;
		
		while (i != 0) {
			sum += i%10;
			i = i/10;
		}
		
		return sum;
	}
}