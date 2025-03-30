class Solution {
    public int solution(int[][] sizes) {
        int max_width = 0;
        int max_height = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            
            if (max_width < sizes[i][0]) max_width = sizes[i][0];
            if (max_height < sizes[i][1]) max_height = sizes[i][1];
        }
        
        return max_width * max_height;
    }
}