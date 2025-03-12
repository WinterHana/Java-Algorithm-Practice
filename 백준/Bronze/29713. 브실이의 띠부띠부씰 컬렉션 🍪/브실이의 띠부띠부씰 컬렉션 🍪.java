import java.util.*;

public class Main {
    public static int maxGoldChipCount(int N, String stickers) {
        String target = "BRONZESILVER";

        // 1. 모은 알파벳 개수 세기
        Map<Character, Integer> stickerCount = new HashMap<>();
        for (char c : stickers.toCharArray()) {
            stickerCount.put(c, stickerCount.getOrDefault(c, 0) + 1);
        }

        // 2. 목표 단어에서 필요한 알파벳 개수 세기
        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c : target.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        // 3. 각 알파벳별 만들 수 있는 횟수 계산
        int minSets = Integer.MAX_VALUE;
        for (char c : targetCount.keySet()) {
            int available = stickerCount.getOrDefault(c, 0);
            int needed = targetCount.get(c);
            minSets = Math.min(minSets, available / needed);
        }

        return minSets;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String stickers = sc.next();
        sc.close();

        System.out.println(maxGoldChipCount(N, stickers));
    }
}
