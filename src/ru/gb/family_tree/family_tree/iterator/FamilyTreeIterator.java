package ru.gb.family_tree.family_tree.iterator;

import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Serializable, Iterator<Human> {
    private List<Human> humanList;
    private int index;
    public FamilyTreeIterator(List<Human> humanList){
        this.humanList = humanList;
    }
    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}
