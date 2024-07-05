import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        //Stack 생성
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(arr[0]);

        //for문으로 arr[i]와 stack.peek() 비교
        for (int i=1; i<arr.length; i++){
            if (stack.peek() == arr[i]) {
                continue;
            } else {
                stack.push(arr[i]);
            }
        }

        //stack.pop() 는 거꾸로 꺼내지니까 for문으로 순서 정렬
        answer = new int[stack.size()];
        for (int i=stack.size()-1; i>=0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}