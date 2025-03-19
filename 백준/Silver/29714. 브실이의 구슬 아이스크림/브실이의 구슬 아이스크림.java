import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> icecream = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(!icecream.containsKey(num)) {
                icecream.put(num, 1);
            } else {
                icecream.put(num, icecream.get(num) + 1);
            }
        }

        int Q = Integer.parseInt(br.readLine());
        for(int i = 0; i < Q; i++) {
            HashMap<Integer, Integer> Ai = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int ACount = Integer.parseInt(st.nextToken());
            for(int j = 0; j < ACount; j++) {
                int ANum = Integer.parseInt(st.nextToken());
                if(!Ai.containsKey(ANum)) {
                    Ai.put(ANum, 1);
                } else {
                    Ai.put(ANum, Ai.get(ANum) + 1);
                }
            }

            HashMap<Integer, Integer> Bi = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int BCount = Integer.parseInt(st.nextToken());
            for(int j = 0; j < BCount; j++) {
                int BNum = Integer.parseInt(st.nextToken());
                if(!Bi.containsKey(BNum)) {
                    Bi.put(BNum, 1);
                } else {
                    Bi.put(BNum, Bi.get(BNum) + 1);
                }
            }

            boolean isChange = true;
            for(int key : Ai.keySet()) {
                if(!icecream.containsKey(key) || icecream.get(key) < Ai.get(key)) {
                    isChange = false;
                    break;
                }
            }

            if(isChange) {
                for(int key : Ai.keySet()) {
                    if(icecream.containsKey(key)) {
                        icecream.put(key, icecream.get(key) - Ai.get(key));
                    }
                }

                for(int key : Bi.keySet()) {
                    if(!icecream.containsKey(key)) {
                        icecream.put(key, Bi.get(key));
                    } else {
                        icecream.put(key, icecream.get(key) + Bi.get(key));
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        int num = 0;
        for(int key : icecream.keySet()) {
            for(int i = 0; i < icecream.get(key); i++) {
                num++;
                sb.append(key + " ");
            }
        }
        System.out.println(num);
        System.out.println(sb);
    }
}