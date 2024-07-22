import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int num = 665;
        List<Integer> numSplit = new ArrayList<>();
        while(count < N) {
            int tmp = ++num;
            while(tmp != 0) {
                numSplit.add(tmp % 10);
                tmp = tmp / 10;
            }

            for(int i = 0; i < numSplit.size() - 2; i++) {
                int first = numSplit.get(i);
                int second = numSplit.get(i + 1);
                int third = numSplit.get(i + 2);

                // System.out.println(first + " " + second + " " + third);

                if(first == 6 && second == 6 && third == 6) {
                    count++;
                    break;
                }
            }

            numSplit.clear();
        }

        System.out.println(num);
    }
}