import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int nodeA;
    int nodeB;
    int distance;

    public Node(int nodeA, int nodeB, int distance) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        if(this.distance < o.distance) return -1;
        else if(this.distance == o.distance) return 0;
        else return 1;
    }
}

public class Main {
    public static int N, M;

    public static int[] parent = new int[100001];

    public static ArrayList<Node> nodes;

    public static int result;

    public static int last;

    public static int findParent(int x) {
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodes = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            nodes.add(new Node(a, b, d));
        }

        Collections.sort(nodes);

        last = 0;
        for(int i = 0; i < nodes.size(); i++) {
            int a = nodes.get(i).nodeA;
            int b = nodes.get(i).nodeB;
            int cost = nodes.get(i).distance;

            if(findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
                last = cost;
            }
        }

        System.out.println(result - last);
    }
}