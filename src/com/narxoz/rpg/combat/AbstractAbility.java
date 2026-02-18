package com.narxoz.rpg.combat;

public abstract class AbstractAbility implements Ability {
    private final String name;
    private final int damage;
    private final String description;

    protected AbstractAbility(String name, int damage, String description) {
        this.name = name;
        this.damage = damage;
        this.description = description;
    }

    @Override public String getName() { return name; }
    @Override public int getDamage() { return damage; }
    @Override public String getDescription() { return description; }

    @Override
    public Ability clone() {
        try {
            return (Ability) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Ability clone failed", e);
        }
    }

    @Override
    public String toString() {
        return name + " (DMG " + damage + "): " + description;
    }
}
