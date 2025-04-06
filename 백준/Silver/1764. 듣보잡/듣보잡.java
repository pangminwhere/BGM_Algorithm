import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] people = br.readLine().split(" ");
        int N = Integer.parseInt(people[0]);
        int M = Integer.parseInt(people[1]);

        HashSet<String> set = new HashSet<>();


        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String tmp = br.readLine();
            if (set.contains(tmp)) {
                answer.add(tmp);
            }
        }

        Collections.sort(answer);

        System.out.println(answer.size());

        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }
}
