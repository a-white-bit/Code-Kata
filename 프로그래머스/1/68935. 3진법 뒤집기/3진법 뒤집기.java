import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> remainder = new ArrayList<>();
        int dividend = n;
        while (dividend >= 3) {
            remainder.add(dividend % 3);
            dividend = dividend / 3;
        }
        if(dividend != 0) remainder.add(dividend);

        int i, j, x;
        for (i = 0; i < remainder.size(); i++) {
            x = 1;
            for (j = 0; j < i; j++) x *= 3;
            answer += remainder.get(remainder.size() - i - 1) * x;
        }
        return answer;
    }
}