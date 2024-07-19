import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> sumList = new ArrayList<>();

        for(int i = 2; i < N; i++) {
            for(int j = 1; j < i; j++) {
                for(int k = 0; k < j; k++) {
                    sumList.add(numbers[i] + numbers[j] + numbers[k]);
                }
            }
        }

        Collections.sort(sumList);

        int result = 0;
        for(int i : sumList) {
            if(i > M) break;
            else result = i;
        }

        System.out.println(result);
    }
}