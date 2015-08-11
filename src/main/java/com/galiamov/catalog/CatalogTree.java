package com.galiamov.catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CatalogTree {

    private String root;
    private final Map<String, List<String>> tree = new HashMap<>();
    private final Map<String, String> reverseTree = new HashMap<>();

    void add(String parentId, String name) {
        if (!this.tree.containsKey(parentId)) {
            ArrayList<String> names = new ArrayList<>();
            names.add(name);
            this.tree.put(parentId, names);
        } else {
            this.tree.get(parentId).add(name);
        }
        this.reverseTree.put(name, parentId);
        this.root = null;
    }

    String getRoot() {
        if (this.root != null) {
            return this.root;
        }
        this.root = reverseTree.keySet().iterator().next();
        while (reverseTree.containsKey(this.root)) {
            this.root = reverseTree.get(this.root);
        }
        return this.root;
    }

    List<String> get(String key) {
        if (!tree.containsKey(key)) {
            return Collections.emptyList();
        }
        return tree.get(key);
    }

    Map<String, Iterator<String>> asMapOfIterators() {
        Map<String, Iterator<String>> result = new HashMap<>();
        Set<Map.Entry<String, List<String>>> entries = tree.entrySet();
        for (Map.Entry<String, List<String>> entry : entries) {
            result.put(entry.getKey(), entry.getValue().iterator());
        }
        return result;
    }

    boolean isEmpty() {
        return tree.isEmpty();
    }
}
