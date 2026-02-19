package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BossEnemy extends BaseEnemy {
    private final Map<Integer, Integer> phases;

    public BossEnemy(String name, int health, int damage, int defense, int speed,
                     Element element, AIBehavior aiBehavior, List<Ability> abilities, LootTable lootTable,
                     Map<Integer, Integer> phases) {
        super(name, health, damage, defense, speed, element, aiBehavior, abilities, lootTable);
        this.phases = phases == null ? Map.of() : Collections.unmodifiableMap(new LinkedHashMap<>(phases));
    }

    @Override public boolean isBoss() { return true; }

    @Override
    public Map<Integer, Integer> getPhases() {
        return phases;
    }

    @Override
    public Enemy clone() {
        return new BossEnemy(
                getName(), getHealth(), getDamage(), getDefense(), getSpeed(),
                getElement(), getAiBehavior(), getAbilities(), getLootTable(),
                new LinkedHashMap<>(getPhases())
        );
    }

    @Override
    public String describe() {
        return "[BOSS] " + baseInfo() +
                "\n  Phases=" + phases +
                "\n  Abilities=" + getAbilities() +
                "\n  Loot=" + getLootTable();
    }
}
