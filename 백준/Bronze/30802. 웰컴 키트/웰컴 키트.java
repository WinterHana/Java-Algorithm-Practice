import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sizes = new int[6];
        for(int i = 0; i < 6; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
            // System.out.println(sizes[i]);
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        // System.out.println(T + " " + P);

        int clothesBundles = 0;
        for(int i = 0; i < 6; i++) {
            if(sizes[i] > 0) clothesBundles += (sizes[i] - 1) / T + 1;
        }
        System.out.println(clothesBundles);

        int panBundles = N / P;
        int eachPan = N % P;
        System.out.println(panBundles + " " + eachPan);
    }
}