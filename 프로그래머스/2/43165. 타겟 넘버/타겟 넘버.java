class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, target, 0);
    }
    
    int dfs(int[] numbers, int index, int target, int curr) {
        if (index == numbers.length) {
            return (target == curr) ? 1 : 0;
        }
        
        int sum = 0;
        
        sum += dfs(numbers, index + 1, target, curr + numbers[index]);
        sum += dfs(numbers, index + 1, target, curr - numbers[index]);
        
        return sum;
    }
}