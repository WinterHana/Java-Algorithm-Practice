import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1]; // N까지 가능한 최대 양

        for(int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(N >= 1) {
            dp[1] = arr[1];
        }

        if(N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        if(N >= 3) {
            for(int i = 3; i < N + 1; i++) {
                int tmp = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);
                dp[i] = Math.max(dp[i - 1], tmp);
            }
        }
        
        System.out.println(dp[N]);
    }
}