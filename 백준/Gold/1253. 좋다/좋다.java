import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int result = 0;
		for(int k = 0; k < n; k++) {
			 int i = 0;
			 int j = n - 1;
			 long point = arr[k];
			while(i < j) {
				 if(arr[i] + arr[j] > point) j--;
				 else if(arr[i] + arr[j] < point) i++;
				 else {
					 if(i != k && j != k) {
						 result++;
						 break;
					 }
					 else if(k == i) i++;
					 else if(k == j) j--;
				 }
			}
		}
		System.out.println(result);
		br.close();
	}
}