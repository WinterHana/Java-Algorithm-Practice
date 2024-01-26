import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        boolean isClear = false;

        while(N > 0) {
            if(N % 5 == 0) {
                count++;
                N -= 5;
            } else {
                count++;
                N -= 3;
            }

            if(N == 0) {
                isClear = true;
                break;
            }
        }

        if(isClear) System.out.println(count);
        else System.out.println(-1);
    }
}