import java.util.Map;

class Solution {
    public int solution(String s) {
        Map<String, String> numbers = Map.of(
                "zero", "0",
                "one", "1",
                "two", "2",
                "three", "3",
                "four", "4",
                "five", "5",
                "six", "6",
                "seven", "7",
                "eight", "8",
                "nine", "9"
        );
        StringBuilder answer = new StringBuilder();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                answer.append(s.charAt(i));
            }
            else {
                number.append(s.charAt(i));
            }

            if (numbers.containsKey(number.toString())) {
                answer.append(numbers.get(number.toString()));
                number.setLength(0);
            }
        }
        return Integer.parseInt(answer.toString());
    }
}