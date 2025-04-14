/*
톱니바퀴 (구현)
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Deque<Character>[] gears = new Deque[4];
    static int[] rotateDir = new int[4]; // 회전 방향 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            gears[i] = new ArrayDeque<>();
            String line = br.readLine();

            for (char c : line.toCharArray()) {
                gears[i].addLast(c);
            }
        }

        int K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            Arrays.fill(rotateDir, 0);
            rotateDir[num] = dir;

            // 왼쪽으로 전파
            for (int i = num - 1; i >= 0; i--) {
                if (getRight(gears[i]) != getLeft(gears[i + 1])) {
                    rotateDir[i] = -rotateDir[i + 1];
                } else {
                    break;
                }
            }

            // 오른쪽으로 전파
            for (int i = num + 1; i < 4; i++) {
                if (getLeft(gears[i]) != getRight(gears[i - 1])) {
                    rotateDir[i] = -rotateDir[i - 1];
                } else {
                    break;
                }
            }

            // 회전 수행
            for (int i = 0; i < 4; i++) {
                if (rotateDir[i] == 0) continue;
                rotate(gears[i], rotateDir[i]);
            }
        }

        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i].peekFirst() == '1') {
                score += (1 << i);
            }
        }

        System.out.println(score);
    }

    // 시계 / 반시계 방향 회전
    static void rotate(Deque<Character> dq, int dir) {
        if (dir == 1) {
            dq.addFirst(dq.pollLast()); // 시계 방향
        } else {
            dq.addLast(dq.pollFirst()); // 반시계 방향
        }
    }

    // 오른쪽 톱니
    static char getRight(Deque<Character> dq) {
        Iterator<Character> it = dq.iterator();
        it.next(); it.next();
        return it.next();
    }

    // 왼쪽 톱니
    static char getLeft(Deque<Character> dq) {
        Iterator<Character> it = dq.iterator();
        for (int i = 0; i < 6; i++) it.next();
        return it.next();
    }
}
