class Solution {
    public long solution(long balls, long share) {
        long answer = 1;
        long idx = 1;
        
        for(long i = balls - share + 1; i <= balls; i++) {
            answer *= i;
            if(idx <= share) answer /= (idx++);
        }
        
        return answer;
    }
}