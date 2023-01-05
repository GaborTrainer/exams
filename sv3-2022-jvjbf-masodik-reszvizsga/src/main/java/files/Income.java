package files;

import java.time.LocalDate;

public class Income {

    private LocalDate date;

    private int money;

    public Income(LocalDate date, int money) {
        this.date = date;
        this.money = money;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getMoney() {
        return money;
    }
}
