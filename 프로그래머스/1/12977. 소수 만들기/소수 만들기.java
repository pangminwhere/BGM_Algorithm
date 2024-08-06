import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int counter = 0;
        //✅ nums에서 숫자 세개를 고른다. 
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
										//✅ 세 숫자의 합이 소수라면 카운터를 1 증가시킨다.
                    if (isPrime(nums[i] + nums[j] + nums[k])) counter++;
                }
            }
        }
        
        return counter;
    }
    
		//✅ 2 ~ n-1 까지 숫자로 n을 나누어본다. 나누어 떨어진다면 소수로 판별한다.
    private boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        } 
        return true;
    }
}