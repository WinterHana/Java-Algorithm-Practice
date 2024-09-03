import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
            for(int j = i + 1; j < n; j++) {
                triangle[i][j] = -1;
            }
        }

        dp[0][0] = triangle[0][0];
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i + 1; j++) {
                if(j - 1 >= 0) {
                    dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = triangle[i][j] + dp[i - 1][j];
                }
            }
        }

        System.out.println(Arrays.stream(dp[n - 1]).max().getAsInt());

    }
}