package datahandling;

import java.util.Map;

public class RatingService {

    private RatingRepository repository;

    public RatingService(RatingRepository repository) {
        this.repository = repository;
    }

    public long save(Rating rating) {
        if (!rating.isValid()) {
            return -1L;
        }
        int month = rating.getMonth();
        boolean reachedAchieveInPreviousMonth = true;
        if (month != 9 && month != 1) {
            reachedAchieveInPreviousMonth = repository.getMonthFullScore(rating.getNickname(), month - 1) > 0;
        }
        if (month == 1) {
            reachedAchieveInPreviousMonth = repository.getMonthFullScore(rating.getNickname(), 12) > 0;
        }

        if (!reachedAchieveInPreviousMonth) {
            return -1L;
        }
        return repository.save(rating);
    }

    public Map<String, Integer> getRatingsByTask(int month, int taskNr) {
        return repository.getRatingsByTask(month, taskNr);
    }

    public String getRatingsByTaskAsCsv(int month, int taskNr) {
        Map<String, Integer> resultMap = repository.getRatingsByTask(month, taskNr);
        StringBuilder result = new StringBuilder();
        result.append("NAME;POINTS");
        for (Map.Entry<String, Integer> actual : resultMap.entrySet()) {
            result.append("\n").append(actual.getKey()).append(";").append(actual.getValue());
        }
        return result.toString();
    }

    public int getMonthFullScore(String nickname, int month) {
        return repository.getMonthFullScore(nickname, month);
    }
}
