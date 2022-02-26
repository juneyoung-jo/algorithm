package programmers;

import java.util.*;

public class 광고삽입_2021KAKAO_BLIND_REC {
    static long time[];

    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = formatTime(play_time);
        time = new long[playTime + 1];

        for (String log : logs) {
            String[] logTime = log.split("-");
            int start = formatTime(logTime[0]);
            int end = formatTime(logTime[1]);
            time[start]++;
            time[end]--;
        }

        // 개수 초기화
        for (int i = 1; i < time.length; i++) {
            time[i] += time[i - 1];
        }

        // 누적합 만들기
        for (int i = 1; i < time.length; i++) {
            time[i] += time[i - 1];
        }

        int adv = formatTime(adv_time);

        long max = time[adv - 1];
        int resultTime = 0;
        for (int i = adv; i < time.length; i++) {
            if (time[i] - time[i - adv] > max) {
                max = time[i] - time[i - adv];
                resultTime = i - adv + 1;
            }
        }

        return calTime(resultTime);
    }

    public String calTime(int time) {
        String h = String.valueOf(time / 3600);
        String m = String.valueOf(time % 3600 / 60);
        String s = String.valueOf(time % 60);
        if (h.length() == 1) h = "0" + h;
        if (m.length() == 1) m = "0" + m;
        if (s.length() == 1) s = "0" + s;
        return h + ":" + m + ":" + s;
    }

    public static int formatTime(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        return h * 3600 + m * 60 + s;
    }
}
