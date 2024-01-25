import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;     // 정답
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            boolean isGroupWord = true;
            boolean[] alphabet = new boolean[26];

            while(!str.isEmpty()) {
                char c = str.charAt(0);
                if(alphabet[(int)(c) - 'a'] == false) {
                    alphabet[(int)(c) - 'a'] = true;
                    while(!str.isEmpty() && str.charAt(0) == c) {
                        str = str.substring(1);
                    }
                } else {
                    isGroupWord = false;
                    break;
                }
            }

            if(isGroupWord) result++;
        }

        System.out.println(result);
    }
}