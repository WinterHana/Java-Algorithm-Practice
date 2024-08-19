import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int white = 0;
    public static int color = 0;

    public static void checkColor(int[][] confetti, int x, int y, int size) {
        int colorCount = 0;
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                colorCount += confetti[i][j];
            }
        }

        // 1. 1로 채워졌을 때
        if(colorCount == size * size) {
            color++;
        }
        // 2. 0으로 채워줬을 때
        else if(colorCount == 0) {
            white++;
        }
        // 3. 다시 접어야할 때
        else {
            int half = size / 2;
            checkColor(confetti, x, y, half);
            checkColor(confetti, x + half, y, half);
            checkColor(confetti, x, y + half, half);
            checkColor(confetti, x + half, y + half, half);
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] confetti = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                confetti[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkColor(confetti,0, 0, N);
        System.out.println(white);
        System.out.println(color);
    }
}