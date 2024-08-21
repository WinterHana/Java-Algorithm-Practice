import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];

        st = new StringTokenizer(br.readLine());
        int start = 0;
        int end = 0;
        for(int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if(end < tree[i]) end = tree[i];
        }

        int max = 0;
        while(start <= end) {
            long sum = 0;
            int mid = (start + end) / 2;

            for(int num : tree) {
                if (num - mid > 0) {
                    sum += (num - mid);
                }
            }

            if(sum < M) { // 1. 더 적게 캐면 높이를 줄인다.
                end = mid - 1;
            } else { // 2. 더 많이 캐면 높이를 높인다.
                start = mid + 1;
            }
        }

        System.out.println(end);
    }
}