package com.narxoz.rpg.builder;

import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {

    public void createMinion(EnemyBuilder builder, EnemyComponentFactory factory) {
        builder.reset()
                .setName(factory.getElement() + " Goblin")
                .setHealth(120)
                .setDamage(15)
                .setDefense(6)
                .setSpeed(35)
                .setElement(factory.getElement())
                .setAI(factory.createAIBehavior())
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable());
    }

    public void createElite(EnemyBuilder builder, EnemyComponentFactory factory) {
        builder.reset()
                .setName("Elite " + factory.getElement() + " Goblin")
                .setHealth(250)
                .setDamage(35)
                .setDefense(15)
                .setSpeed(40)
                .setElement(factory.getElement())
                .setAI(factory.createAIBehavior())
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable());
    }

    public void createMiniBoss(EnemyBuilder builder, EnemyComponentFactory factory) {
        builder.reset()
                .setName(factory.getElement() + " Mini Boss")
                .setHealth(1200)
                .setDamage(80)
                .setDefense(40)
                .setSpeed(30)
                .setElement(factory.getElement())
                .setAI(factory.createAIBehavior())
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .addPhase(1, 70)
                .addPhase(2, 35);
    }

    public void createRaidBoss(EnemyBuilder builder, EnemyComponentFactory factory) {
        builder.reset()
                .setName(factory.getElement() + " Ancient Dragon")
                .setHealth(50000)
                .setDamage(500)
                .setDefense(200)
                .setSpeed(50)
                .setElement(factory.getElement())
                .setAI(factory.createAIBehavior())
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .addPhase(1, 75)
                .addPhase(2, 50)
                .addPhase(3, 25);
    }
}
