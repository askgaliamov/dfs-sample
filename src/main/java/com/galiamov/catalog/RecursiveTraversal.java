package com.galiamov.catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecursiveTraversal implements Traversal {

    private final Set<String> visited = new HashSet<>();
    private final List<CategoryName> result = new ArrayList<>();

    @Override
    public List<CategoryName> listCategories(final CatalogTree tree) {
        if (tree.isEmpty()) {
            return Collections.emptyList();
        }
        String root = tree.getRoot();
        dfs(tree, root, 0);
        return result;
    }

    private void dfs(CatalogTree tree, String v, int level) {
        visited.add(v);
        result.add(new CategoryName(level, v));
        for (String w : tree.get(v)) {
            if (!visited.contains(w)) {
                dfs(tree, w, level + 1);
            }
        }
    }
}
