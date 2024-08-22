import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Main {
    static int[][] miro;

    static int bfs(int N, int M) {
        LinkedList<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        while(!queue.isEmpty()) {
            Point p = queue.poll();

            if(p.x - 1 >= 0 && miro[p.x - 1][p.y] == 1) {
                miro[p.x - 1][p.y] = miro[p.x][p.y] + 1;
                queue.add(new Point(p.x - 1, p.y));
            }
            if(p.x + 1 < N && miro[p.x + 1][p.y] == 1) {
                miro[p.x + 1][p.y] = miro[p.x][p.y] + 1;
                queue.add(new Point(p.x + 1, p.y));
            }
            if(p.y - 1 >= 0 && miro[p.x][p.y - 1] == 1) {
                miro[p.x][p.y - 1] = miro[p.x][p.y] + 1;
                queue.add(new Point(p.x, p.y - 1));
            }
            if(p.y + 1 < M && miro[p.x][p.y + 1] == 1) {
                miro[p.x][p.y + 1] = miro[p.x][p.y] + 1;
                queue.add(new Point(p.x, p.y + 1));
            }
        }

        return miro[N - 1][M - 1];
    }


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        miro = new int[N][M];

        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                miro[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println(bfs(N, M));

//        for(int i = 0; i < N; i++) {
//            for(int j = 0; j < M; j++) {
//                System.out.print(miro[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}