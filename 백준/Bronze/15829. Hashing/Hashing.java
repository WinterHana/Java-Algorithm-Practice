import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String inputString = br.readLine();
        char[] chars = new char[N];
        for(int i = 0; i < N; i++) {
            chars[i] = inputString.charAt(i);
        }

        long sum = 0;
        long r = 1;
        for(int i = 0; i < N; i++) {
            long a = (chars[i] - 96);
            sum +=  a * r;
            r = (r * 31) % 1234567891;
        }

        long result = sum % 1234567891;
        System.out.println(result);
    }
}