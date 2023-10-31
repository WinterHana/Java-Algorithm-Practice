import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        String tmp = my_string.replaceAll("[a-z]", "");
        int[] answer = new int[tmp.length()];
        int num = Integer.parseInt(tmp);
        
        for(int i = 0; i < tmp.length(); i++) {
            answer[i] = num % 10;
            num = num / 10;
        }
        Arrays.sort(answer);
        return answer;
    }
}