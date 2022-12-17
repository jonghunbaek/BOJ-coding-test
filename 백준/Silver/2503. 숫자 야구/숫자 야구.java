import java.util.Scanner;

public class Main {
	
	static int N;
	static String[] number;
	static int[][] strikeBall;
	static int[][] ans;
	static int[] arr;
	static boolean[] visit;
	static int sum;

	public static void compare(String temp) {
		
		int[][] result = new int[N][2];
		int count = 0;
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<3; j++) {
				if (number[i].charAt(j) == temp.charAt(j)) {
					result[i][0]++;
				}
				
				if (number[i].contains(String.valueOf(temp.charAt(j)))) {
					if (number[i].charAt(j) != temp.charAt(j)) {
						result[i][1]++;
					}
				}
			}
			
		}
		
		for (int i=0; i<N; i++) {
			if (result[i][0] == strikeBall[i][0] && result[i][1] == strikeBall[i][1]) {
				count++;
			}
		}
		
		if (N == count) {
			sum++;
		}
	}
	
	
	public static void question(int cnt) {
		
		String temp = "";
		if (cnt == arr.length) {
			for (int i=0; i<arr.length; i++) {
				temp += arr[i];
			}
			
			compare(temp);	
			
		} else {
			for (int i=1; i<10; i++) {
				if (!visit[i-1]) {
					arr[cnt] = i;
					visit[i-1] = true;
					question(cnt+1);
					visit[i-1] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		number = new String[N];
		strikeBall = new int[N][2];
		ans = new int[N][2];
		arr = new int[3];
		visit = new boolean[9];
		
		for(int i=0; i<N; i++) {
			number[i] = sc.next();
			for (int j=0; j<2; j++) {
				strikeBall[i][j] = sc.nextInt();
			}
		}

		sc.close();
		question(0);
		
		System.out.println(sum);
	}
}