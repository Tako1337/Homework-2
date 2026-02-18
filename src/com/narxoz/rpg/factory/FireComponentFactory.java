package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.fire.FireShield;
import com.narxoz.rpg.combat.fire.FlameBreath;
import com.narxoz.rpg.combat.fire.MeteorStorm;
import com.narxoz.rpg.enemy.AIBehavior;
import com.narxoz.rpg.enemy.Element;
import com.narxoz.rpg.loot.FireLootTable;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

public class FireComponentFactory implements EnemyComponentFactory {
    @Override public Element getElement() { return Element.FIRE; }
    @Override public AIBehavior createAIBehavior() { return AIBehavior.AGGRESSIVE; }

    @Override
    public List<Ability> createAbilities() {
        return List.of(new FlameBreath(), new FireShield(), new MeteorStorm());
    }

    @Override
    public LootTable createLootTable() {
        return new FireLootTable();
    }
}
