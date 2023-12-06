package ru.gb.family_tree.family_tree.iterator;

import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T> implements Serializable, Iterator<T> {
    private List<T> humanList;
    private int index;
    public FamilyTreeIterator(List<T> humanList){
        this.humanList = humanList;
    }
    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public T next() {
        return humanList.get(index++);
    }
}
