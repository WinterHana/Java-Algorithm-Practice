import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int line = 1;
        int numerator = 0;      // 분자
        int denominator = 0;    // 분모
        while(true) {
            if(sum + line >= N) break;
            sum += line;
            line++;
        }
        sum++;

        if(line % 2 == 1) {
            numerator = line;
            denominator = 1;
            while(sum != N) {
                numerator--; denominator++; sum++;
            }
        } else {
            numerator = 1;
            denominator = line;
            while(sum != N) {
                numerator++; denominator--; sum++;
            }
        }

        System.out.println(numerator + "/" + denominator);
    }
}