import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;


// The main method must be in a class named "Main".
class Main {

    private static List<Integer> seq;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        seq = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(getMax(n, m));
    }

    private static int getMax(int N, int M) {

        // 최종 수열 길이는 최소 N - M 이어야 하므로, 조건: j - i >= N - M - 1
        int minRequiredDiff = N - M - 1;

        // prefix minimum 배열 생성 (0-indexed)
        int[] prefixMin = new int[N];
        prefixMin[0] = seq.get(0);
        for (int i = 1; i < N; i++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], seq.get(i));
        }

        int bestAnswer = Integer.MIN_VALUE;

        // j는 마지막 원소의 인덱스로, 최소 j = (N - M - 1)부터 시작해야 함
        for (int j = minRequiredDiff; j < N; j++) {
            // i는 0부터 j - (N - M - 1) 까지 가능
            int allowedIndex = j - minRequiredDiff;
            int candidate = seq.get(j) - prefixMin[allowedIndex];
            bestAnswer = Math.max(bestAnswer, candidate);
        }
        return bestAnswer;

    }
}