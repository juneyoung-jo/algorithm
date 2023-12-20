package programmers;

public class 바탕화면정리 {

    public int[] solution(String[] wallpaper) {
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rux = 0;
        int ruy = 0;

        for (int r = 0; r < wallpaper.length; r++) {
            for (int c = 0; c < wallpaper[r].length(); c++) {
                if (wallpaper[r].charAt(c) == '#') {
                    lux = Math.min(lux, r);
                    luy = Math.min(luy, c);
                    rux = Math.max(rux, r + 1);
                    ruy = Math.max(ruy, c + 1);
                }
            }
        }
        int[] answer = {lux, luy, rux, ruy};
        return answer;
    }
}
