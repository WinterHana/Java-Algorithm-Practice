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

        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += (int)(chars[i] - 96) * Math.pow(31, i);
        }

        System.out.println(sum);
    }
}