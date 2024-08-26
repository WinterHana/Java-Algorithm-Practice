import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lines = new int[K];
        for(int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lines);

        long max = lines[K - 1];
        long min = 1;
        while(max >= min) {
            long pivot = (max + min) / 2;
            // System.out.println("pivot : " + pivot);
            int sum = 0;
            for(int line : lines) {
                sum += (line / pivot);
            }

            if(sum < N) { // 더 적게 나왔으면 전선의 길이가 짧아져야 함
                max = pivot - 1;
            } else {      // 더 많이 나왔으면 전선의 길이가 길어져야 함
                min = pivot + 1;
            }

            // System.out.println("sum : " + sum + " min : " + min + " ~ max : " + max);
        }

        // 성립할 수 있는 값 중 최댓값
        System.out.println(max);
    }
}