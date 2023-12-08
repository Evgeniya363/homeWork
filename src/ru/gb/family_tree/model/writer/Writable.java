package ru.gb.family_tree.model.writer;

import java.io.Serializable;

public interface Writable {
    Object read(String filePath);
    boolean save(Serializable serializable, String filePath);
}
