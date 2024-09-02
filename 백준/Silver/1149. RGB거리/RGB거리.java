import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N + 1][3];
        int[][] result = new int[N + 1][3];

        for(int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < N + 1; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == 1) {
                    result[i][j] = list[i][j];
                } else {
                    int target = j;
                    int a = (target + 1) % 3;
                    int b = (target + 2) % 3;
                    result[i][j] = list[i][j] + Math.min(result[i - 1][a], result[i - 1][b]);
                }
            }
        }

        System.out.println(Math.min(Math.min(result[N][0], result[N][1]), result[N][2]));
    }
}