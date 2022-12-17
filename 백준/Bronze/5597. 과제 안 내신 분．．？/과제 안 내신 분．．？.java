import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Integer> students = new ArrayList<Integer>();
		List<Integer> submitStudents = new ArrayList<Integer>();
		
		for (int i=1; i<31; i++) {
			students.add(i);
		}
		
		for (int i=1; i<29; i++) {
			submitStudents.add(sc.nextInt());
		}
		sc.close();
		
		for (int student:students) {
			if (!submitStudents.contains(student)) {
				System.out.println(student);
			}
		}
	}
}