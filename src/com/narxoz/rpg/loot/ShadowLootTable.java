package com.narxoz.rpg.loot;

import java.util.List;

public class ShadowLootTable extends AbstractLootTable {
    public ShadowLootTable() {
        super(List.of("Shadow Gem", "Dark Essence", "Shadow Rune"), 260, 420);
    }

    private ShadowLootTable(List<String> items, int gold, int xp) {
        super(items, gold, xp);
    }

    @Override
    protected LootTable recreate(List<String> items, int gold, int xp) {
        return new ShadowLootTable(items, gold, xp);
    }
}
