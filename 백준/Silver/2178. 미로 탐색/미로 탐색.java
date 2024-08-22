
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 괴물이 있는 부분 : 0
 * 괴물이 없는 부분 : 1
 * 시작칸과 마지막 칸은 항상 1
 * 칸을 셀 때는 시작 칸과 마지막 칸을 모두 포함해서 계산한다.
 */
class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int[][] graph;
    public static LinkedList<Point> queue;

    public static int bfs(int N, int M) {
        queue = new LinkedList<>();
        Point start = new Point(0, 0);
        queue.add(start);
        int count = 1;

        while(!queue.isEmpty()) {
            Point p = queue.poll();

//            if(p.x - 1 >= 0 && graph[p.x - 1][p.y] == 1) {
//                graph[p.x - 1][p.y] = ++count;
//                queue.add(new Point(p.x - 1, p.y));
//            } else if(p.x + 1 < N && graph[p.x + 1][p.y] == 1) {
//                graph[p.x + 1][p.y] = ++count;
//                queue.add(new Point(p.x + 1, p.y));
//            } else if(p.y - 1 >= 0 && graph[p.x][p.y - 1] == 1) {
//                graph[p.x][p.y - 1] = ++count;
//                queue.add(new Point(p.x, p.y - 1));
//            } else if(p.y + 1 < M && graph[p.x][p.y + 1] == 1) {
//                graph[p.x][p.y + 1] = ++count;
//                queue.add(new Point(p.x, p.y + 1));
//            }

//            if(p.x + 1 < N && graph[p.x + 1][p.y] == 1) {
//                graph[p.x + 1][p.y] = ++count;
//                queue.add(new Point(p.x + 1, p.y));
//            }  else if(p.y + 1 < M && graph[p.x][p.y + 1] == 1) {
//                graph[p.x][p.y + 1] = ++count;
//                queue.add(new Point(p.x, p.y + 1));
//            }

            if(p.x - 1 >= 0 && graph[p.x - 1][p.y] == 1) {
                graph[p.x - 1][p.y] = graph[p.x][p.y] + 1;
                queue.add(new Point(p.x - 1, p.y));
            }
            if(p.x + 1 < N && graph[p.x + 1][p.y] == 1) {
                graph[p.x + 1][p.y] = graph[p.x][p.y] + 1;
                queue.add(new Point(p.x + 1, p.y));
            }
            if(p.y - 1 >= 0 && graph[p.x][p.y - 1] == 1) {
                graph[p.x][p.y - 1] = graph[p.x][p.y] + 1;
                queue.add(new Point(p.x, p.y - 1));
            }
            if(p.y + 1 < M && graph[p.x][p.y + 1] == 1) {
                graph[p.x][p.y + 1] = graph[p.x][p.y] + 1;
                queue.add(new Point(p.x, p.y + 1));
            }

        }

        return graph[N - 1][M - 1];
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        int result = bfs(N, M);
        System.out.println(result);
    }
}