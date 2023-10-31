import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> tmp = new ArrayList<Integer>();
        int num = n; 
        int idx = 2;
        while(num > 1) {
            if(num % idx == 0) {
                if(!tmp.contains(idx)) tmp.add(idx);
                num = num / idx;
                idx = 2;
                continue;
            }
            idx++;
        } 
        
        
        int[] answer = tmp.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}