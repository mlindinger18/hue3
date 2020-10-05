/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastreams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Marcel.Lindinger
 */
public class Main {

    public static void main(String[] args) throws IOException {
        List<Weapons> list = new LinkedList<>();
        list.add(new Weapons("Varscona", combatType.MELEE, damageType.SLASHING, 11, 3, 5, 4250));
        list.add(new Weapons("Tuigan Bow", combatType.RANGED, damageType.MISSILE, 1, 5, 6, 3500));

        list.sort((Weapons o1, Weapons o2) -> Integer.compare(o1.getDamage(), o2.getDamage()));

        list.sort((w1, w2) -> Integer.compare(w1.getDamage(), w2.getDamage()));
        list.clear();

        Thread t = new Thread(() -> System.out.println("ID = " + Thread.currentThread().getId()));
        t.start();

        Printable printable = w -> System.out.println(w.getName() + " [" + w.getDamageType() + " = " + w.getDamage() + "]");
        printable.print(list.get(0));

        System.out.println("+----------------+----------+----------+------+-----+--------+-----+");
        System.out.println("|name            |combatType|damageType|damage|speed|strength|value|");
        System.out.println("+----------------+----------+----------+------+-----+--------+-----+");
        for (int i = 0; i < list.size(); i++) {
            Printable p = x -> System.out.println("|" + x.getName() + "|" + x.getCombatType() + "|" + x.getDamageType() + "|" + x.getDamage() + "|" + x.getSpeed() + "|" + x.getMinStrength() + "|" + x.getValue() + "|");
            System.out.println("+----------------+----------+----------+------+-----+--------+-----+");
        }
        list = Files.lines(new File("weapons.csv").toPath())
                .skip(1)
                .map(s -> s.split(";"))
                .map(s -> new Weapons(
                s[0],
                combatType.valueOf(s[1]),
                damageType.valueOf(s[2]),
                Integer.parseInt(s[3]),
                Integer.parseInt(s[4]),
                Integer.parseInt(s[5]),
                Integer.parseInt(s[6])
        ))
                .collect(Collectors.toList());

    }

}
