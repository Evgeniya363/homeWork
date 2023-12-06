package ru.gb.family_tree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable, Comparable<Human> {
    private long id;
    private String name;
    final private Gender gender;
    private LocalDate birthDate;
    private Human father, mather;
    final private List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate) {
        this.id = -1;
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }
    public Human(String name, Gender gender, LocalDate birthDate, Human parent) {
       this(name, gender, birthDate);
        setParent(parent);
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human parent1, Human parent2) {
        this(name, gender, birthDate, parent1);
        setParent(parent2);
    }
    public void setID(long id){
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(Human parent) {
        if(parent.gender.equals(Gender.Female))
            mather = parent;
        else
            father = parent;
        parent.addKid(this);
    }

    public void addKid(Human child) {
        List<Human> childList = this.getChildren();
        if (!childList.contains(child))
            this.getChildren().add(child);
    }

    public Human getMather() {
        return mather;
    }

    public Human getFather() {
        return father;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        Period diff = Period.between(birthDate, LocalDate.now());
        return diff.getYears();
    }

    public List<Human> getChildren() {
        return children;
    }

    public long getId() {
        return id;
    }
    private Gender getGender() {
        return gender;
    }
    public String getHumanShortInfo() {
        return "id: " + id +", name: " + name + ", gender: " + gender +", age: " + getAge();
    }
    public String getFatherInfo() {
        if (father != null)
            return "father: " + father.getHumanShortInfo();
        else
            return "father: no data";
    }
    public String getMatherInfo() {
        if (mather != null)
            return "mather: " + mather.getHumanShortInfo();
        else
            return "mather: no data";
    }

    public String getHumanInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getHumanShortInfo());
        sb.append(", \n\t").append(getMatherInfo());
        sb.append(", \n\t").append(getFatherInfo());
        sb.append(", \n\t").append(getChildrenInfo());
        return sb.toString();
    }

    public String getChildrenInfo() {
        StringBuilder sb = new StringBuilder("children: ");
        if(getCountChildren() > 0) {
            for(Human child: getChildren()){
                sb.append("\n\t\t");
                sb.append(child.getHumanShortInfo());
            }
        } else {
            sb.append("no data");
        }
        return sb.toString();
    }

    private int getCountChildren() {
        return children.size();
    }
    public void addChild(Human child) {
        Human parent = child.getMather();
        if (parent != null)
            if (!parent.getChildren().contains(child))
                parent.getChildren().add(child);

        parent = child.getFather();
        if (parent != null)
            if (!parent.getChildren().contains(child)) {
                parent.getChildren().add(child);
            }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(id, human.id);
    }

    @Override
    public String toString() {
        return this.getHumanInfo();
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.getName());
    }
}
