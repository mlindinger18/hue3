/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastreams;

/**
 *
 * @author Marcel.Lindinger
 */
public class Weapons {

    private final String name;
    private final combatType combatType;
    private final damageType damageType;
    private final int damage;
    private final int speed;
    private final int minStrength;
    private int value;

    public Weapons(String name, combatType combatType, damageType damageType, int damage, int speed, int minStrength) {
        this.name = name;
        this.combatType = combatType;
        this.damageType = damageType;
        this.damage = damage;
        this.speed = speed;
        this.minStrength = minStrength;
    }

    public String getName() {
        return name;
    }

    public combatType getCombatType() {
        return combatType;
    }

    public damageType getDamageType() {
        return damageType;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMinStrength() {
        return minStrength;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
