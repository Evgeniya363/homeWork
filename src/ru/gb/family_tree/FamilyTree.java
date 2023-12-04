package ru.gb.family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human) {
        this.humanList.add(human);
    }

    public String getListFamilyTree() {
        StringBuilder builder = new StringBuilder();
        builder.append("Список граждан:\n\n");
        for (Human human : this.humanList) {
            builder.append(human).append(("\n"));
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return this.getListFamilyTree();
    }
}
