import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Node {
    int index;
    int num;

    Node(int index, int num) {
        this.index = index;
        this.num = num;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N, L 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // 숫자 배열 arr 입력
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 슬라이딩 윈도우를 사용하기 위한 Deque 선언
        Deque<Node> deque = new LinkedList<>();

        // 배열 수만큼 반복
        for(int i = 0; i < N; i++) {
            // 덱 맨 뒤에 있는 값과 배열 인덱스의 값을 비교, 덱의 값이 크면 그 값을 removeLast한다.
            // 만약 덱 값이 더 작으면 탐색 종료 후 addLast한다.
            while ((!deque.isEmpty()) && (deque.getLast().num >= arr[i])) {
                deque.removeLast();
            }
            deque.addLast(new Node(i, arr[i]));

            // deque의 첫번째 값 (즉, 최소값)을 print한다.
            bw.write(deque.getFirst().num + " ");

            // 첫 번째 위치 Node의 index를 확인하고, 만약 범위에 맞치 않다면 삭제한다. (i - L + 1보다 작을 때)
            if (deque.getFirst().index <= i - L + 1) {
                deque.removeFirst();
            }
        }
        bw.flush();
        bw.close();
    }
}