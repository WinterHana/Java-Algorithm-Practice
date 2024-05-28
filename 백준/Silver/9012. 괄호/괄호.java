import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static boolean checkVPS(String test) {
        Stack<String> stack = new Stack<>();
        String[] splitTest = test.split("");
        for(String s : splitTest) {
            if(s.equals("(")) {
                stack.push(s);
            } else if(s.equals(")")) {
                boolean flag = false;
                while(!stack.isEmpty()) {
                    if (stack.pop().equals("(")) {
                        flag = true;
                        break;
                    }
                }
                if(flag == false) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < N; i++) {
            String test = br.readLine();
            if(checkVPS(test)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb.toString());
    }
}