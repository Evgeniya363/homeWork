package ru.gb.family_tree.mybuilder;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.time.LocalDate;

public class MyBuilder implements Serializable {
//    long id;
    public Human createHuman(String name, Gender gender, LocalDate birthDate) {
        return new Human(name, gender, birthDate);
    }
}
