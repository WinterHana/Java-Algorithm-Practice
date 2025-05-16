import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] visited;
    public static int[] results;
    public static int N;
    public static int M;

    public static void dfsStart(int start) {
        visited = new boolean[N + 1];

        dfs(start);

        int result = 0;
        for(int i = 1; i <= N; i++) {
            if(visited[i]) result++;
        }

        results[start] = result;
    }

    public static void dfs(int N) {
        visited[N] = true;

        Iterator<Integer> it = graph.get(N).listIterator();

        while(it.hasNext()) {
            int num = it.next();
            if(!visited[num]) {
                dfs(num);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        results = new int[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(B).add(A);
        }

        for(int i = 1; i <= N; i++) {
            dfsStart(i);
        }

        int max = Arrays.stream(results).max().getAsInt();
        for(int i = 1; i <= N; i++) {
            if(results[i] == max) {
                System.out.print(i + " ");
            }
        }
    }
}