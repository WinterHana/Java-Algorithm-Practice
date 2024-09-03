import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int[] result = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        result[0] = numbers[0];
        for(int i = 1; i < n; i++) {
            result[i] = Math.max(numbers[i], result[i - 1] + numbers[i]);
        }

//        for(int i = 0; i < n; i++) {
//            System.out.print(result[i] + " ");
//        }

        System.out.println(Arrays.stream(result).max().getAsInt());
        
    }
}