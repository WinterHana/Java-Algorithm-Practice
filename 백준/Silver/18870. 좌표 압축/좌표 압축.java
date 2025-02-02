import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 18870번 : https://www.acmicpc.net/problem/18870
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // Input data
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<Integer>();
        List<Integer> sortedArr = new ArrayList<>(arr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int inputNum = Integer.parseInt(st.nextToken());
            arr.add(inputNum);
            sortedArr.add(inputNum);
        }

        Collections.sort(sortedArr);
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int num : sortedArr) {
            if (!map.containsKey(num)) {
                map.put(num, index++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int num : arr) {
            sb.append(map.get(num)).append(" ");
        }
        System.out.println(sb);
    }
}
