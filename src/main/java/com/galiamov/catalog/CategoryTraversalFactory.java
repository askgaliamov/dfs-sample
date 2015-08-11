package com.galiamov.catalog;

public class CategoryTraversalFactory {

    Traversal getTraversalFor(CategoriesController.Algorithm algorithm) {
        switch (algorithm) {
            case Iterative:
                return new IterativeTraversal();
            case Recursive:
                return new RecursiveTraversal();
            default:
                throw new IllegalArgumentException("Algorithm {" + algorithm + "} undefined");
        }
    }

}
