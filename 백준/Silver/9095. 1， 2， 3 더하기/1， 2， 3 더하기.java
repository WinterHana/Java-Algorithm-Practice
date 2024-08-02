import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[12];
        result[1] = 1;
        result[2] = 2;
        result[3] = 4;

        for(int i = 4; i <= 11; i++) {
            result[i] = result[i - 1] + result[i - 2] + result[i - 3];
        }

        for(int i = 0; i < N; i++) {
            int inputNum = Integer.parseInt(br.readLine());
            System.out.println(result[inputNum]);
        }
    }
}