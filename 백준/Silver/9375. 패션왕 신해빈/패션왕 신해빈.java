import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            HashMap<String, ArrayList<String>> clothes = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            for(int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                if(clothes.get(type) == null) {
                    clothes.put(type, new ArrayList<>());
                }
                clothes.get(type).add(name);
            }
            // System.out.println(clothes);

            int sum = 1;
            Iterator<ArrayList<String>> iterator = clothes.values().iterator();
            while(iterator.hasNext()) {
                ArrayList<String> list = iterator.next();
                sum *= (list.size() + 1);
            }
            sum--;

            System.out.println(sum);
        }
    }
}