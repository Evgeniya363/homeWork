package ru.gb.family_tree.mybuilder;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.time.LocalDate;

public class MyBuilder implements Serializable {
    long index;
    public Human createHuman(String name, Gender gender, LocalDate birthDate) {
        return new Human(index++, name, gender, birthDate);
    }
    public Human createHuman(String name, Gender gender, LocalDate birthDate, Human parent) {
        return new Human(index++, name, gender, birthDate, parent);
    }
    public Human createHuman(String name, Gender gender, LocalDate birthDate, Human parent1, Human parent2) {
        return new Human(index++, name, gender, birthDate, parent1, parent2);
    }
}
