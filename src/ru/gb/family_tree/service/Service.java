package ru.gb.family_tree.service;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.family_tree.FamilyTreeItem;
import ru.gb.family_tree.family_tree.iterator.FamilyTreeIterator;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.mybuilder.MyBuilder;
import ru.gb.family_tree.writer.FileHandler;

import java.time.LocalDate;

public class Service {
    private final String filePath;
    private final FileHandler fileHandler;
    private final MyBuilder builder;
    public FamilyTree<Human> familyTree;

    public Service() {
        fileHandler = new FileHandler();
        filePath = "src/ru/gb/family_tree/writer/family_tree.out";
        familyTree = new FamilyTree<>();
        builder = new MyBuilder();

    }

    public Human addHuman(String name, Gender gender, LocalDate birthDate){
        Human human = builder.createHuman(name, gender, birthDate);
        familyTree.addHuman(human);
        return human;
    }

    public void appendChild(Human human, Human child){
        familyTree.appendChild(human, child);
    }

    public void read() {
        familyTree = (FamilyTree<Human>) fileHandler.read(filePath);
    }
    public void start() {
        read();
//      initialization();
        sortByAge();
        System.out.println(getHumanInfo());
        save();
    }

    public void save() {
        fileHandler.save(familyTree, filePath);

    }

    public String getHumanInfo() {
        StringBuilder sb = new StringBuilder("Piple list:\n");
        for (Human human: familyTree) {
            sb.append(human).append("\n");
        }
        return sb.toString();
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByAge(){
        familyTree.sortByAge();
    }

    public void initialization() {
        Human olga = builder.createHuman("Olga", Gender.Female, LocalDate.of(1948,6,20));
        Human dmitriy = builder.createHuman("Dmitriy", Gender.Male, LocalDate.of(1946,10,28));
        familyTree.addHuman(olga);
        familyTree.addHuman(dmitriy);

        Human jane = builder.createHuman("Jane", Gender.Female, LocalDate.of(1976,1,18), olga, dmitriy);
        Human ann = builder.createHuman("Ann",Gender.Female, LocalDate.of(1974,5,18), olga, dmitriy);
        familyTree.addHuman(ann);
        familyTree.addHuman(jane);

        Human tatyana = builder.createHuman("Tatyana", Gender.Female, LocalDate.of(1995,12,30),jane);
        Human svetlana = builder.createHuman("Svetlana", Gender.Female, LocalDate.of(1999,5,8),jane);
        familyTree.addHuman(tatyana);
        familyTree.addHuman(svetlana);

        Human valentina = builder.createHuman("Valentina", Gender.Female, LocalDate.of(1950,6,14));
        Human vladimir = builder.createHuman("Vladimir", Gender.Male, LocalDate.of(1950,4,17));
        familyTree.addHuman(valentina);
        familyTree.addHuman(vladimir);

        Human bob = builder.createHuman("Bob", Gender.Male, LocalDate.of(1973,4,26), valentina, vladimir);
        familyTree.appendChild(bob,tatyana);
        familyTree.appendChild(bob, svetlana);
        familyTree.addHuman(bob);

        Human mitya = builder.createHuman("Mitya", Gender.Male, LocalDate.of(2000,5,23), ann);
        familyTree.addHuman(mitya);
    }

}
