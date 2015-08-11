package com.galiamov.catalog;

public class Category {

    private final String parentId;
    private final String name;

    public Category(String parentId, String name) {
        this.parentId = parentId;
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public String getName() {
        return name;
    }

}
