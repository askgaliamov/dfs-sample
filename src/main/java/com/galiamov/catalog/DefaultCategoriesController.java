package com.galiamov.catalog;

import java.util.List;

public class DefaultCategoriesController implements CategoriesController {

    private final CatalogTree tree = new CatalogTree();

    private final CategoryTraversalFactory traversalFactory = new CategoryTraversalFactory();

    private final CategoryNameFormatter categoryNameFormatter = new CategoryNameFormatter();

    @Override
    public Category addCategory(String parentId, String name) {
        tree.add(parentId, name);
        return new Category(parentId, name);
    }

    @Override
    public List<String> listCategories(Algorithm algorithm) {
        Traversal traversal = traversalFactory.getTraversalFor(algorithm);

        List<CategoryName> categoryNames = traversal.listCategories(tree);

        return categoryNameFormatter.format(categoryNames);
    }

}
