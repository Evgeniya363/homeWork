package ru.gb.family_tree.service;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.mybuilder.MyBuilder;
import ru.gb.family_tree.writer.FileHandler;

import java.time.LocalDate;

public class Service {
    private String filePath;
    private FileHandler fileHandler;
    private MyBuilder builder;
    public FamilyTree familyTree;

    public Service() {
        fileHandler = new FileHandler();
        filePath = "src/ru/gb/family_tree/writer/family_tree.out";
        familyTree = new FamilyTree();
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
        familyTree = (FamilyTree) fileHandler.read(filePath);
    }
    public void start() {
        // Инициализация начальными значениями
         initialization();

//        System.out.println(familyTree);
        System.out.println(getHumanInfo());

        familyTree.sortByName();
        System.out.println(getHumanInfo());

        familyTree.sortByAge();
        System.out.println(getHumanInfo());
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
        Human olga = new Human("Olga", Gender.Female, LocalDate.of(1948,6,20));
        Human dmitriy = new Human("Dmitriy", Gender.Male, LocalDate.of(1946,10,28));
        familyTree.addHuman(olga);
        familyTree.addHuman(dmitriy);

        Human jane = new Human("Jane", Gender.Female, LocalDate.of(1976,1,18), olga, dmitriy);
        Human ann = new Human("Ann",Gender.Female, LocalDate.of(1974,5,18), olga, dmitriy);
        familyTree.addHuman(ann);
        familyTree.addHuman(jane);

        Human tatyana = new Human("Tatyana", Gender.Female, LocalDate.of(1995,12,30),jane);
        Human svetlana = new Human("Svetlana", Gender.Female, LocalDate.of(1999,5,8),jane);
        familyTree.addHuman(tatyana);
        familyTree.addHuman(svetlana);

        Human valentina = new Human("Valentina", Gender.Female, LocalDate.of(1950,6,14));
        Human vladimir = new Human("Vladimir", Gender.Male, LocalDate.of(1950,4,17));
        familyTree.addHuman(valentina);
        familyTree.addHuman(vladimir);

        Human bob = new Human("Vladimir", Gender.Male, LocalDate.of(1973,4,26), valentina, vladimir);
        tatyana.setParent(bob);
        svetlana.setParent(bob);
        familyTree.addHuman(bob);

        Human mitya = new Human("Mitya", Gender.Male, LocalDate.of(2000,5,23), ann);
        familyTree.addHuman(mitya);
    }

}
