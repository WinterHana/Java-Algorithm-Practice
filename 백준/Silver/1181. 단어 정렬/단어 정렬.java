import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int compareString(String s1, String s2) {
        int length = s1.length();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        for(int i = 0; i < length; i++) {
            if(c1[i] > c2[i]) {
                return 1;
            } else if(c1[i] < c2[i]) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.stream(arr).sorted((o1, o2) -> {
            if(o1.length() > o2.length()) {
                return 1;
            } else if(o1.length() < o2.length()) {
                return -1;
            } else {
                return compareString(o1, o2);
            }
        }).distinct().forEach(System.out::println);
    }
}