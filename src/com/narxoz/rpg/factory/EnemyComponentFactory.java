package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.AIBehavior;
import com.narxoz.rpg.enemy.Element;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

public interface EnemyComponentFactory {
    Element getElement();
    AIBehavior createAIBehavior();
    List<Ability> createAbilities();
    LootTable createLootTable();
}
