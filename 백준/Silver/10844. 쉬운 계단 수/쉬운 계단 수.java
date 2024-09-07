import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] field = new long[101][10];
        for(int i = 1; i <= 9; i++) {
            field[1][i] = 1;
        }

        for(int i = 2; i <= 100; i++) {
            for(int j = 0; j < 10; j++) {
                if(j == 0) field[i][j] = field[i - 1][j + 1] % 1000000000;
                else if(j == 9) field[i][j] = field[i - 1][j - 1] % 1000000000;
                else field[i][j] = (field[i - 1][j - 1] + field[i - 1][j + 1]) % 1000000000;
            }
        }

        System.out.println(Arrays.stream(field[N]).sum() % 1000000000);
    }
}