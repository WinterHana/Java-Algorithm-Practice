import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        // N과 수열 입력
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 스택 선언
        Stack<Integer> stack = new Stack<>();

        // 주어진 수열이 어떻게 발생했는지 파악하며 진행해보자        
        // count를 기준으로 수열 값과 비교하여 스택에 값 넣기
        int count = 1;
        boolean isCanStack = true;
        for (int i = 0; i < N; i++) {
            if (arr[i] >= count) { // 만약 arr[i] >= count라면 count > arr[i]가 될 때까지 더하면서 스택에 push한 후 한 번 pop하기
                while(count <= arr[i]) {
                    stack.push(count);
                    count++;
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else { // 만약 arr[i] < count라면 stack을 하나 pop한 다음, 만약 pop한 값이 arr[i]보다 더 크다면 No 출력하고 종료
                int compareNum = stack.pop();
                if(compareNum > arr[i]) {
                    System.out.println("NO");
                    isCanStack = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if (isCanStack) {
            System.out.println(sb.toString());
        }
    }
}