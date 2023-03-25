import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[] partyPeople;
	static List<int[]> parties;
	static int[] truePeople;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		partyPeople = new int[N+1];
		parties = new ArrayList<int[]>();
		for (int i=1; i<=N; i++) {
			partyPeople[i] = i;
		}
		st = new StringTokenizer(br.readLine());
		int truePeopleSize = Integer.parseInt(st.nextToken());
		if (truePeopleSize == 0) {
			System.out.println(M);
			return;
		}
		truePeople = new int[truePeopleSize];
		for (int i=0; i<truePeopleSize; i++) {
			truePeople[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(truePeople);
		int firstPerson = truePeople[0];
		for (int i=1; i<truePeopleSize; i++) {
			partyPeople[truePeople[i]] = firstPerson;
		}
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int party = Integer.parseInt(st.nextToken());
			parties.add(new int[party]);
			int pre = -1;
			for (int j=0; j<party; j++) {
				int current = Integer.parseInt(st.nextToken());
				parties.get(parties.size()-1)[j] = current;
				union(current, pre);
				pre = current;
			}
		}
		for (int[] party : parties) {
			boolean check = false;
			for (int person : party) {
				if (find(firstPerson) == find(person)) {
					check = true;
				}
			}
			if (!check) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void union(int a, int b) {
		if (b == -1) {
			return;
		}
		int first = find(a);
		int second = find(b);
		if (first != second) {
			if (first > second) {
				partyPeople[first] = partyPeople[second];				
			} else {
				partyPeople[second] = partyPeople[first];
			}
		}
	}
	
	public static int find(int node) {
		if (partyPeople[node] == node) {
			return partyPeople[node];
		} else {
			return partyPeople[node] = find(partyPeople[node]);
		}
	}
}