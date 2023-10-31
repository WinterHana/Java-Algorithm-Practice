import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] tmp = my_string.replaceAll("[a-z|A-Z]", "").split("");
        answer = Arrays.stream(tmp)
            .mapToInt(Integer::parseInt)
            .sum();
        
        return answer;
    }
}