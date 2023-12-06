package ru.gb.family_tree.writer;

import ru.gb.family_tree.family_tree.FamilyTree;

import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    Object read(String filePath);
    boolean save(Serializable serializable, String filePath);
}
