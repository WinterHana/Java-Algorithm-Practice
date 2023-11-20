import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        double sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            sum += numbers[i];
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            if(max < numbers[i]) max = numbers[i];
        }

        System.out.println(sum * 100 / max / N);
    }
}