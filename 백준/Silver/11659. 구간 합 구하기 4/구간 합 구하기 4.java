import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] sumNumbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            sumNumbers[i] += Integer.parseInt(st.nextToken());
            sumNumbers[i] += sumNumbers[i - 1];
        }

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(sumNumbers[end] - sumNumbers[start - 1]);
        }
    }
}