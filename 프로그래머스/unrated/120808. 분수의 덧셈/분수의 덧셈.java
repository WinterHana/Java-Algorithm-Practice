class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int resultNumer = numer1 * denom2 + numer2 * denom1;
        int resultDenom = denom1 * denom2;
        
        
        int gcdResult = gcd(resultNumer, resultDenom);
        resultNumer = resultNumer / gcdResult;
        resultDenom = resultDenom / gcdResult;
        
        answer[0] = resultNumer;
        answer[1] = resultDenom;
        
        return answer;
    }
    
    int gcd(int a, int b) {
        int temp = a % b;
        if(temp == 0) return b;
        else return gcd(b, temp);
    }
}