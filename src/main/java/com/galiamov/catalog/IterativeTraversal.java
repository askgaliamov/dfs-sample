package com.galiamov.catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class IterativeTraversal implements Traversal {

    private Set<String> visited = new HashSet<>();

    @Override
    public List<CategoryName> listCategories(final CatalogTree tree) {
        if (tree.isEmpty()) {
            return Collections.emptyList();
        }
        List<CategoryName> result = new ArrayList<>();

        String root = tree.getRoot();
        Map<String, Iterator<String>> stringIteratorMap = tree.asMapOfIterators();

        Stack<String> stack = new Stack<>();

        visited.add(root);
        stack.push(root);

        int level = 0;
        result.add(new CategoryName(level, root));

        while (!stack.isEmpty()) {
            String parent = stack.peek();
            Iterator<String> stringIterator = stringIteratorMap.get(parent);
            if (stringIterator != null && stringIterator.hasNext()) {
                String child = stringIterator.next();
                level++;
                if (!visited.contains(child)) {
                    visited.add(child);
                    stack.push(child);
                    result.add(new CategoryName(level, child));
                }
            } else {
                level--;
                stack.pop();
            }
        }
        return result;
    }
}
