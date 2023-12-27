package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 달리기경주 {

    public List<String> solution(String[] players, String[] callings) {
        HashMap<Integer, String> playerMap = new HashMap();
        HashMap<String, Integer> rankMap = new HashMap();

        for (int i = 0; i < players.length; i++) {
            playerMap.put(i, players[i]);
            rankMap.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            int rank = rankMap.get(callings[i]);
            String player = playerMap.get(rank);

            // 이전 등수 player
            String previousPlayer = playerMap.get(rank - 1);

            // calling player 등수 변경
            rankMap.put(player, rank - 1);
            playerMap.put(rank - 1, player);

            // 이전 등수 player 등수 변경
            rankMap.put(previousPlayer, rank);
            playerMap.put(rank, previousPlayer);
        }

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < players.length; i++) {
            answer.add(i, playerMap.get(i));
        }

        return answer;
    }
}
