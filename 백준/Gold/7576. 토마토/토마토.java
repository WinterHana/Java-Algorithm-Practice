import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static int[][] graph;
    public static LinkedList<Node> queue;
    public static int N;
    public static int M;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void findStartNode() {
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(graph[i][j] == 1) {
                    queue.add(new Node(j, i));
                }
            }
        }
    }

    public static void bfs() {
        queue = new LinkedList<>();
        findStartNode();

        while(!queue.isEmpty()) {
            Node n = queue.poll();

            for(int i = 0; i < dx.length; i++) {
                Node nextNode = new Node(n.x + dx[i], n.y + dy[i]);

                if(nextNode.y < 0
                        || nextNode.y >= graph.length
                        || nextNode.x < 0
                        || nextNode.x >= graph[0].length) {
                    continue;
                }

                if(graph[nextNode.y][nextNode.x] == 0) {
                    graph[nextNode.y][nextNode.x] = graph[n.y][n.x] + 1;
                    queue.add(new Node(nextNode.x, nextNode.y));
                }
            }
        }

    }

    public static void print() {
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int result() {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(graph[i][j] == 0) {
                    return -1;
                } else if(max < graph[i][j]) {
                    max = graph[i][j];
                }
            }
        }

        return max - 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[M][N];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        System.out.println(result());
    }
}