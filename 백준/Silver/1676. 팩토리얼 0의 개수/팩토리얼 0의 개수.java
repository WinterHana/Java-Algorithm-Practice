import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i = 1; i <= N; i++) {
            int num = i;
            while(true) {
                if(num % 5 == 0) {
                    result++;
                    num = num / 5;
                } else {
                    break;
                }
            }
        }

        System.out.println(result);
    }
}