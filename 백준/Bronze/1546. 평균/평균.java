import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		double[] scores = new double[N];
		double max = 0;
		double average = 0;
		
		for(int i=0; i<scores.length; i++) {
			scores[i] = sc.nextInt();
			if (scores[i] > max) {
				max = scores[i];
			}
		}
		
		for(int i=0; i<scores.length; i++) {
			scores[i] = (scores[i]/max)*100;
			average += scores[i];
		}
		
		average = average/scores.length;
		System.out.println(average);
		
	}

}