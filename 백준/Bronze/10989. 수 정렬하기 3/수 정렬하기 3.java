import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N];
        for(int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        list = Arrays.stream(list).sorted().toArray();
        StringBuffer sb = new StringBuffer();
        for(int num : list) {
            sb.append(num + "\n");
        }

        System.out.println(sb);
    }
}