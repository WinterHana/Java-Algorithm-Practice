import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> numbers = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            int value = (numbers.get(key) != null) ? numbers.get(key) : 0;
            numbers.put(key, value + 1);
        }

        int M = Integer.parseInt(br.readLine());
        int[] target = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        for(int t : target) {
            int result = numbers.getOrDefault(t, 0);
            System.out.print(result + " ");
        }
    }
}