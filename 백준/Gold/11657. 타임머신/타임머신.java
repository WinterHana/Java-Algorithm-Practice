import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class Main {

    public static int N;

    public static int M;

    public static long[] distance;

    public static Edge[] edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge[M + 1];
        distance = new long[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, weight);
        }

        // 벨만-포드
        distance[1] = 0;
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < M; j++) {
                Edge e = edges[j];

                if(distance[e.start] != Integer.MAX_VALUE
                        && distance[e.end] > distance[e.start] + e.weight) {
                    distance[e.end] = distance[e.start] + e.weight;
                }
            }
        }

        boolean mCycle = false;
        for(int i = 0; i < M; i++) {
            Edge e = edges[i];

            if(distance[e.start] != Integer.MAX_VALUE
                    && distance[e.end] > distance[e.start] + e.weight) {
                mCycle = true;
            }
        }

        if (!mCycle) {
            for(int i = 2; i <= N; i++) {
                if(distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        } else {
            System.out.println("-1");
        }
    }
}
