package com.galiamov.catalog

import spock.lang.Specification

import static com.galiamov.catalog.CategoriesController.Algorithm.Iterative
import static com.galiamov.catalog.CategoriesController.Algorithm.Recursive


class CategoryTraversalFactorySpec extends Specification {

    def "get traversal for"() {
        given:
        def factory = new CategoryTraversalFactory()

        expect:
        factory.getTraversalFor(algorithm).getClass().name == result

        where:
        algorithm || result
        Iterative || IterativeTraversal.name
        Recursive || RecursiveTraversal.name
    }

}
