package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;

public class Goblin extends MinionEnemy {
    public Goblin(String name, int health, int damage, int defense, int speed,
                  Element element, AIBehavior aiBehavior, List<Ability> abilities, LootTable lootTable) {
        super(name, health, damage, defense, speed, element, aiBehavior, abilities, lootTable);
    }

    @Override
    public Enemy clone() {
        return new Goblin(
                getName(), getHealth(), getDamage(), getDefense(), getSpeed(),
                getElement(), getAiBehavior(), getAbilities(), getLootTable()
        );
    }
}
