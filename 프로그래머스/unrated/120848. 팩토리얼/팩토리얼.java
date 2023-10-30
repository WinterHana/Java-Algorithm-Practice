

class Solution {
    static int factorial(int i) {
        if(i <= 1) return 1;
        else return factorial(i - 1) * i;
        
    }
    
    public int solution(int n) {
        int i = 0;
        while(true) {
            if(factorial(i) > n) break;
            i++;
        }
        return (i - 1);
    }
}