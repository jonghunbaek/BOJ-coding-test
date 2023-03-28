import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[] studentsSort;
	static List<Integer>[] students;
	static List<Integer> answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		studentsSort = new int[N+1];
		students = new ArrayList[N+1];
		answer = new ArrayList<Integer>();
		for (int i=1; i<=N; i++) {
			students[i] = new ArrayList<Integer>();
		}
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			students[s].add(e);
		}
		for (int i=1; i<=N; i++) {
			for (int j : students[i]) {
				studentsSort[j]++;
			}
		}
		for (int i=1; i<=N; i++) {
			if (studentsSort[i] == 0) {
				answer.add(i);
			}
		}
		while (!answer.isEmpty()) {
			int temp = answer.get(0);
			answer.remove(0);
			System.out.print(temp + " ");
			for (int next : students[temp]) {
				studentsSort[next]--;
				if (studentsSort[next] == 0) {
					answer.add(next);
				}
			}
		}
	}
}
