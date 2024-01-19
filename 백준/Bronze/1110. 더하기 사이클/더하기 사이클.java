import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int newNum = N;
        while(true) {
            int numLeft = ((newNum % 10) * 10);
            if(newNum < 10) {
                newNum *= 10;
            }
            int numRight = (((newNum / 10) + (newNum % 10)) % 10);
            newNum = numLeft + numRight;
            
            count++;
            if(newNum == N) {
                break;
            }
        }
        System.out.println(count);
    }
}