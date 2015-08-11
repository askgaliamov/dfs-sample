package com.galiamov.catalog;

public class CategoryName {

    int level;
    String name;

    CategoryName(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }
}
