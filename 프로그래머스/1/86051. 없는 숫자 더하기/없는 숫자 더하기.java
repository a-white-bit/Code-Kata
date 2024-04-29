import java.util.Arrays;
import java.util.stream.IntStream;

// 두 스트림 비교
class Solution {
    public int solution(int[] numbers) {
        return IntStream.rangeClosed(0, 9).filter(n -> Arrays.stream(numbers)
                .noneMatch(number -> n == number)).sum();
    }
}