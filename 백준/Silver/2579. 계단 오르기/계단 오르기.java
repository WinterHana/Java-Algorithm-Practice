import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N + 1];
        int[] sum = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if(N == 1) {
            System.out.println(stairs[1]);
            return;
        } else if (N == 2) {
            System.out.println(stairs[1] + stairs[2]);
            return;
        }
        
        sum[1] = stairs[1];
        sum[2] = stairs[1] + stairs[2];
        for(int i = 3; i <= N; i++) {
            sum[i] = Math.max(sum[i - 3] + stairs[i - 1] + stairs[i], sum[i - 2] + stairs[i]);
        }

        System.out.println(sum[N]);
    }
}