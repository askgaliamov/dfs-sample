package com.galiamov.catalog;

import java.util.ArrayList;
import java.util.List;

public class CategoryNameFormatter {

    List<String> format(final List<CategoryName> categories) {
        List<String> result = new ArrayList<>(categories.size());
        for (CategoryName category : categories) {
            result.add(getNameWithPrefix(category.getName(), category.getLevel()));
        }
        return result;
    }

    private String getNameWithPrefix(String name, int level) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < level; i++) {
            result.append(" ");
        }
        result.append(name);
        return result.toString();
    }

}
