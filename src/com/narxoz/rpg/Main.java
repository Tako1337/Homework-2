package com.narxoz.rpg;

import com.narxoz.rpg.factory.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== HW2 Commit 1 Demo: Abstract Factory ===\n");

        EnemyComponentFactory[] factories = {
                new FireComponentFactory(),
                new IceComponentFactory(),
                new ShadowComponentFactory()
        };

        for (EnemyComponentFactory f : factories) {
            System.out.println("Theme: " + f.getElement());
            System.out.println("AI: " + f.createAIBehavior());
            System.out.println("Abilities: " + f.createAbilities());
            System.out.println("Loot: " + f.createLootTable());
            System.out.println("---");
        }
    }
}
