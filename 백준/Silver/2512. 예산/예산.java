import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        int max = Arrays.stream(arr).max().getAsInt(); // 최댓값
        int min = 1; // 최소값
        int result = 0; // 결과
        while (max >= min) {
            int mid = (max + min) / 2; // 상한액

            // System.out.println("mid : " + mid + " max : " + max + " min : " + min);

            int sum = 0;
            for(int num : arr) {
                sum += (mid - num > 0) ? num : mid;
            }

            // System.out.println("sum : " + sum);

            if(sum > M) { // 합이 더 많이 나왔으면 상한액 줄이기
                max = mid - 1;
            } else { // 합이 더 적게 나왔으면 상한액 높이기
                result = mid; // 가능한 값 중 최대 금액 저장 후 탐색
                min = mid + 1;
            }
        }

        System.out.println(result);
    }
}