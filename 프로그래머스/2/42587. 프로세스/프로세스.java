import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[] {priorities[i], i});
        }
        
        
        while (!queue.isEmpty()) {
            
            int[] current = queue.remove();
            boolean priority = false;
            
            for (int[] next : queue) {
                if (next[0] > current[0]) {
                    priority = true;
                    break;
                }
            }

            if (priority) {
                queue.add(current);
            } else {
                answer++;
                if (current[1] == location) {
                    return answer;
                }
            }
        }
        return answer;
    }
}