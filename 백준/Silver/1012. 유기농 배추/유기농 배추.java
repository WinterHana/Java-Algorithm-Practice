import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Graph {
    int [][] graph;
    boolean [][] visited;
    int M;
    int N;
    int count;

    Graph(int M, int N) {
        graph = new int[N][M];
        visited = new boolean[N][M];
        this.M = M;
        this.N = N;
    }

    void add(int x, int y) {
        graph[y][x] = 1;
    }

    void dfs(int x, int y) {
        visited[y][x] = true;

        int right = (x - 1 >= 0) ? x - 1 : x;
        int left = (x + 1 < M) ? x + 1 : x;
        int up = (y - 1 >= 0) ? y - 1 : y;
        int down = (y + 1 < N) ? y + 1 : y;

        boolean isRight = (visited[y][right] == false) && (graph[y][right] == 1);
        boolean isLeft = (visited[y][left] == false) && (graph[y][left] == 1);
        boolean isUp = (visited[up][x] == false) && (graph[up][x] == 1);
        boolean isDown = (visited[down][x] == false) && (graph[down][x] == 1);

        if(isRight) dfs(right, y);
        if(isLeft) dfs(left, y);
        if(isUp) dfs(x, up);
        if(isDown) dfs(x, down);
    }

    void search() {
        for(int i = 0; i < N; i++) { // i = y축
            for(int j = 0; j < M; j++) { // j = x축
                if(graph[i][j] == 1 && visited[i][j] == false) {
                    // System.out.println("i : " + i + " j : " + j);
                    dfs(j, i);
                    count++;
                    // System.out.println("counting");
                }
            }
        }

        System.out.println(count);
    }

    void print(){
        System.out.println("1. graph");
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("---------------------------------------");

        System.out.println("2. visited");
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }
}
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Graph graph = new Graph(M, N);

            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph.add(x, y);
            }
            graph.search();
            // graph.print();
        }
    }
}