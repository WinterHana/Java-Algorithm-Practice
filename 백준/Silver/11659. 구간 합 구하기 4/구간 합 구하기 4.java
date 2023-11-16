import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int sum(long[] arr, int i, int j) {
		int sum = 0;
		for(int k = i; k <= j; k++) {
			sum += arr[k];
		}
		return sum;
	}
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
			// arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			System.out.println(arr[j] - arr[i - 1]);
			// System.out.println(sum(arr, i, j));
		}
	} 
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
 	}
}