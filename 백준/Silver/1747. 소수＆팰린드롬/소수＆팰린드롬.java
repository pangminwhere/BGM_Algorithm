/*
소수 & 팰린드롬
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] A = new int[10000001];

        for (int i = 2; i < A.length; i++) {
            A[i] = i;
        }

        // 소수 찾기
        for (int i = 2; i < Math.sqrt(A.length); i++) {
            if (A[i] == 0) {
                continue;
            }

            for (int j = i + i; j < A.length; j += i) {
                A[j] = 0;
            }
        }

        // 소수 중 최소인 팰린드롬 수 찾기
        int i = N;
        while (true) {
            if (A[i] != 0) {
                int result = A[i];
                if (isPalindrome(result)) {
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }
    }

    private static boolean isPalindrome(int num) {
        char[] temp = String.valueOf(num).toCharArray();
        
        int s = 0;
        int e = temp.length - 1;

        while (s < e) {
            if (temp[s] != temp[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
