import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);       // 정렬

        int count = 0, start = 0, end = N - 1;
        while (end > start) {
            if (arr[start] + arr[end] > num) {
                end--;
            } else if (arr[start] + arr[end] < num){
                start++;
            } else {
                count++; end--; start++;
            }
        }
        System.out.println(count);
    }
}