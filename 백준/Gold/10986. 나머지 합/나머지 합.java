import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long answer = 0;
        long[] arr = new long[length ];
        long[] divideArr = new long[M];

        st = new StringTokenizer(br.readLine());
        // 합 배열 생성
        arr[0] = Integer.parseInt(st.nextToken());
        for(int i = 1; i < length; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < length; i++) {
            int remainder = (int) (arr[i] % M);
            if(remainder == 0) answer++;
            divideArr[remainder]++;
        }

        for(int i = 0; i < M; i++) {
            if(divideArr[i] > 1) {
                answer += (divideArr[i] * (divideArr[i] - 1) / 2);
            }
        }
        System.out.println(answer);
    }
}