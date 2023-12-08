package ru.gb.family_tree.model.family_tree;

import java.util.List;

public interface FamilyTreeItem<T> {
//    long detId();
    Long getId();
    String getName();
    int getAge();
    T getFather();
    T getMather();
    List<T> getChildList();
    void setParent(T human);
}
