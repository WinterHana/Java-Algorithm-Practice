import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int index; int distance;

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

    public static int[] resultDistance;

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        resultDistance[start] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int distance = now.distance;
            int index = now.index;

            if(resultDistance[index] < distance) continue;
            for(int i = 0; i < graph.get(index).size(); i++) {
                int newCost = resultDistance[index] + graph.get(index).get(i).distance;
                int oldCost = resultDistance[graph.get(index).get(i).index];
                if(oldCost > newCost) {
                    resultDistance[graph.get(index).get(i).index] = newCost;
                    pq.offer(new Node(graph.get(index).get(i).index, newCost));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        resultDistance = new int[N + 1];
        Arrays.fill(resultDistance, (int) 1e9);
        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, distance));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(resultDistance[end]);
    }
}