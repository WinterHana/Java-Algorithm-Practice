import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static BigInteger[] factorial;

    public static BigInteger bridge(int N, int M) {
        return factorial[M].divide(factorial[M - N].multiply(factorial[N]));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        factorial = new BigInteger[30];
        factorial[0] = BigInteger.valueOf(1);
        for(int i = 1; i < 30; i++) {
            factorial[i] = factorial[i - 1].multiply(BigInteger.valueOf(i));
        }

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(bridge(N, M));
        }
    }
}