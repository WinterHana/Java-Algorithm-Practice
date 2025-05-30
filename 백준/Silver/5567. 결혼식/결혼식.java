import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static List<List<Integer>> graph;
    public static boolean[] visited;

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> nextQ = new LinkedList<>();
        q.add(1);
        Iterator<Integer> startIterator = graph.get(1).iterator();
        while(startIterator.hasNext()) {
            int end = startIterator.next();
            q.add(end);
        }

        while(!q.isEmpty()) {
            int start = q.poll();
            if(!visited[start]) {
                visited[start] = true;
                Iterator<Integer> iterator = graph.get(start).iterator();
                while(iterator.hasNext()) {
                    int end = iterator.next();
                    nextQ.add(end);
                }
            }
        }

        while(!nextQ.isEmpty()) {
            int start = nextQ.poll();
            if(!visited[start]) {
                visited[start] = true;
            }
        }
    }

    public static int result() {
        int count = 0;
        for(int i = 1; i < visited.length; i++) {
            if(visited[i]) count++;
        }
        return count - 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs();
        System.out.println(result());
    }
}