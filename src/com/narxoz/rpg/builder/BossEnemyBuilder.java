package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import java.util.LinkedHashMap;
import java.util.Map;

public class BossEnemyBuilder extends AbstractEnemyBuilder {
    private final Map<Integer, Integer> phases = new LinkedHashMap<>();

    @Override
    public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        phases.put(phaseNumber, healthThreshold);
        return this;
    }

    @Override
    public EnemyBuilder reset() {
        super.reset();
        phases.clear();
        return this;
    }

    // ✅ FIX: копируем phases, если Enemy = boss
    public BossEnemyBuilder from(Enemy e) {
        super.from(e);
        phases.clear();

        if (e != null && e.isBoss() && e.getPhases() != null) {
            phases.putAll(e.getPhases());
        }
        return this;
    }

    private void validateBoss() {
        validateCommon();
        if (phases.isEmpty()) throw new IllegalStateException("Boss must have at least 1 phase");
    }

    @Override
    public Enemy build() {
        validateBoss();

        if (name.toLowerCase().contains("dragon")) {
            return new DragonBoss(name, health, damage, defense, speed, element, aiBehavior, abilities, lootTable, phases);
        }
        return new BossEnemy(name, health, damage, defense, speed, element, aiBehavior, abilities, lootTable, phases);
    }
}
