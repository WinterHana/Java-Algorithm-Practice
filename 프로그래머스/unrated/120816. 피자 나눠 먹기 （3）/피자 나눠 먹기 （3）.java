class Solution {
    public int solution(int slice, int n) {
        int pizza = 1;
        while(true) {
            int result = (pizza * slice) / n;
            if(result > 0) break;
            pizza++;
        }
        
        return pizza;
    }
}