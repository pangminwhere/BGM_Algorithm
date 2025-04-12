import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    static boolean[] visited = new boolean[13];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 12; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();

            if (hashMap.containsKey(a)) {
                aList = hashMap.get(a);
            }
            aList.add(b);
            hashMap.put(a, aList);

            if (hashMap.containsKey(b)) {
                bList = hashMap.get(b);
            }
            bList.add(a);
            hashMap.put(b, bList);

            if (a > b) {
                min = Math.min(min, b);
            } else {
                min = Math.min(min, a);
            }
        }

        int result = bfs(min);

        System.out.println(result);
    }

    public static int bfs(int min) {
        Queue<Integer> que = new LinkedList<>();

        que.offer(min);
        visited[min] = true;

        int result = 0;
        while (!que.isEmpty()) {
            int number = que.poll();

            List<Integer> list = hashMap.get(number);

            if (list.size() > 2) {
                boolean one = false;
                boolean two = false;
                boolean three = false;

                for (int i = 0; i < 3; i++) {
                    int connect = list.get(i);

                    if (hashMap.get(connect).size() == 3 && !three) {
                        three = true;
                    } else if (hashMap.get(connect).size() == 2 && !two) {
                        two = true;
                    } else if (hashMap.get(connect).size() == 1 && !one) {
                        one = true;
                    }
                }

                if (one && two && three) {
                    result = number;
                    break;
                }
            }

            for (int i = 0; i < list.size(); i++) {
                if (!visited[list.get(i)]) {
                    que.offer(list.get(i));
                    visited[list.get(i)] = true;
                }
            }
        }

        return result;
    }
}
