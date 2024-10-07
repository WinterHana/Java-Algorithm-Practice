import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split("");
        String[] s2 = br.readLine().split("");

        int s1Len = s1.length;
        int s2Len = s2.length;

        // DP를 사용하기 위한 배열
        int[][] dp = new int[s1Len + 1][s2Len + 1];

        // LCS 관련 점화식 설정
        for(int i = 1; i <= s1Len; i++) {
            for(int j = 1; j <= s2Len; j++) {
                if(s1[i - 1].equals(s2[j - 1])) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        
        // 디버깅
//        for(int i = 0; i <= s1Len; i++) {
//            for(int j = 0; j <= s2Len; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        // 결과 출력
        System.out.println(dp[s1Len][s2Len]);
    }
}