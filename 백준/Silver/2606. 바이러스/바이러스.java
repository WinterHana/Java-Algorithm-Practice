import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class GraphDFS {
    int[][] graph;
    boolean[] visited;

    public GraphDFS() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        this.graph = new int[N][N];
        this.visited = new boolean[N];

        int count = Integer.parseInt(br.readLine());
        for(int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            start--; end--;
            graph[start][end] = 1;
            graph[end][start] = 1;
        }
    }

    public void dfs(int index) {
        visited[index] = true;

        for(int i = 0; i < graph[index].length; i++) {
            if(graph[index][i] != 0 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public void print() {
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[0].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void checkVisited() {
        int count = 0;
        for(int i = 0; i < visited.length; i++) {
            if(visited[i] == true) {
                count++;
            }
        }
        System.out.println(count-1);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        GraphDFS graph = new GraphDFS();
        graph.dfs(0);
        graph.checkVisited();
    }
}