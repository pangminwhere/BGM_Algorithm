import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int size = brown + yellow;
        
        int y;
        
        for (int i = 3; i <= Math.sqrt(size); i++) {
            if (size % i == 0) {
                y = size / i;
                
                if ((i-2) * (y-2) == yellow) {
                    return new int[]{y, i};
                }
            }
        }
        
        
        return new int[]{0,0};
    }
}