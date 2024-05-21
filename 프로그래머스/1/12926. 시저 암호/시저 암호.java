import java.util.Objects;
class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        int ascii;
        for (char c : s.toCharArray()) {
            ascii = c;
            if ((c >= 'A' && c <= 'Z' && ((int)c + n) > 'Z') ||
                    (c >= 'a' && c <= 'z' && ((int)c + n) > 'z')) {
                ascii -= 26;
            }
            if (!Objects.equals(c, ' ')) {
                ascii += n;
            }
            answer.append((char)ascii);
        }
        return answer.toString();
    }
}