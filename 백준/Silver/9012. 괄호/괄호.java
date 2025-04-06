import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Deque<Character> stack = new ArrayDeque<>();
            String pattern = sc.next();
            char[] charArrays = pattern.toCharArray();

            if (charArrays[0] == ')') {
                System.out.println("NO");
                continue;
            }

            stack.push(charArrays[0]);
            for (int j = 1; j < charArrays.length; j++) {
                if (charArrays[j] == ')') {
                    if (stack.isEmpty()) {
                        stack.push(charArrays[j]);
                        break;
                    } else {
                        stack.pop();
                    }
                }

                if (charArrays[j] == '(') {
                    stack.push(charArrays[j]);
                }
            }
            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}
