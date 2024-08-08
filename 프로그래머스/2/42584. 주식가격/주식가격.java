import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> que = new LinkedList<>();
        
        for (int i : prices) {
            que.add(i);
        }
        
        int index = 0;
        while (!que.isEmpty()) {
            int curr = que.poll();
            
            for (int i = (prices.length - que.size()); i < prices.length; i++) {
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