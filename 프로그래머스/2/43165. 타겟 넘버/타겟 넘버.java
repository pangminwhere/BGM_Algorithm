class Solution {
    int tmpTarget;
    boolean[] visited;
    int[] dx = {-1, 1};
    int answer;
    void dfs(int [] numbers,int curr, int depth){
        if(depth == numbers.length && curr == tmpTarget){
            answer++;
            return;
        } else if (depth == numbers.length){
            return;
        }
    
        visited[depth] = true;
        for(int i = 0; i<dx.length; i++){
            int newValue = curr + numbers[depth]*dx[i];
            dfs(numbers, newValue, depth+1);
        }
        visited[depth] = false;
    }
    public int solution(int[] numbers, int target) {
        answer = 0;
        tmpTarget = target;
        visited = new boolean[numbers.length];
        dfs(numbers, 0, 0);
        return answer;
    }
}