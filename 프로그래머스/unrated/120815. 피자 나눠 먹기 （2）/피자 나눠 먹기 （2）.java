class Solution {
    public int solution(int n) {
        int pizza = 1;
        while(true) {
            int result = (pizza * 6) % n;
            if(result == 0) break;
            pizza++;
        }
        
        return pizza;
    }
}