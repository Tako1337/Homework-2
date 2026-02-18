package com.narxoz.rpg.loot;

import java.util.List;

public class IceLootTable extends AbstractLootTable {
    public IceLootTable() {
        super(List.of("Ice Gem", "Frost Scale", "Ice Rune"), 220, 380);
    }

    private IceLootTable(List<String> items, int gold, int xp) {
        super(items, gold, xp);
    }

    @Override
    protected LootTable recreate(List<String> items, int gold, int xp) {
        return new IceLootTable(items, gold, xp);
    }
}
