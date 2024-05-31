import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> hashSetA = new HashSet<>();
        HashSet<Integer> hashSetB = new HashSet<>();

        String numberLine = br.readLine();
        String[] numberLineSplit = numberLine.split(" ");
        for(int i = 0; i < N; i++) {
            hashSetA.add(Integer.parseInt(numberLineSplit[i]));
        }

        int M = Integer.parseInt(br.readLine());
        numberLine = br.readLine();
        numberLineSplit = numberLine.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < M; i++) {
            int compareNum = Integer.parseInt(numberLineSplit[i]);
            if(hashSetA.contains(compareNum)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.println(sb.toString());
     }
}