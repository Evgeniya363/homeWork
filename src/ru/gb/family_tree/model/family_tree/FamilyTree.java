package ru.gb.family_tree.model.family_tree;
import ru.gb.family_tree.model.family_tree.comporators.HumanComparatorByName;
import ru.gb.family_tree.model.family_tree.iterator.FamilyTreeIterator;
import ru.gb.family_tree.model.family_tree.comporators.HumanComparatorByAge;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    final private List<E> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }
    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public E getHumanFromId(Long id) {

        for (E human: humanList) {
            if (Objects.equals(human.getId(), id))
                return human;
        }
        return null;
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
        E parent = human.getMather();
        if (parent != null)
            addKid(parent, human);
        parent = human.getFather();
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

    public String getListFamilyTree() {
        StringBuilder sb = new StringBuilder();
        sb.append("Список граждан:\n");
        for (E human : humanList) {
            sb.append(human);
            sb.append(("\n"));
        }
        return sb.toString();
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
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge<>());
    }

    public long getMaxId() {
        if (!humanList.isEmpty())
            return humanList.get(humanList.size() - 1).getId() + 1;
        else
            return 0;
    }
//TODO        E human = Collections.max(humanList, new HumanComparatorById<E>());
//        return human.getId();

}
