import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	       Scanner sc = new Scanner(System.in);

	       int A = sc.nextInt();
	       int B = sc.nextInt();
	       int C = sc.nextInt();
	       int M = sc.nextInt();

	       sc.close();
	       
	       int count = 0;
	       int work = 0;

	       for (int i=0; i<24; i++) {
	           if (count+A>M) {
	               count -= C;

	               if (count < 0) {
	                   count = 0;
	               }
	               
	           } else if (count<=M) {
	               count += A;
	               work += B;
	           }

	       }

	       System.out.println(work);

	    }
	}