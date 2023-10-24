class Solution {
    public int solution(int hp) {
        int general = 5;
        int soldier = 3;
        int worker = 1;
        int answer = 0;
        int tmp = hp;
        
        answer += (tmp / general);
        tmp %= general;
        
        answer += (tmp / soldier);
        tmp %= soldier;
        
        answer += (tmp / worker);
        tmp %= worker;
        
        return answer;
    }
}