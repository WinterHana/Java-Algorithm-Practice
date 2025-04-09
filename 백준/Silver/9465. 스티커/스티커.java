import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int maxStickerScore(int[][] sticker, int n) {
        int[][] dp = new int[2][n + 1]; // dp[i][n] : n열에서 i행 스티커를 마지막으로 골랐을 때의 최대 가치
        dp[0][1] = sticker[0][1];
        dp[1][1] = sticker[1][1];

        for(int i = 2; i <= n; i++) {
            dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
            dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
        }

        return Math.max(dp[0][n], dp[1][n]);
    }

    public static void main(String[] args) throws Exception {
        // 1. Input T
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 2. Input n, sticker
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n + 1];
            for(int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 1; k <= n; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(maxStickerScore(sticker, n));
        }
    }
}