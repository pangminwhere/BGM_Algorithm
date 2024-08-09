class Solution {
    int[] queen;
    int count = 0;
    
    boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (Math.abs(queen[i] - col) == Math.abs(i - row) ||
               queen[i] == col) {
                return false;
            }
        }
        return true;
    }
    
    public int solution(int n) {
        queen = new int[n];
        backtrack(0, n);
        return count;
    }
    
    void backtrack (int row, int n) {
        if (row == n) {
            count++;
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
                queen[row] = col;
                backtrack(row + 1, n);
            }
        }
    }
}