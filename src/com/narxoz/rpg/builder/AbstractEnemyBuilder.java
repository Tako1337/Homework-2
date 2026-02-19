package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.AIBehavior;
import com.narxoz.rpg.enemy.Element;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEnemyBuilder implements EnemyBuilder {
    protected String name;
    protected Integer health;
    protected Integer damage;
    protected Integer defense;
    protected Integer speed;
    protected Element element = Element.NONE;
    protected AIBehavior aiBehavior = AIBehavior.TACTICAL;
    protected final List<Ability> abilities = new ArrayList<>();
    protected LootTable lootTable;

    @Override public EnemyBuilder setName(String name) { this.name = name; return this; }
    @Override public EnemyBuilder setHealth(int health) { this.health = health; return this; }
    @Override public EnemyBuilder setDamage(int damage) { this.damage = damage; return this; }
    @Override public EnemyBuilder setDefense(int defense) { this.defense = defense; return this; }
    @Override public EnemyBuilder setSpeed(int speed) { this.speed = speed; return this; }
    @Override public EnemyBuilder setElement(Element element) { this.element = element; return this; }
    @Override public EnemyBuilder setAI(AIBehavior aiBehavior) { this.aiBehavior = aiBehavior; return this; }

    @Override
    public EnemyBuilder addAbility(Ability ability) {
        if (ability != null) abilities.add(ability);
        return this;
    }

    @Override
    public EnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities.clear();
        if (abilities != null) this.abilities.addAll(abilities);
        return this;
    }

    @Override
    public EnemyBuilder setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
        return this;
    }

    protected void validateCommon() {
        if (name == null || name.isBlank()) throw new IllegalStateException("Name is required");
        if (health == null || health <= 0) throw new IllegalStateException("Health must be positive");
        if (damage == null || damage < 0) throw new IllegalStateException("Damage must be >= 0");
        if (defense == null || defense < 0) throw new IllegalStateException("Defense must be >= 0");
        if (speed == null || speed < 0) throw new IllegalStateException("Speed must be >= 0");
        if (lootTable == null) throw new IllegalStateException("LootTable is required");
    }

    @Override
    public EnemyBuilder reset() {
        name = null;
        health = damage = defense = speed = null;
        element = Element.NONE;
        aiBehavior = AIBehavior.TACTICAL;
        abilities.clear();
        lootTable = null;
        return this;
    }

    public EnemyBuilder from(Enemy e) {
        reset();
        setName(e.getName());
        setHealth(e.getHealth());
        setDamage(e.getDamage());
        setDefense(e.getDefense());
        setSpeed(e.getSpeed());
        setElement(e.getElement());
        setAI(e.getAiBehavior());
        setAbilities(e.getAbilities());
        setLootTable(e.getLootTable());
        return this;
    }
}
