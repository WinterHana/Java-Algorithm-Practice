import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int index;
    int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        if(this.distance < o.distance) return -1;
        return 1;
    }
}

public class Main {
    public static ArrayList<ArrayList<Node>> graph;
    public static int[] result;

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        result[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.distance;
            int now = node.index;
            if(result[now] < dist) continue;

            for(int i = 0; i < graph.get(now).size(); i++) {
                int cost = result[now] + graph.get(now).get(i).distance;
                if(cost < result[graph.get(now).get(i).index]) {
                    result[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        result = new int[V + 1];
        Arrays.fill(result, (int) 1e9);

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        dijkstra(K);

        for(int i = 1; i < result.length; i++) {
            int num = result[i];
            if(num >= (int) 1e9) System.out.println("INF");
            else System.out.println(num);
        }
    }
}