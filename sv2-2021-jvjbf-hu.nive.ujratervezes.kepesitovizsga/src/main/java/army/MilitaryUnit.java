package army;

abstract class MilitaryUnit {
    protected int hitPoints;
    protected int damage;
    protected boolean hasArmor;

    public abstract int doDamage();

    public void sufferDamage(int damage) {
        if (hasArmor) {
            hitPoints -= damage / 2;
        } else {
            hitPoints -= damage;
        }
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isHasArmor() {
        return hasArmor;
    }
}