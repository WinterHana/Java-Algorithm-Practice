import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * DP 문제 : 점화식 도출
 * N을 1로 만들기 위한 최소 횟수 = N - 1을 1로 만들기 위한 최소 횟수 + 1
 * OR 2나 3으로 니눠지면, 나눠지고 남은 몫의 경우의 연산의 수 + 1
 * 위 두 가지 중 하나를 선택하여 취한다.
 */

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        arr[1] = 0;
        for(int i = 2; i <= N; i++) {
            arr[i] = arr[i - 1] + 1;
            if(i % 2 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            }

            if(i % 3 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 3] + 1);
            }
        }

        System.out.println(arr[N]);
    }
}