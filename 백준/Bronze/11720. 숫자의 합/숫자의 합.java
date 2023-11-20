import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String num = br.readLine();
        String[] numbers = num.split("");
        int sum = 0;
        for(String number : numbers) {
            sum += Integer.parseInt(number);
        }
        System.out.println(sum);
    }
}