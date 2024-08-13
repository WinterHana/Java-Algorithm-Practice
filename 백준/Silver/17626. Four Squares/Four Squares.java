import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] result = new int[N + 1];
        result[1] = 1;
        int min = 0;
        for(int i = 2; i <= N; i++) {
            min = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++) {
                int point = i - j * j;
                min = (min > result[point]) ? result[point] : min;
            }

            result[i] = result[min] + 1;
        }

        System.out.println(result[N]);
    }
}