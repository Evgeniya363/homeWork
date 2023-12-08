package ru.gb.family_tree.model.human;
import ru.gb.family_tree.model.family_tree.FamilyTreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable, Comparable<Human>, FamilyTreeItem<Human> {
    private final long id;
    private final String name;
    final private Gender gender;
    private final LocalDate birthDate;
    private Human father, mather;
    final private List<Human> children;

    public Human(Long id, String name, Gender gender, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }
    public Human(Long id, String name, Gender gender, LocalDate birthDate, Human parent) {
       this(id, name, gender, birthDate);
        setParent(parent);
    }

    public Human(Long id, String name, Gender gender, LocalDate birthDate, Human parent1, Human parent2) {
        this(id, name, gender, birthDate, parent1);
        setParent(parent2);
    }

    public void setParent(Human parent) {
        if(parent != null){
            if(parent.gender.equals(Gender.Female))
                mather = parent;
            else
                father = parent;
        }
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
        if (birthDate != null) {
            Period diff = Period.between(birthDate, LocalDate.now());
            return diff.getYears();
        } else {
            return -1;
        }
    }

    public List<Human> getChildList() {
        return children;
    }

    public Long getId() {
        return id;
    }
    private String getGender() {
        if (gender.equals(Gender.Male))
            return "муж.";
        else
            return "жен.";
    }
    public String getHumanShortInfo() {
        return "id: " + id +", имя: " + name + ", пол: " + getGender() +", возраст: " + getAge();
    }
    public String getFatherInfo() {
        if (father != null)
            return "отец: " + father.getHumanShortInfo();
        else
            return "отец: нет данных";
    }
    public String getMatherInfo() {
        if (mather != null)
            return "мать: " + mather.getHumanShortInfo();
        else
            return "мать: нет данных";
    }

    public String getHumanInfo() {
        return getHumanShortInfo() +
                ", \n\t" + getMatherInfo() +
                ", \n\t" + getFatherInfo() +
                ", \n\t" + getChildrenInfo();
    }

    public String getChildrenInfo() {
        StringBuilder sb = new StringBuilder("дети: ");
        if(getCountChildren() > 0) {
            for(Human child: getChildList()){
                sb.append("\n\t\t");
                sb.append(child.getHumanShortInfo());
            }
        } else {
            sb.append("нет данных");
        }
        return sb.toString();
    }

    private int getCountChildren() {
        return children.size();
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
