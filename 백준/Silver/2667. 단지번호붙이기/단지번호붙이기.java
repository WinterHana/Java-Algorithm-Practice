import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {
    static int[][] field;
    static int N;
    
    static int dfs(int i, int j) {
        if(i < 0 || i >= N || j < 0 || j >= N || field[i][j] == 0 || field[i][j] == -1) return 0;
        else {
            field[i][j] = -1;
            return 1 + dfs(i - 1, j) + dfs(i + 1, j) + dfs(i, j - 1) + dfs(i, j + 1);
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        field = new int[N][N];

        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(line[j]);
            }
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(field[i][j] == 1) {
                    list.add(dfs(i, j));
                    count++;
                }
            }
        }

        Collections.sort(list);

        System.out.println(count);
        for(int num : list) {
            System.out.println(num);
        }
    }
}