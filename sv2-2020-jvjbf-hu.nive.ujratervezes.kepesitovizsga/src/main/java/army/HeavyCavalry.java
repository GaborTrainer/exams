package army;

class HeavyCavalry extends MilitaryUnit {
    private int attackNumber = 0;

    public HeavyCavalry() {
        hitPoints = 150;
        damage = 20;
        hasArmor = true;
    }

    @Override
    public int doDamage() {
        attackNumber++;
        return damage * (attackNumber == 1 ? 3 : 1);
    }
}