import java.io.*;
// 5분
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt=0; //가지수(정답)
		for(int i=1;i<=N;i++) { //시작
			int sum=0;
			for(int j=i;j<=N;j++) { //시작점부터 순차적으로 더하기
				sum +=j;
				if(sum>N)
					break;
				else if(sum==N) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}