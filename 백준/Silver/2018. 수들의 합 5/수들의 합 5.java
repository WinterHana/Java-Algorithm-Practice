import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        int sum = 1, start = 1, end = 1;
        int count = 1;      // inputNum == sum인 1가지 경우 미리 초기화

        while (end != inputNum) {
            if(sum > inputNum) {
                sum -= start;
                start++;
            } else if (sum < inputNum) {
                end++;
                sum += end;
            } else {
                end++;
                sum += end;
                count++;
            }
        }
        System.out.println(count);
    }
}