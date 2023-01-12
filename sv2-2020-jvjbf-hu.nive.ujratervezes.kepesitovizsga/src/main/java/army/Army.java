package army;

import java.util.ArrayList;
import java.util.List;

class Army {
    private final List<MilitaryUnit> units = new ArrayList<>();

    public void addUnit(MilitaryUnit militaryUnit) {
        units.add(militaryUnit);
    }

    public void damageAll(int damage) {
        units.forEach(unit -> unit.sufferDamage(damage));
        units.removeIf(unit -> unit.getHitPoints() < 25);
    }

    public int getArmyDamage() {
        return units.stream()
                .mapToInt(MilitaryUnit::doDamage)
                .sum();
    }

    public int getArmySize() {
        return units.size();
    }
}
