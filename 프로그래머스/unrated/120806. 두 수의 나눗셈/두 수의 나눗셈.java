class Solution {
    public int solution(int num1, int num2) {
        float a = (float) num1; float b = (float) num2;
        float f = a / b;
        int result = (int) (f * 1000);
        return result;
    }
}