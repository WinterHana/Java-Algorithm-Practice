import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        boolean prime = true;
        for (int num : arr) {
            if (num == 1) {
                continue;
            }

            prime = true;
            for (int j = 2; j < num; j++) {
                if (num % j == 0) {
                    prime = false;
                    break;
                }
            }
            if(prime) count++;
        }

        System.out.println(count);
    }
}