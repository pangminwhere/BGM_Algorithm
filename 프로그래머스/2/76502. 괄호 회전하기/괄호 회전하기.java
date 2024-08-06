import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String extendedS = s + s;
        
        for (int i = 0; i < s.length(); i++) {
            if (isValid(extendedS.substring(i, s.length() + i))) answer++;
        }
        return answer;
    }
    
    public boolean isValid(String s) {
        Deque<Character> queue = new ArrayDeque<>();
        
        for (char curr : s.toCharArray()) {
            if (curr == '(' || curr == '{' || curr == '[') {
                queue.push(curr);
            } else {
                if (queue.isEmpty()) {
                    return false;
                }
                
                char target = queue.pop();
                
                if ((target == '(' && curr != ')') ||
                   (target == '{' && curr != '}') ||
                   (target == '[' && curr != ']')) {
                    return false;
                }
            }
        }
        return queue.isEmpty();
    }
}