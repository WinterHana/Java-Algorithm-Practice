import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N;

    public static ArrayList<ArrayList<Integer>> graph;

    public static int[] inDegree;

    public static int[] times;

    public static void topologySort() {
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[N  + 1];
        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for(int target : graph.get(node)) {
                result[target] = Math.max(result[target], result[node] + times[node]);
                if(--inDegree[target] == 0) {
                    queue.offer(target);
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            System.out.println(result[i] + times[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        inDegree = new int[N + 1];
        times = new int[N + 1];
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            times[i] = time;

            while(st.hasMoreTokens()) {
                int node = Integer.parseInt(st.nextToken());
                if(node == -1) {
                    break;
                } else {
                    graph.get(node).add(i);
                    inDegree[i]++;
                }
            }
        }

        topologySort();
    }
}
