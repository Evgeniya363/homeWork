package ru.gb.family_tree.model.mybuilder;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;

import java.io.Serializable;
import java.time.LocalDate;

public class MyBuilder implements Serializable {
    FamilyTree<Human> familyTree;
    long index;

    public MyBuilder(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public Human createHuman(long id, String name, Gender gender, LocalDate birthDate, Human parent1, Human parent2) {
        return new Human(id, name, gender, birthDate, parent1, parent2);
    }
}
