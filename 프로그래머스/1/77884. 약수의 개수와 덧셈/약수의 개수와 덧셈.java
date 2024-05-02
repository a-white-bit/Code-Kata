import java.util.stream.IntStream;
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        // for문을 이용한 풀이
        // for (int i = left; i <= right; i++) {
        //     if (numberOfDivisor(i) % 2 == 0) answer += i;
        //     else answer -= i;
        // }

        // stream을 이용한 풀이
        answer = IntStream.rangeClosed(left, right).map(num -> {
            if (numberOfDivisor(num) % 2 == 0) return num;
        else return -num;}).sum();

        return answer;
    }
    
    // 약수의 개수 구하는 함수
    int numberOfDivisor(int input) {
        if (input == 1) return 1;
        int answer = 2; // 1, input
        for (int divisor = 2; divisor < input; divisor++)
            if (input % divisor == 0) answer++;
        return answer;
    }
}