package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MinionEnemy extends BaseEnemy {

    public MinionEnemy(String name, int health, int damage, int defense, int speed,
                       Element element, AIBehavior aiBehavior, List<Ability> abilities, LootTable lootTable) {
        super(name, health, damage, defense, speed, element, aiBehavior, abilities, lootTable);
    }

    @Override public boolean isBoss() { return false; }

    @Override
    public Map<Integer, Integer> getPhases() {
        return Collections.emptyMap();
    }

    @Override
    public Enemy clone() {
        return new MinionEnemy(
                getName(), getHealth(), getDamage(), getDefense(), getSpeed(),
                getElement(), getAiBehavior(), getAbilities(), getLootTable()
        );
    }

    @Override
    public String describe() {
        return "[MINION] " + baseInfo() +
                "\n  Abilities=" + getAbilities() +
                "\n  Loot=" + getLootTable();
    }
}
