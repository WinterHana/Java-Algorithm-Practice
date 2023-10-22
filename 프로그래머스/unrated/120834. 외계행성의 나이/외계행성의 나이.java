import java.util.*;

class Solution {
    public String solution(int age) {
        StringBuffer answer = new StringBuffer();
        int remain = 0; int tmp = age;
        while(true) {
            remain = tmp % 10;
            answer.insert(0, (char)(97 + remain));
            tmp = tmp / 10;
            if(tmp == 0) break;
        }
        
        return answer.toString();
    }
}