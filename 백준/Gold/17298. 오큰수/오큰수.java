import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] sequence;
	static int[] NGE;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sequence = new int[N];
		NGE = new int[N];
		stack = new Stack<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<N; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}
		
		stack.push(0); // 현재 원소와 스택의 top값을 비교해야하는데 0번째 원소는 스택이 비어있는 상태이기 때문이다.
		for (int i=1; i<N; i++) {
			if (sequence[i] <= sequence[stack.peek()]) {
				stack.push(i);
				continue;
			}
			
			if (sequence[i] > sequence[stack.peek()]) {
				while (sequence[i] > sequence[stack.peek()]) {
					
					NGE[stack.pop()] = sequence[i];
					if (stack.isEmpty()) {
						break;
					}
				}
				
				stack.push(i);
			}
		}
		
		while (!stack.isEmpty()) {
			NGE[stack.pop()] = -1;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i=0; i<N; i++) {
			bw.write(NGE[i] + " ");
		}
		bw.write("\n");
		bw.flush();;
	}
}