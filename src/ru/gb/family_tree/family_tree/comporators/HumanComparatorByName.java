package ru.gb.family_tree.family_tree.comporators;

import ru.gb.family_tree.family_tree.FamilyTreeItem;
import java.io.Serializable;
import java.util.Comparator;

public class HumanComparatorByName<T extends FamilyTreeItem<T>> implements Serializable, Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
