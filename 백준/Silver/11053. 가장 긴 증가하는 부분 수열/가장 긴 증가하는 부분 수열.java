import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] counts = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            int point = 0;
            int max = 0;
            for(int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && counts[j] > max) {
                    point = j;
                    max = counts[j];
                }
            }

            counts[i] = counts[point] + 1;
        }

        System.out.println(Arrays.stream(counts).max().getAsInt());
    }
}