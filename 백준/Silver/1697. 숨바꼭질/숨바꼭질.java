import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void bfs(int[] graph, int start, int end) {
        LinkedList<Integer> queue = new LinkedList<>();
//        boolean[] visited = new boolean[Math.max(start, end) + 1];
        boolean[] visited = new boolean[100000 + 1];
        graph[start] = 1;
        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int check = queue.poll();
            int[] positions = {check - 1, check + 1, check * 2};

            for(int p : positions) {
                if(p >= 0 && p < graph.length && visited[p] == false) {
                    graph[p] = graph[check] + 1;
                    queue.add(p);
                    visited[p] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

//        int[] graph = new int[Math.max(N, K) + 1];
        int[] graph = new int[100000 + 1];
        bfs(graph, N, K);

//        for(int i = 0; i < graph.length; i++) {
//            System.out.print(graph[i] + " ");
//        }
//        System.out.println();

        System.out.println(graph[K] - 1);
    }
}