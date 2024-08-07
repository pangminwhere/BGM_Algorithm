import java.util.*;

class Solution {
    Set<Integer> candi = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        permutation(numbers, 0, visited, 0);
        
        for (int num : candi) {
            if (isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    void permutation(String numbers, int current, boolean[] visited, int digit) {
        if (digit == numbers.length()) return;
        
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) continue;
            
            int newValue = current + (int)((numbers.charAt(i) - '0') * Math.pow(10, digit));
            candi.add(newValue);
            
            visited[i] = true;
            permutation(numbers, newValue, visited, digit + 1);
            visited[i] = false;
        }
    }
    
    boolean isPrime(int n) {
        if (n < 2) return false;
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}