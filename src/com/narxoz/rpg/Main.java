package com.narxoz.rpg;

import com.narxoz.rpg.builder.*;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.shadow.ShadowStrike;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.*;
import com.narxoz.rpg.prototype.EnemyRegistry;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== HW2: RPG Enemy System (Builder + Prototype + Abstract Factory + Factory Method) ===\n");

        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        EnemyDirector director = new EnemyDirector();
        EnemyBuilder basicBuilder = new BasicEnemyBuilder();
        EnemyBuilder bossBuilder = new BossEnemyBuilder();

        EnemyRegistry registry = new EnemyRegistry();

        director.createMinion(basicBuilder, fireFactory);
        Enemy fireGoblinBase = basicBuilder.build();
        registry.registerTemplate("goblin-fire-base", fireGoblinBase);

        director.createMinion(basicBuilder, iceFactory);
        Enemy iceGoblinBase = basicBuilder.build();
        registry.registerTemplate("goblin-ice-base", iceGoblinBase);

        director.createRaidBoss(bossBuilder, shadowFactory);
        Enemy shadowDragonBase = bossBuilder.build();
        registry.registerTemplate("dragon-shadow-base", shadowDragonBase);

        System.out.println("Templates in registry: " + registry.listTemplates() + "\n");

        Enemy eliteFireGoblin = makeScaledVariant(
                registry.createFromTemplate("goblin-fire-base"),
                new BasicEnemyBuilder(),
                "Elite Fire Goblin",
                2.0,
                null
        );

        Enemy championIceGoblin = makeScaledVariant(
                registry.createFromTemplate("goblin-ice-base"),
                new BasicEnemyBuilder(),
                "Champion Ice Goblin",
                5.0,
                List.of(new ShadowStrike())
        );

        Enemy hardShadowDragon = makeScaledVariant(
                registry.createFromTemplate("dragon-shadow-base"),
                new BossEnemyBuilder(),
                "Shadow Ancient Dragon (Hard)",
                1.3,
                null
        );

        System.out.println("--- Base Template: goblin-fire-base ---");
        System.out.println(registry.createFromTemplate("goblin-fire-base").describe() + "\n");

        System.out.println("--- Variant: Elite Fire Goblin (x2 stats) ---");
        System.out.println(eliteFireGoblin.describe() + "\n");

        System.out.println("--- Variant: Champion Ice Goblin (x5 stats + extra ability) ---");
        System.out.println(championIceGoblin.describe() + "\n");

        System.out.println("--- Base Template: dragon-shadow-base ---");
        System.out.println(registry.createFromTemplate("dragon-shadow-base").describe() + "\n");

        System.out.println("--- Variant: Shadow Ancient Dragon (Hard) ---");
        System.out.println(hardShadowDragon.describe() + "\n");

        System.out.println("=== Deep Copy Proof ===");
        Enemy cloned = registry.createFromTemplate("goblin-fire-base");

        Enemy modifiedClone = makeScaledVariant(
                cloned,
                new BasicEnemyBuilder(),
                "Modified Clone Goblin",
                1.0,
                List.of(new ShadowStrike())
        );

        Enemy originalAgain = registry.createFromTemplate("goblin-fire-base");

        System.out.println("Original template abilities count: " + originalAgain.getAbilities().size());
        System.out.println("Modified clone abilities count:   " + modifiedClone.getAbilities().size());
        System.out.println("If counts differ -> deep copy works ✅");
    }

    private static Enemy makeScaledVariant(Enemy baseClone,
                                          AbstractEnemyBuilder builder,
                                          String newName,
                                          double multiplier,
                                          List<Ability> extraAbilities) {

        int hp = (int) Math.round(baseClone.getHealth() * multiplier);
        int dmg = (int) Math.round(baseClone.getDamage() * multiplier);
        int def = (int) Math.round(baseClone.getDefense() * multiplier);
        int spd = baseClone.getSpeed();

        builder.from(baseClone)
                .setName(newName)
                .setHealth(hp)
                .setDamage(dmg)
                .setDefense(def)
                .setSpeed(spd);

        if (extraAbilities != null && !extraAbilities.isEmpty()) {
            List<Ability> merged = new ArrayList<>(baseClone.getAbilities());
            merged.addAll(extraAbilities);
            builder.setAbilities(merged);
        }

        return builder.build();
    }
}
