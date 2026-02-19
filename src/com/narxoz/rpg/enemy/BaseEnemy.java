package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseEnemy implements Enemy {
    private final String name;
    private final int health;
    private final int damage;
    private final int defense;
    private final int speed;
    private final Element element;
    private final AIBehavior aiBehavior;

    private final List<Ability> abilities;
    private final LootTable lootTable;

    protected BaseEnemy(String name, int health, int damage, int defense, int speed,
                        Element element, AIBehavior aiBehavior,
                        List<Ability> abilities, LootTable lootTable) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.aiBehavior = aiBehavior;

        List<Ability> copy = new ArrayList<>();
        if (abilities != null) for (Ability a : abilities) copy.add(a.clone());
        this.abilities = Collections.unmodifiableList(copy);

        this.lootTable = (lootTable == null) ? null : lootTable.clone();
    }

    @Override public String getName() { return name; }
    @Override public int getHealth() { return health; }
    @Override public int getDamage() { return damage; }
    @Override public int getDefense() { return defense; }
    @Override public int getSpeed() { return speed; }
    @Override public Element getElement() { return element; }
    @Override public AIBehavior getAiBehavior() { return aiBehavior; }

    @Override public List<Ability> getAbilities() { return abilities; }
    @Override public LootTable getLootTable() { return lootTable == null ? null : lootTable.clone(); }

    protected String baseInfo() {
        return "Name=" + name +
                ", HP=" + health +
                ", DMG=" + damage +
                ", DEF=" + defense +
                ", SPD=" + speed +
                ", Element=" + element +
                ", AI=" + aiBehavior;
    }

    @Override
    public abstract Enemy clone();
}
