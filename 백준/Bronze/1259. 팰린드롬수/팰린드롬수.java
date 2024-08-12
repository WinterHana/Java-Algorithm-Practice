import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String s = br.readLine();
            if(s.equals("0")) break;

            int end = s.length() - 1;
            boolean check = true;
            for(int start = 0; start < s.length() / 2; start++) {
                if(s.charAt(start) != s.charAt(end)) {
                    check = false;
                    break;
                }
                end--;
            }

            System.out.println((check) ? "yes" : "no");
        }
    }
}