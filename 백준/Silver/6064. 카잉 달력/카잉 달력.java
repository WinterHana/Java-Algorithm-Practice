import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return(a * b) / gcd(a, b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int end = lcm(M, N);
            boolean isResult = false;
            int k = 1;
            while(k <= end) {
                if((k - x) % M == 0) {
                    if((k - y) % N == 0) {
                        System.out.println(k);
                        isResult = true;
                        break;
                    } else {
                        k += M;
                        continue;
                    }
                }
                k++;
            }

            if(!isResult) {
                System.out.println(-1);
            }
        }
    }
}