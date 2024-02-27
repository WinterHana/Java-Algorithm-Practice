import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 1;
        int tmp = 6;
        while(n > 0) {
            if(n == 1) break;
            n -= tmp;
            tmp +=6;
            result++;
        }

        System.out.println(result);
    }
}