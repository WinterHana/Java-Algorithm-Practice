import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Node {
    private int num;
    private int weight;

    public Node(int num, int weight) {
        this.num = num;
        this.weight = weight;
    }

    public int getNum() {
        return num;
    }

    public int getWeight() {
        return weight;
    }
}

class Graph {
    private int v;
    private LinkedList<Node>[] adj;
    private int maxWeight;

    Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v + 1];
        for(int i = 1; i < v + 1; i++) {
            this.adj[i] = new LinkedList<>();
        }
        this.maxWeight = 0;
    }

    void addEdge(int start, int end, int weight) {
        adj[start].add(new Node(end, weight));
    }

    void DFSUtil(int v, boolean[] visited, int sum) {
        visited[v] = true;
        Iterator<Node> iterator = adj[v].listIterator();
        while(iterator.hasNext()) {
            Node n = iterator.next();
            if(!visited[n.getNum()]) {
                DFSUtil(n.getNum(), visited, sum + n.getWeight());
            }
        }
        maxWeight = Math.max(maxWeight, sum);
    }

    // 루트 노드를 중심으로 한 가중치의 합을 반환한다.
    int DFS(int v) {
        boolean[] visited = new boolean[this.v + 1];
        this.maxWeight = 0;
        DFSUtil(v, visited, 0);

        return maxWeight;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Graph graph = new Graph(n);
        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.addEdge(start, end, weight);
            graph.addEdge(end, start, weight);
        }

        int result = 0;
        for(int i = 1; i <= n; i++) {
            // int dfsResult = graph.DFS(i);
            // System.out.println("dfsResult : " + dfsResult);
            result = Math.max(result, graph.DFS(i));
            // System.out.println("result : " + result);
        }

        System.out.println(result);
    }
}
