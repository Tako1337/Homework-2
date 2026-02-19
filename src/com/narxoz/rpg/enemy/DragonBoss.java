package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;
import java.util.Map;

public class DragonBoss extends BossEnemy {
    public DragonBoss(String name, int health, int damage, int defense, int speed,
                      Element element, AIBehavior aiBehavior, List<Ability> abilities, LootTable lootTable,
                      Map<Integer, Integer> phases) {
        super(name, health, damage, defense, speed, element, aiBehavior, abilities, lootTable, phases);
    }

    @Override
    public Enemy clone() {
        return new DragonBoss(
                getName(), getHealth(), getDamage(), getDefense(), getSpeed(),
                getElement(), getAiBehavior(), getAbilities(), getLootTable(),
                getPhases()
        );
    }
}
