import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Point {
    int n;
    int m;

    public Point(int n, int m) {
        this.n = n;
        this.m = m;
    }
}
public class Main {
    public static int[][] field;
    public static boolean[][] visited;
    public static LinkedList<Point> queue;
    public static int[] dn = {1, -1, 0, 0};
    public static int[] dm = {0, 0, 1, -1};

    public static void bfs(int startN, int startM) {
        queue = new LinkedList<>();
        field[startN][startM] = 0;
        queue.add(new Point(startN, startM));
        visited[startN][startM] = true;

        while(!queue.isEmpty()) {
            Point p = queue.poll();

            for(int i = 0; i < dn.length; i++) {
                Point searchPoint = new Point(p.n + dn[i], p.m + dm[i]);

                if(searchPoint.n < 0
                        || searchPoint.n >= field.length
                        || searchPoint.m < 0
                        || searchPoint.m >= field[0].length) {
                    continue;
                }

                if(field[searchPoint.n][searchPoint.m] == 1
                    && visited[searchPoint.n][searchPoint.m] == false) {
                    field[searchPoint.n][searchPoint.m] = (field[p.n][p.m] + 1);
                    queue.add(searchPoint);
                    visited[searchPoint.n][searchPoint.m] = true;
                }
            }
        }

        for(int i = 0; i < field.length; i++) {
            for(int j = 0; j < field[0].length; j++) {
                if(visited[i][j] == false && field[i][j] == 1) {
                    field[i][j] = -1;
                }
            }
        }
    }

    public static void print() {
        for(int i = 0; i < field.length; i++) {
            for(int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        field = new int[n][m];
        visited = new boolean[n][m];

        int startN = 0;
        int startM = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                if(field[i][j] == 2) {
                    startN = i;
                    startM = j;
                }
            }
        }

        bfs(startN, startM);
        print();
    }
}