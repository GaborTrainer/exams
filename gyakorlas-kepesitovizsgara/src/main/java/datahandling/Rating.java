package datahandling;

public class Rating {

    private long id;

    private String nickname;

    private int month;

    private int taskNr;

    private int ratingValue;

    public Rating(String nickname, int month, int taskNr, int ratingValue) {
        this.nickname = nickname;
        this.month = month;
        this.taskNr = taskNr;
        this.ratingValue = ratingValue;
    }

    public Rating(long id, String nickname, int month, int taskNr, int ratingValue) {
        this.id = id;
        this.nickname = nickname;
        this.month = month;
        this.taskNr = taskNr;
        this.ratingValue = ratingValue;
    }

    public boolean isValid(){
        if (nickname == null) {
            return false;
        }
        if (month < 1 || month > 12 || month == 7 || month == 8){
            return false;
        }
        if (taskNr < 1 || taskNr > 10) {
            return false;
        }
        return ratingValue >= 0 && ratingValue <= 10;
    }

    public long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public int getMonth() {
        return month;
    }

    public int getTaskNr() {
        return taskNr;
    }

    public int getRatingValue() {
        return ratingValue;
    }
}
