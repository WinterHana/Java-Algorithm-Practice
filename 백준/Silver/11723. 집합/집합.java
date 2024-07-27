import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Set {
    int binaryNum;

    public Set() {
        binaryNum = 0;
    }

    void add(int num) {
        binaryNum = binaryNum | (1 << num);
    }

    void remove(int num) {
        binaryNum = binaryNum & ~(1 << num);
    }

    void toggle(int num) {
        binaryNum = binaryNum ^ (1 << num);
    }

    char check(int num) {
        if((binaryNum & (1 << num)) == (1 << num)) return '1';
        else return '0';
    }

    void all() {
        binaryNum = ~(1 << 21);
    }

    void empty() {
        binaryNum = 0;
    }

}


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        Set set = new Set();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if (order.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                set.add(num);
            } else if (order.equals("remove")) {
                int num = Integer.parseInt(st.nextToken());
                set.remove(num);
            } else if (order.equals("check")) {
                int num = Integer.parseInt(st.nextToken());
                sb.append(set.check(num) + "\n");
            } else if (order.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                set.toggle(num);
            } else if (order.equals("all")) {
                set.all();
            } else if (order.equals("empty")) {
                set.empty();
            }
        }

        System.out.println(sb);
    }
}