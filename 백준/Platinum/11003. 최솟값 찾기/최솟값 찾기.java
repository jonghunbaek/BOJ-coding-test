import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int N,L;
	static Deque<Node> dq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		dq = new LinkedList<Node>();
	
		for (int i=0; i<N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			
			while (!dq.isEmpty() && dq.getLast().val > temp) {
				dq.removeLast();
			}
			
			dq.addLast(new Node(temp, i));
			
			if (dq.getFirst().idx <= i - L) {
				dq.removeFirst();
			}
			
			bw.write(dq.getFirst().val + " ");
		}
		
		bw.flush();
		bw.close();
	}
	
	static class Node {
		private int val;
		private int idx;
		
		public Node(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}
	}
}