package com.galiamov.catalog;

import java.util.List;

public interface CategoriesController {

    enum Algorithm {
        Iterative,
        Recursive
    }

    Category addCategory(String parentId, String name);
    List<String> listCategories(Algorithm algorithm);
}
