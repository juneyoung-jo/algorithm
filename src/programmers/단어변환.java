package programmers;

import java.util.*;

public class 단어변환 {
    static Set<String> set = new HashSet<>();

    static class Point {
        String word;
        int cnt;

        Point(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }

    int bfs(String begin, String target, String[] words) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(begin, 0));

        Point p = null;
        while (!q.isEmpty()) {
            p = q.poll();

            if (p.word.equals(target)) return p.cnt;

            for (String word : words) {
                if (!check(p.word, word) || set.contains(p.word + word)) continue;
                set.add(p.word + word);
                q.add(new Point(word, p.cnt + 1));
            }
        }

        return 0;
    }

    boolean check(String changeWord, String word) {
        int count = 0;
        for (int i = 0; i < changeWord.length(); i++) {
            if (changeWord.charAt(i) != word.charAt(i)) count++;
            if (count > 1) return false;
        }

        return true;
    }
}