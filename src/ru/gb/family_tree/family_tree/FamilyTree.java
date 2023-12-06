package ru.gb.family_tree.family_tree;
import ru.gb.family_tree.family_tree.iterator.FamilyTreeIterator;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.comporators.HumanComparatorByAge;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    private long humanId;
    final private List<Human> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }
    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }
    public boolean addHuman(Human human) {
        if(!humanList.contains(human)){
            human.setID(humanId++);
            humanList.add(human);
            appendChildToParents(human);
            return true;
        }
        else
            return false;
    }

    private void appendChildToParents(Human human) {
        Human parent = human.getMather();
        if (parent != null)
            parent.addKid(human);

        parent = human.getMather();
        if (parent != null)
            parent.addKid(human);
    }

    public void appendChild(Human human, Human child) {
        human.addKid(child);
        child.setParent(human);
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

    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(humanList);
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByAge());
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge());
    }
}
