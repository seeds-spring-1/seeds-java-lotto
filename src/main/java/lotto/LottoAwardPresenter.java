package lotto;

import org.assertj.core.groups.Tuple;

import java.util.HashMap;
import java.util.Map;

public class LottoAwardPresenter {
    private class AwardTuple {
        private final Integer reward;
        private final String presentSting;

        public AwardTuple(Integer reward, String presentSting) {
            this.reward = reward;
            this.presentSting = presentSting;
        }

        public Integer getReward() {
            return reward;
        }

        public String getPresentString() {
            return presentSting;
        }
    }

    private final HashMap<Award, AwardTuple> awardStringHashMap;

    public LottoAwardPresenter() {
        awardStringHashMap = new HashMap<>();
        createAwardString();
    }

    private void createAwardString() {
        awardStringHashMap.put(Award.Score3, new AwardTuple(5000, "3개 일치 (5,000원)"));
        awardStringHashMap.put(Award.Score4, new AwardTuple(50000, "4개 일치 (50,000원)"));
        awardStringHashMap.put(Award.Score5, new AwardTuple(1500000, "5개 일치 (1,500,000원)"));
        awardStringHashMap.put(Award.Score5AndBonus, new AwardTuple(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"));
        awardStringHashMap.put(Award.Score6, new AwardTuple(2000000000, "6개 일치 (2,000,000,000원)"));
    }

    public void printAwardAndProfitRate(LottoAward lottoAward) {
        long reward = 0;

        for (Map.Entry<Award, AwardTuple> entry : awardStringHashMap.entrySet()) {
            Award award = entry.getKey();
            AwardTuple tuple = entry.getValue();
            System.out.printf("%s - %d개\n", tuple.getPresentString(), lottoAward.getAwardCount(award));
            reward += tuple.getReward();
        }

        double profitRate = (double) reward / lottoAward.getGameCount();

        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}
