package lotto;

import java.util.HashMap;

public class LottoAward {
    private final HashMap<Award, Integer> awardHashMap;

    public LottoAward() {
        awardHashMap = new HashMap<>();
        for (Award award : Award.values()) {
            awardHashMap.put(award, 0);
        }
    }

    public void updateAward(LottoScore lottoScore) {
        Award award = getAwardByScore(lottoScore);
        int count = awardHashMap.get(award);
        awardHashMap.replace(award, count + 1);
    }

    private Award getAwardByScore(LottoScore lottoScore) {
        int score = lottoScore.getScore();

        // TODO: 단순 if로 나열한 비즈니스 로직 해결해보기
        if (score == 6) {
            return Award.Score6;
        }
        if (score == 5 && lottoScore.hasBonus()) {
            return Award.Score5AndBonus;
        }
        if (score == 5) {
            return Award.Score5;
        }
        if (score == 4) {
            return Award.Score4;
        }
        return Award.Score3;
    }

    public Integer getAwardCount(Award award) {
        return awardHashMap.get(award);
    }
}
