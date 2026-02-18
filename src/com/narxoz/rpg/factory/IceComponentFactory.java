package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.ice.Blizzard;
import com.narxoz.rpg.combat.ice.FrostBreath;
import com.narxoz.rpg.combat.ice.IceShield;
import com.narxoz.rpg.enemy.AIBehavior;
import com.narxoz.rpg.enemy.Element;
import com.narxoz.rpg.loot.IceLootTable;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

public class IceComponentFactory implements EnemyComponentFactory {
    @Override public Element getElement() { return Element.ICE; }
    @Override public AIBehavior createAIBehavior() { return AIBehavior.DEFENSIVE; }

    @Override
    public List<Ability> createAbilities() {
        return List.of(new FrostBreath(), new IceShield(), new Blizzard());
    }

    @Override
    public LootTable createLootTable() {
        return new IceLootTable();
    }
}
