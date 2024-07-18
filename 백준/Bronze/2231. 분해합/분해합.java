import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 1; i < N; i++) {
            int target = i; int div = i;
            while(div != 0) {
                target += div % 10;
                div = div / 10;
            }
            // System.out.println("target : " + target + " i : " + i);

            if(N == target) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}