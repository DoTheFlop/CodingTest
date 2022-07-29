import java.util.*;

class UserSolution {

    HashMap<Integer, soldier> army2;
    int best;

    class soldier {
        int mId;
        int mTeam;
        int mScore;

        public soldier(int mId, int mTeam, int mScore) {
            this.mId = mId;
            this.mTeam = mTeam;
            this.mScore = mScore;
        }

        public void setmScore(int mScore) {
            this.mScore = mScore;
        }
    }

    public void init() {
        army2 = new HashMap<>();
    }

    public void hire(int mID, int mTeam, int mScore) {
        army2.put(mID, new soldier(mID, mTeam, mScore));
    }

    public void fire(int mID) {
        army2.remove(mID);
    }

    public void updateSoldier(int mID, int mScore) {
        soldier temp = army2.get(mID);
        army2.replace(mID, new soldier(mID, temp.mTeam, mScore));
    }

    public void updateTeam(int mTeam, int mChangeScore) {
        for (Map.Entry<Integer, soldier> entry : army2.entrySet()) {
            if (entry.getValue().mTeam == mTeam) {
                soldier temp = entry.getValue();
                int score = temp.mScore;
                score += mChangeScore;
                if (score < 1) score = 1;
                if (score > 5) score = 5;
                temp.setmScore(score);
                entry.setValue(temp);
            }
        }
    }

    public int bestSoldier(int mTeam) {
        best = 0;
        int result = 0;

        for (Map.Entry<Integer, soldier> entry : army2.entrySet()) {
            if (entry.getValue().mTeam == mTeam) {
                if (entry.getValue().mScore > best) {
                    best = entry.getValue().mScore;
                    result = entry.getKey();
                } else if (entry.getValue().mScore == best) {
                    if (result < entry.getKey()) {
                        result = entry.getKey();
                    }
                }
            }
        }
        return result;
    }
}