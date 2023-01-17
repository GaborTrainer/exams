package redlion;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RedLion {

    private String name;
    private List<Cup> cups;
    private LocalTime openTime;
    private LocalTime closeTime;

    public RedLion(String name, LocalTime openTime, LocalTime closeTime) {
        this.name = name;
        this.cups = new ArrayList<>();
        cups.add(new Cup("Kamillavirágzat", 1256, Sort.HERBAL_TEA));
        cups.add(new Cup("Cseresznyés álom", 1745, Sort.FRUIT_TEA));
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public void addCup(Cup cup) {
        cups.add(cup);
    }

    public void setActionPrices(Sort sort, int percent) {
        cups.stream().
                filter(t -> t.getSort() == sort)
                .forEach(t -> t.setPrice((int) Math.floor(t.getPrice() * (1 - (percent / 100.0)))));
    }

    public double getAveragePrice() {
        return cups.stream()
                .mapToDouble(
                        Cup::getPrice)
                .average().orElseThrow();
    }

    public String getName() {
        return name;
    }

    public List<Cup> getTeas() {
        return cups;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public static void main(String[] args) {
        Cup firstCup = new Cup("A nagyi lekvárja", 1567, Sort.FRUIT_TEA);
        Cup secondCup = new Cup("Earl Grey", 1837, Sort.BLACK_TEA);
        Cup thirdCup = new Cup("Afrikai szavanna", 2431, Sort.ROOIBOS);

        System.out.println(secondCup); // Earl Grey: élénkítő hatású (1837 Ft)

        RedLion redLion = new RedLion("Vörös oroszlán",
                LocalTime.of(11, 0, 0), LocalTime.of(22, 0, 0));
        redLion.addCup(firstCup);
        redLion.addCup(secondCup);
        redLion.addCup(thirdCup);

        System.out.println(redLion.getName()); // Vörös oroszlán
        System.out.println(redLion.getTeas().get(2).getName()); // A nagyi lekvárja
        System.out.println(redLion.getTeas().get(1).getPrice()); // 1745
        System.out.println(redLion.getOpenTime()); // 11:00
        System.out.println(redLion.getCloseTime()); // 22:00
        System.out.println(redLion.getAveragePrice()); // 1767.2

        redLion.setActionPrices(Sort.FRUIT_TEA, 30);

        System.out.println(redLion.getTeas().get(1).getPrice()); // 1221
        System.out.println(redLion.getTeas().get(2).getPrice()); // 1096
        System.out.println(redLion.getAveragePrice()); // 1568.2
    }
}
