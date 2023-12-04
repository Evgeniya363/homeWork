package ru.gb.family_tree;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
//    private String surname;
    private Gender gender;
    private Human father, mather;
    private List<Human> children;

    public Human(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMather(Human mather) {
        this.mather = mather;
    }

    @Override
    public String toString() {
                return this.getHumanInfo();
    }

    public String getHumanShortInfo() {
            return "name: " + name + ", gender: " + gender;
    }

    public String getHumanInfo() {
        StringBuilder humanInfo = new StringBuilder();
        humanInfo.append(this.getHumanShortInfo());

        if (father != null)
            humanInfo.append("\n father => ").append(father.getHumanShortInfo());
        if (mather != null)
            humanInfo.append("\n mather => ").append(mather.getHumanShortInfo());
        humanInfo.append("\n");

        return humanInfo.toString();
    }
}
