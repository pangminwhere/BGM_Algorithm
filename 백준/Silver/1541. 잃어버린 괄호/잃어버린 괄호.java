/*
잃어버린 괄호 (그리디 탐욕법)
 */

import java.util.Scanner;

public class Main {

    static int answer = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String question = sc.nextLine();
        String[] str = question.split("-");

        for (int i = 0; i < str.length; i++) {
            int temp = plus(str[i]);
            if (i == 0) {
                answer += temp;
            } else {
                answer -= temp;
            }
        }
        System.out.println(answer);
    }
    
    static int plus(String str) {
        int sum = 0;
        String[] temp = str.split("[+]");

        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
