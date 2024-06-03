import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lineSplit = br.readLine().split(" ");
        int start = Integer.parseInt(lineSplit[0]);
        int end = Integer.parseInt(lineSplit[1]);

        for(int i = start; i <= end; i++) {
            if(i == 1) continue;
            boolean isPrime = true;
            for(int j = 2; j * j <= i; j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) System.out.println(i);
        }
    }
}