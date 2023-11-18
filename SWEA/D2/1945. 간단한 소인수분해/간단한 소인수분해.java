import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringBuffer str = new StringBuffer();
			int[] numbers = {2, 3, 5, 7, 11};
			for(int number : numbers) {
				int result = 0;
				while(N % number == 0) {
					N = N / number;
					result++;
				}
				str.append(result + " ");
			}
			
			System.out.println("#" + (i + 1) + " " + str.toString());
		}
	}
}