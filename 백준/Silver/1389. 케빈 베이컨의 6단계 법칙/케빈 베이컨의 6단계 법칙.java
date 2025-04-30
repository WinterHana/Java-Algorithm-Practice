import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] result = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == j) result[i][j] = 0;
                else result[i][j] = (int) 1e9;
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            result[start - 1][end - 1] = 1;
            result[end - 1][start - 1] = 1;
        }

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(result[i][k] + result[k][j] < result[i][j]) {
                        result[i][j] = result[i][k] + result[k][j];
                    }
                }
            }
        }

        int sum = (int) 1e9;
        int answer = 0;
        for(int i = 0; i < N; i++) {
            int target = Arrays.stream(result[i]).sum();
            if(sum > target) {
                sum = target;
                answer = i + 1;
            }
        }

        System.out.println(answer);
    }
}