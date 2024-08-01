import java.util.Arrays;

class Solution {
    public int solution(String[][] book_time) {
        int n = book_time.length;
        int[][] events = new int[n * 2][2];

        for (int i = 0; i < n; i++) {
            int startHour = Integer.parseInt(book_time[i][0].substring(0, 2));
            int startMinute = Integer.parseInt(book_time[i][0].substring(3, 5));
            int endHour = Integer.parseInt(book_time[i][1].substring(0, 2));
            int endMinute = Integer.parseInt(book_time[i][1].substring(3, 5));

            int startTime = startHour * 60 + startMinute;
            int endTime = endHour * 60 + endMinute + 10; // 청소 시간 10분 추가

            events[i * 2][0] = startTime;
            events[i * 2][1] = 1; // 시작 이벤트
            events[i * 2 + 1][0] = endTime;
            events[i * 2 + 1][1] = -1; // 종료 이벤트
        }

        // 시간 순으로 정렬, 같은 시간일 경우 종료 이벤트가 먼저 오도록
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int currentRooms = 0;
        int maxRooms = 0;

        // 이벤트 순회하며 필요한 방 개수 계산
        for (int[] event : events) {
            currentRooms += event[1];
            maxRooms = Math.max(maxRooms, currentRooms);
        }

        return maxRooms;
    }
}