package guinness;

import java.util.*;

public class GuinnessRecord {

    private String recordName;

    private RecordType recordType;

    private int bestAttempt;

    private Map<Recorder, List<Integer>> attempts = new HashMap<>();

    private Recorder bestRecordHolder;

    private GuinnessRecord(String recordName, RecordType recordType, int bestAttempt) {
        this.recordName = recordName;
        this.recordType = recordType;
        this.bestAttempt = bestAttempt;
    }

    static GuinnessRecord createGuinnessRecord(String recordName, RecordType recordType) {
        if (recordType.equals(RecordType.QUANTITY)) {
            return new GuinnessRecord(recordName, recordType, 0);
        } else {
            return new GuinnessRecord(recordName, recordType, Integer.MAX_VALUE);
        }
    }

    public boolean tryBeatRecord(int amount, Recorder recorder){
        if (attempts.containsKey(recorder)){
            attempts.get(recorder).add(amount);
        } else {
            attempts.put(recorder,new ArrayList<>(List.of(amount)));
        }
        if (recordType==RecordType.TIME && bestAttempt>amount){
            bestAttempt = amount;
            bestRecordHolder = recorder;
            return true;
        }
        if (recordType==RecordType.QUANTITY && bestAttempt<amount){
            bestAttempt = amount;
            bestRecordHolder = recorder;
            return true;
        }
        return false;
    }

    public Recorder findRecordHolder() {
        if (this.bestRecordHolder==null){
            throw new RecordHasNoAttemptsException("No attempts yet!");
        }
        return this.bestRecordHolder;
    }

    public List<String> getOrderedRecorderNames() {
        return attempts.keySet().stream()
                .map(Recorder::getName)
                .sorted()
                .toList();
    }

    @Override
    public String toString() {
        return "GuinnessRecord{" +
                "recordName='" + getRecordName() + "'" +
                ", recordType=" + getRecordType() +
                ", maxAmount=" + getBestAttempt() + " " + getRecordType().getMeasure();
    }

    public String getRecordName() {
        return recordName;
    }

    public RecordType getRecordType() {
        return recordType;
    }

    public int getBestAttempt() {
        return bestAttempt;
    }

    public Map<Recorder, List<Integer>> getAttempts() {
        return attempts;
    }
}
