package lotto;

import java.util.ArrayList;

public class LottoAwardPresenter {
    private class AwardTuple {
        private final Award award;
        private final Integer reward;
        private final String presentSting;

        public AwardTuple(Award award, Integer reward, String presentSting) {
            this.award = award;
            this.reward = reward;
            this.presentSting = presentSting;
        }

        public Award getAward() {
            return award;
        }

        public Integer getReward() {
            return reward;
        }

        public String getPresentString() {
            return presentSting;
        }
    }

    private final ArrayList<AwardTuple> awardTupleList;

    public LottoAwardPresenter() {
        awardTupleList = new ArrayList<>();
        createAwardString();
    }

    private void createAwardString() {
        awardTupleList.add(new AwardTuple(Award.Score3, 5000, "3개 일치 (5,000원)"));
        awardTupleList.add(new AwardTuple(Award.Score4, 50000, "4개 일치 (50,000원)"));
        awardTupleList.add(new AwardTuple(Award.Score5, 1500000, "5개 일치 (1,500,000원)"));
        awardTupleList.add(new AwardTuple(Award.Score5AndBonus, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"));
        awardTupleList.add(new AwardTuple(Award.Score6, 2000000000, "6개 일치 (2,000,000,000원)"));
    }

    public void printAwardAndProfitRate(LottoAward lottoAward, int playerCash) {
        long reward = 0;

        for (AwardTuple tuple : awardTupleList) {
            System.out.printf("%s - %d개\n", tuple.getPresentString(), lottoAward.getAwardCount(tuple.getAward()));
            reward += (long) lottoAward.getAwardCount(tuple.getAward()) * tuple.getReward();
        }

        double profitRate = (double) reward / playerCash * 100;

        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}
