package ru.gb.family_tree.family_tree;

import java.util.List;

public interface FamilyTreeItem<T> {
//    long detId();
    String getName();
    int getAge();
    T getFather();
    T getMather();
    List<T> getChildList();
    void setParent(T human);
}
