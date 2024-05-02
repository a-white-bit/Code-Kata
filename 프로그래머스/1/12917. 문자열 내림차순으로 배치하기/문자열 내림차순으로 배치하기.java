import java.util.Arrays;
import java.util.Collections;
class Solution {
    public String solution(String s) {
        String[] myString = s.split("");
        Arrays.sort(myString, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String string : myString) sb.append(string);
        return sb.toString();
    }
}