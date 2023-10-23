import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int temp;
        do{
            temp = n % 10;
            n = n / 10;
            answer += temp;
        } while(n != 0);

        return answer;
    }
}