package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.mybuilder.MyBuilder;
import ru.gb.family_tree.model.writer.FileHandler;

import java.time.LocalDate;

public class ServiceHuman {
    private final String filePath;
    private final FileHandler fileHandler;
    private final MyBuilder builder;
    private FamilyTree<Human> familyTree;
    private long humanId;

    public ServiceHuman() {
        fileHandler = new FileHandler();
        filePath = "src/ru/gb/family_tree/model/writer/family_tree.out";
        familyTree = new FamilyTree<>();
        builder = new MyBuilder(familyTree);
    }

    public boolean read() {
//        familyTree =new FamilyTree<>();
        familyTree = (FamilyTree<Human>) fileHandler.read(filePath);
        humanId = familyTree.getMaxId();
        return (familyTree != null);
    }

    public boolean save() {
        return fileHandler.save(familyTree, filePath);

    }

    public Human addHuman(String name, String genderStr, LocalDate birthDate, Long mather, Long father ){
        Gender gender;
        if (genderStr.equals("жен"))
            gender = Gender.Female;
        else
            gender = Gender.Male;

        Human parent1, parent2;
        parent1 = familyTree.getHumanFromId(mather);
        parent2 = familyTree.getHumanFromId(father);
        Human human = builder.createHuman(humanId++, name, gender, birthDate, parent1, parent2);
        familyTree.addHuman(human);
        return human;
    }

    public String getHumanInfo() {
        return familyTree.getListFamilyTree();
//        System.out.println("Service List");
//        StringBuilder sb = new StringBuilder("Piple list:\n");
//        for (Human human: familyTree) {
//            sb.append(human).append("\n");
//        }
//        return sb.toString();
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByAge(){
        familyTree.sortByAge();
    }
}
