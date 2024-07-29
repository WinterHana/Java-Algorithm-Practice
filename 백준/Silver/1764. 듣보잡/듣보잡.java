import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> notListen = new HashSet<>();
        HashSet<String> notSeen = new HashSet<>();
        for(int i = 0; i < N; i++) {
            notListen.add(br.readLine());
        }
        for(int i = 0; i < M; i++) {
            notSeen.add(br.readLine());
        }

        List<String> result = new ArrayList<>();
        for(String s : notListen) {
            if(notSeen.contains(s)) {
                result.add(s);
            }
        }
        Collections.sort(result);

        StringBuffer sb = new StringBuffer();
        sb.append(result.size() + "\n");
        for(String s : result) {
            sb.append(s + "\n");
        }

        System.out.println(sb);
    }
}