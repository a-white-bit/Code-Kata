class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            int sword = getNumberOfFactor(i);
            if (sword > limit) {
                answer += power;
            } else {
                answer += sword;
            }
        }
        
        return answer;
    }
    
    private int getNumberOfFactor(int number) {
        int result = 0;
        for (int i = 1; number >= i*i; i++) {
            if (number == i*i) {
                result++;
            }
            else if (number % i == 0) {
                result += 2;
            }
        }
        
        return result;
    }
}