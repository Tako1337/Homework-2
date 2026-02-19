package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.enemy.MinionEnemy;

public class BasicEnemyBuilder extends AbstractEnemyBuilder {

    @Override
    public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        return this;
    }

    @Override
    public Enemy build() {
        validateCommon();

        if (name.toLowerCase().contains("goblin")) {
            return new Goblin(name, health, damage, defense, speed, element, aiBehavior, abilities, lootTable);
        }
        return new MinionEnemy(name, health, damage, defense, speed, element, aiBehavior, abilities, lootTable);
    }
}


