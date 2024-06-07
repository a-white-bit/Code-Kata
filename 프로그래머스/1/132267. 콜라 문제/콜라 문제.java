class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int x = 0;
        while(a <= n)
        {
            answer += (n / a) * b;
            x = n % a;
            n = b * (n / a) + x;
        }
        return answer;
    }
}