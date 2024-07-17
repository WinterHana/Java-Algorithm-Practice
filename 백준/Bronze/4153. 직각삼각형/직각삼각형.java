import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String s = br.readLine();
            if(s.equals("0 0 0")) break;

            String[] strings = s.split(" ");
            int[] numbers = Arrays.stream(Arrays.stream(strings).mapToInt(Integer::parseInt).toArray()).sorted().toArray();
            boolean result = numbers[0] * numbers[0] + numbers[1] * numbers[1] == numbers[2] * numbers[2];
            if(result) System.out.println("right");
            else System.out.println("wrong");
        }
    }
}