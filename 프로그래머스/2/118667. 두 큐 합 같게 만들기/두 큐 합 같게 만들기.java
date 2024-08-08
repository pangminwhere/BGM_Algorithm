import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int n = queue1.length;
        long q1Sum = 0, q2Sum = 0;
        
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            q1.add(queue1[i]);
            q1Sum += queue1[i];
            q2.add(queue2[i]);
            q2Sum += queue2[i];
        }
        
        for (int i = 0; i < 3 * n; i++) {
            if (q1Sum == q2Sum) {
                return answer;
            } else if (q1Sum > q2Sum) {
                int a = q1.poll();
                q1Sum -= a;
                q2Sum += a;
                q2.add(a);
                answer++;
            } else {
                int b = q2.poll();
                q1Sum += b;
                q2Sum -= b;
                q1.add(b);
                answer++;
            }
        }
        return -1;
    }
}