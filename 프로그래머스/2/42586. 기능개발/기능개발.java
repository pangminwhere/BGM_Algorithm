import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<progresses.length; i++) {
            queue.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        while(!queue.isEmpty()) {
            int value = queue.poll();
            int cnt = 1; //1일 부터

            while(!queue.isEmpty() && value >= queue.peek()) {
                cnt++;
                queue.poll();
            }
            result.add(cnt);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}