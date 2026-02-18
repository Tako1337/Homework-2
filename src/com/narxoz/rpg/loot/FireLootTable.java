package com.narxoz.rpg.loot;

import java.util.List;

public class FireLootTable extends AbstractLootTable {
    public FireLootTable() {
        super(List.of("Fire Gem", "Dragon Scale", "Flame Rune"), 250, 400);
    }

    private FireLootTable(List<String> items, int gold, int xp) {
        super(items, gold, xp);
    }

    @Override
    protected LootTable recreate(List<String> items, int gold, int xp) {
        return new FireLootTable(items, gold, xp);
    }
}
