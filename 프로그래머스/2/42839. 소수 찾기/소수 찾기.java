import java.util.*;

class Solution {
    Set<Integer> candidates = new HashSet<>();
    
    public int solution(String numbers) {
        permutation(numbers, 0, new boolean[numbers.length()], 0);
        
        int answer = 0;
        for (int num : candidates) {
            if (isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    void permutation(String numbers, int curr, boolean[] visited, int digit) {
        if (digit == numbers.length()) return;
        
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) continue;
            int newValue = curr + (int)((numbers.charAt(i) - '0') * Math.pow(10,digit));
            candidates.add(newValue);
            
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