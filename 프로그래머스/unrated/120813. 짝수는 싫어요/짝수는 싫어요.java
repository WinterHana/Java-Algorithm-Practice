import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++) {
            if(i % 2 == 1) array.add(i);
        }
        
        int[] answer = new int[array.size()];
        for(int i = 0; i < array.size(); i++) {
            answer[i] = array.get(i);
        }
        
        return answer;
    }
}