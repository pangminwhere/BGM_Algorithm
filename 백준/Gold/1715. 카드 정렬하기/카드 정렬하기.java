/*
카드 정렬하기 (그리디 탐욕법)
 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int card = sc.nextInt();
            pq.add(card);
        }

        int card1 = 0;
        int card2 = 0;
        int sum = 0;

        while(pq.size() != 1) {
            card1 = pq.remove();
            card2 = pq.remove();
            sum += card1 + card2;
            pq.add(card1 + card2);
        }

        System.out.println(sum);
    }
}
