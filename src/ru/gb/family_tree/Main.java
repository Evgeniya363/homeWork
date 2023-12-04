package ru.gb.family_tree;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Human> listHuman =new ArrayList<>();
        listHuman.add(new Human("Jane", Gender.Female)); // 0
        listHuman.add(new Human("Olga", Gender.Female)); // 1
        listHuman.add(new Human("Tatyana", Gender.Female)); // 2
        listHuman.add(new Human("Svetlana", Gender.Female)); // 3
        listHuman.add(new Human("Bob", Gender.Male)); // 4
        listHuman.add(new Human("Dmitriy", Gender.Male)); // 5
        listHuman.add(new Human("Vladimir", Gender.Male)); // 6
        listHuman.add(new Human("Valentina", Gender.Female)); // 7

        listHuman.get(0).setFather(listHuman.get(5));
        listHuman.get(0).setMather(listHuman.get(1));
        listHuman.get(2).setFather(listHuman.get(4));
        listHuman.get(2).setMather(listHuman.get(0));
        listHuman.get(3).setFather(listHuman.get(4));
        listHuman.get(3).setMather(listHuman.get(0));

        FamilyTree familyTree = new FamilyTree();
        for (Human human : listHuman){
            familyTree.addHuman(human);
        }

        System.out.println(familyTree);
    }
}
