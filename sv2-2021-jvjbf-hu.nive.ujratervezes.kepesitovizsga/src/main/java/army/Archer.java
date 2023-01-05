package army;

class Archer extends MilitaryUnit {
    public Archer() {
        hitPoints = 50;
        damage = 20;
        hasArmor = false;
    }

    @Override
    public int doDamage() {
        return damage;
    }
}