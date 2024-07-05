import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        // 큐 초기화 및 합계 계산
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        
        // 두 큐의 합이 같아야 할 목표 합계
        long target = (sum1 + sum2) / 2;
        
        // 두 큐의 합이 홀수인 경우 균등하게 나눌 수 없으므로 -1 반환
        if ((sum1 + sum2) % 2 != 0){
            return -1;
        } 
        
        int count = 0;
        int maxOperations = queue1.length * 3; // 최대 작업 횟수 제한
        
        while (count < maxOperations) {
            if (sum1 == target) {
                return count;
            }
            
            if (sum1 > target) {
                int value = q1.poll();
                sum1 -= value;
                sum2 += value;
                q2.add(value);
            } else {
                int value = q2.poll();
                sum2 -= value;
                sum1 += value;
                q1.add(value);
            }
            count++;
        }
        
        return -1;
    }
}