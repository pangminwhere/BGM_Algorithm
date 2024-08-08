import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i : prices) {
            queue.add(i);
        }
        
        int index = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            for (int i = (prices.length - queue.size()); i < prices.length; i++) {
                if (curr > prices[i]) {
                    answer[index]++;
                    break;
                } else if (curr <= prices[i]) {
                    answer[index]++;
                }
            }
            index++;
        }
        return answer;
    }
}