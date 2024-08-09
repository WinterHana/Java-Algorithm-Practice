import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Graph {
    ArrayList<Integer>[] graph;
    int N;
    boolean[] visited;
    LinkedList<Integer> queue;

    public Graph(int N) {
        graph = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        this.N = N;
        visited = new boolean[N + 1];
        queue = new LinkedList<>();
    }

    void insert(int start, int end) {
        graph[start].add(end);
        graph[end].add(start);
        for(int i = 0; i < N + 1; i++) {
            Collections.sort(graph[i]);
        }
    }

    void clear() {
        visited = new boolean[N + 1];
    }

    void print() {
        for(int i = 0; i < N + 1; i++) {
            System.out.println(i + " : " + graph[i]);
        }
    }

    void dfs(int index) {
        visited[index] = true;
        System.out.print(index + " ");
        for(int end : graph[index]) {
            if(!visited[end]) {
                dfs(end);
            }
        }
    }

    void bfs(int index) {
        visited[index] = true;
        System.out.print(index + " ");
        queue.add(index);

        while(queue.size() != 0) {
            int start = queue.poll();

            for(int end : graph[start]) {
                if(!visited[end]) {
                    visited[end] = true;
                    queue.add(end);
                    System.out.print(end + " ");
                }
            }
        }
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(N);
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.insert(start, end);
        }
        
        // graph.print();
        graph.dfs(V);
        graph.clear();
        System.out.println();
        graph.bfs(V);
    }
}