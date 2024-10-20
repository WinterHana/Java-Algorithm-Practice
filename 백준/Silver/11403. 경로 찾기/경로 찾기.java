import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[][] field;
    public static int INF = (int)1e9;

    public static void main(String[] args) throws Exception {
        // Input field data and init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        field = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                field[i][j] = (input > 0) ? input : INF;
            }
        }

        // Floyd-Warchall Algorithm
        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    field[i][j] = Math.min(field[i][j], field[i][k] + field[k][j]);
                }
            }
        }

        // Print
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(field[i][j] == INF) System.out.print(0 + " ");
                else System.out.print(1 + " ");
            }
            System.out.println();
        }
    }
}