class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder(s);
        int wordIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (answer.charAt(i) == ' ') {
                wordIndex = 0;
                continue;
            }
            if (wordIndex % 2 == 0) {
                answer.setCharAt(i, Character.toUpperCase(answer.charAt(i)));
            } else {
                answer.setCharAt(i, Character.toLowerCase(answer.charAt(i)));
            }
            wordIndex++;
        }
            return answer.toString();
    }
}