package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;
import java.util.Map;

public interface Enemy extends Cloneable {
    String getName();
    int getHealth();
    int getDamage();
    int getDefense();
    int getSpeed();
    Element getElement();
    AIBehavior getAiBehavior();

    List<Ability> getAbilities();
    LootTable getLootTable();

    boolean isBoss();
    Map<Integer, Integer> getPhases();

    Enemy clone();
    String describe();
}
