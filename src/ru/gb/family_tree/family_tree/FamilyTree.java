package ru.gb.family_tree.family_tree;
import ru.gb.family_tree.family_tree.iterator.FamilyTreeIterator;
import ru.gb.family_tree.family_tree.comporators.HumanComparatorByAge;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private long humanId;
    final private List<E> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }
    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }
    public boolean addHuman(E human) {
        if(!humanList.contains(human)){
            humanList.add(human);
            appendChildToParents(human);
            return true;
        }
        else
            return false;
    }

    private void appendChildToParents(E human) {
        E parent = (E) human.getMather();
        if (parent != null)
            addKid(parent, human);

        parent = (E) human.getFather();
//        if (human.getName()=="Bob")
//            System.out.println("!");
        if (parent != null)
            addKid(parent, human);
    }

    public void appendChild(E human, E child) {
        addKid(human, child);
        child.setParent(human);
    }

    public void addKid(E human, E child) {
        human.getChildList().add(child);
    }

//    public void setParent(E human, E child) {
//        human.setParent(child);
//    }

    public String getListFamilyTree() {
        StringBuilder builder = new StringBuilder();
        builder.append("Список граждан:\n\n");
        for (E human : humanList) {
            builder.append(human).append(("\n"));
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return this.getListFamilyTree();
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(humanList);
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByAge<>());
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge<>());
    }
}
