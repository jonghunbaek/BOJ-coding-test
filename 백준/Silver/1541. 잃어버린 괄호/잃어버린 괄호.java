import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String equation = br.readLine();
		int sum = 0;
		
		for (int i=equation.length()-1; i>=0; i--) {
			if (equation.charAt(i) == '-') {
				String temp = equation.substring(i+1);
				temp = temp.replace("+", " ");
				temp = temp.replace("-", " ");

				String[] temArr = temp.split(" ");
				for (int j=0; j<temArr.length; j++) {
					sum -= Integer.parseInt(temArr[j]);
				}
				equation = equation.substring(0, i);
			} 		
		}
		
		String temp = equation.toString();
		String[] temArr = temp.split("\\+");
		for (int i=0; i<temArr.length; i++) {
			sum += Integer.parseInt(temArr[i]);
		}
		
		System.out.println(sum);
	}
}