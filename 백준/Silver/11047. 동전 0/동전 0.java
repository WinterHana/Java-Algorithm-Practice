import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NK = br.readLine();
        int N = Integer.parseInt(NK.split(" ")[0]);
        int K = Integer.parseInt(NK.split(" ")[1]);
        int result = 0;

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        for(int i = list.size() - 1; i >= 0; i--) {
            int num = list.get(i);
            if(K < num) continue;
            else {
                result += K / num;
                K = K % num;
            }
            if(K <= 0) break;
        }

        System.out.println(result);
    }
}