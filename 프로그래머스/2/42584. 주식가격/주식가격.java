import java.util.*;

class Solution {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> q = new LinkedList<>();
        
        for (int i : prices) {
            q.add(i);
        }
        
        int index = 0;
        
        while (!q.isEmpty()) {
            int currentPrice = q.poll();
            
            for (int i = (prices.length - q.size()); i < prices.length; i++) {
                if (currentPrice > prices[i]) {
                    answer[index]++;
                    break;
                }
                
                if (currentPrice <= prices[i]) {
                    answer[index]++;
                }
            }
            index++;
        }
        return answer;
    }
}