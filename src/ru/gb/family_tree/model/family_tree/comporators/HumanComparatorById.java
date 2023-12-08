package ru.gb.family_tree.model.family_tree.comporators;

import ru.gb.family_tree.model.family_tree.FamilyTreeItem;

import java.io.Serializable;
import java.util.Comparator;

public class HumanComparatorById<T extends FamilyTreeItem<T>> implements Serializable, Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}
