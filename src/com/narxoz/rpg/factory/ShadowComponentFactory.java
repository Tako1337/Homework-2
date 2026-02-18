package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.shadow.DarkNova;
import com.narxoz.rpg.combat.shadow.ShadowStrike;
import com.narxoz.rpg.combat.shadow.Vanish;
import com.narxoz.rpg.enemy.AIBehavior;
import com.narxoz.rpg.enemy.Element;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.loot.ShadowLootTable;

import java.util.List;

public class ShadowComponentFactory implements EnemyComponentFactory {
    @Override public Element getElement() { return Element.SHADOW; }
    @Override public AIBehavior createAIBehavior() { return AIBehavior.TACTICAL; }

    @Override
    public List<Ability> createAbilities() {
        return List.of(new ShadowStrike(), new Vanish(), new DarkNova());
    }

    @Override
    public LootTable createLootTable() {
        return new ShadowLootTable();
    }
}

