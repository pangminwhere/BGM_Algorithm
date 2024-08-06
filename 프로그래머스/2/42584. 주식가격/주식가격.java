import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i : prices) {
            q.add(i);
        }
        
        int index = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            for (int i = (prices.length - q.size()); i < prices.length; i++) {
                if (curr > prices[i]) {
                    answer[index]++;
                    break;
                }
                
                if (curr <= prices[i]) {
                    answer[index]++;
                }
            }
            index++;
        }
        return answer;
    }
}