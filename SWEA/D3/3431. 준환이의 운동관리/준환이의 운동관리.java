import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long L = Long.parseLong(st.nextToken());
			long U = Long.parseLong(st.nextToken());
			long X = Long.parseLong(st.nextToken());
			long result = 0;
			if(L < X && X < U) {
				result = 0;
			}
			else if(L > X) {
				result = L - X;
			} 
			else if(X > U) {
				result = -1;
			} 
	
			System.out.println("#" + (i + 1) + " " + result);
		}
	}
}