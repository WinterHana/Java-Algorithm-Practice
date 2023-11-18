import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long T = Long.parseLong(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			long[] arr = new long[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[j] = Long.parseLong(st.nextToken());
			}
			long max = Long.MIN_VALUE;
			long money = 0;	// 출력
			long gift = 0;	// 물건 개수
			for(int j = N - 1; j >= 0; j--) {
				if(arr[j] > max) {
					money += (max * gift);
					max = arr[j];
					gift = 0;
				}
				else {
					money -= arr[j];
					gift++;
				}
			}
			
			money += (max * gift);
			
			System.out.println("#" + (i + 1) + " " + money);
		}
	}
}