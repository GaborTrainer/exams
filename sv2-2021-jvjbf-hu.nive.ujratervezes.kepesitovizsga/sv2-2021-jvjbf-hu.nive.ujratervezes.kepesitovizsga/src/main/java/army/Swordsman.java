package army;

class Swordsman extends MilitaryUnit {

    private boolean shieldBroken = false;

    public Swordsman(boolean hasArmor) {
        hitPoints = 100;
        damage = 10;
        this.hasArmor = hasArmor;
    }

    @Override
    public int doDamage() {
        return damage;
    }

    @Override
    public void sufferDamage(int damage) {
        if (!shieldBroken) {
            shieldBroken = true;
        } else {
            super.sufferDamage(damage);
        }
    }
}