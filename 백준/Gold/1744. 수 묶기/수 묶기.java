/*
수 묶기 (그리디 탐욕법)
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // 양수 우선순위 큐 (내림차순 정렬)
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());

        // 음수 우선순위 큐
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();

        int one = 0;
        int zero = 0;

        for (int i = 0; i < N; i++) {
            int data = sc.nextInt();
            if (data > 1) {
                plusPq.add(data);
            } else if (data == 1) {
                one++;
            } else if (data == 0) {
                zero++;
            } else {
                minusPq.add(data);
            }
        }

        int sum = 0;


        // 양수 처리
        while (plusPq.size() > 1) {
            int first = plusPq.remove();
            int second = plusPq.remove();
            sum += first * second;
        }
        if (!plusPq.isEmpty()) {
            sum += plusPq.remove();
        }

        // 음수 처리
        while (minusPq.size() > 1) {
            int first = minusPq.remove();
            int second = minusPq.remove();
            sum += first * second;
        }
        if (!minusPq.isEmpty()) {
            if (zero == 0) {
                sum += minusPq.remove();
            }
        }

        // 1 처리
        sum += one;
        System.out.println(sum);
    }
}
