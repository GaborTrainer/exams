package teahouse;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TeaHouse {

    private String name;
    private List<Tea> teas;
    private LocalTime openTime;
    private LocalTime closeTime;

    public TeaHouse(String name, LocalTime openTime, LocalTime closeTime) {
        this.name = name;
        this.teas = new ArrayList<>();
        teas.add(new Tea("Kamillavirágzat", 1256, Sort.HERBAL_TEA));
        teas.add(new Tea("Cseresznyés álom", 1745, Sort.FRUIT_TEA));
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public void addTea(Tea tea) {
        teas.add(tea);
    }

    public void setActionPrices(Sort sort, int percent) {
        teas.stream().
                filter(t -> t.getSort() == sort)
                .forEach(t -> t.setPrice((int) Math.floor(t.getPrice() * (1 - (percent / 100.0)))));
    }

    public double getAveragePrice() {
        return teas.stream()
                .mapToDouble(Tea::getPrice)
                .average().orElseThrow();
    }

    public String getName() {
        return name;
    }

    public List<Tea> getTeas() {
        return teas;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public static void main(String[] args) {
        Tea firstTea = new Tea("A nagyi lekvárja", 1567, Sort.FRUIT_TEA);
        Tea secondTea = new Tea("Earl Grey", 1837, Sort.BLACK_TEA);
        Tea thirdTea = new Tea("Afrikai szavanna", 2431, Sort.ROOIBOS);

        System.out.println(secondTea); // Earl Grey: élénkítő hatású (1837 Ft)

        TeaHouse teaHouse = new TeaHouse("Vörös oroszlán",
                LocalTime.of(11, 0, 0), LocalTime.of(22, 0, 0));
        teaHouse.addTea(firstTea);
        teaHouse.addTea(secondTea);
        teaHouse.addTea(thirdTea);

        System.out.println(teaHouse.getName()); // Vörös oroszlán
        System.out.println(teaHouse.getTeas().get(2).getName()); // A nagyi lekvárja
        System.out.println(teaHouse.getTeas().get(1).getPrice()); // 1745
        System.out.println(teaHouse.getOpenTime()); // 11:00
        System.out.println(teaHouse.getCloseTime()); // 22:00
        System.out.println(teaHouse.getAveragePrice()); // 1767.2

        teaHouse.setActionPrices(Sort.FRUIT_TEA, 30);

        System.out.println(teaHouse.getTeas().get(1).getPrice()); // 1221
        System.out.println(teaHouse.getTeas().get(2).getPrice()); // 1096
        System.out.println(teaHouse.getAveragePrice()); // 1568.2
    }
}
