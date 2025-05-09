import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static ArrayList<ArrayList<Integer>> graph;

    public static int[] bfs(int N) {
        boolean[] visited = new boolean[N + 1];
        int[] result = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while(!queue.isEmpty()) {
            int node = queue.poll();

            if(!visited[node]) {
                visited[node] = true;
                for(int next : graph.get(node)) {
                    if(!visited[next]) {
                        if(result[next] == 0) {
                            result[next] = result[node] + 1;
                        } else {
                            result[next] = Math.min(result[next], result[node] + 1);
                        }
                    }
                    queue.add(next);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] result = bfs(N);
        int home = 0;
        int distance = 0;
        int numOfHome = 0;

        for(int i = 0; i <= N; i++) {
            if(result[i] > distance) {
                home = i;
                distance = result[i];
            }
        }

        for(int i = 0; i <= N; i++) {
            if(result[i] == distance) {
                numOfHome++;
            }
        }

        System.out.println(home + " " + distance + " " + numOfHome);
    }
}