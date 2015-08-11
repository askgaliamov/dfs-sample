package com.galiamov.catalog

import spock.lang.Shared
import spock.lang.Specification


class CategoriesControllerSpec extends Specification {

    @Shared
    def fullTreeResult = [
            "L0",   " L11",     "  L21",
                                "  L22",
                    " L12",     "  L23",
                                "  L24"]
    def "list of full tree"() {
        given:
        def controller = new DefaultCategoriesController()


        and:
        controller.addCategory("L11", "L21")
        controller.addCategory("L12", "L23")
        controller.addCategory("L0", "L11")
        controller.addCategory("L12", "L24")
        controller.addCategory("L11", "L22")
        controller.addCategory("L0", "L12")

        expect:
        controller.listCategories(algorithm) == result

        where:
        algorithm || result
        CategoriesController.Algorithm.Iterative || fullTreeResult
        CategoriesController.Algorithm.Recursive || fullTreeResult
    }

    def "short tree"() {
        given:
        def controller = new DefaultCategoriesController()


        and:
        controller.addCategory("L0", "L1")

        expect:
        controller.listCategories(algorithm) == result

        where:
        algorithm || result
        CategoriesController.Algorithm.Iterative || ["L0", " L1"]
        CategoriesController.Algorithm.Recursive || ["L0", " L1"]
    }

    def "empty tree"() {
        given:
        def controller = new DefaultCategoriesController()

        expect:
        controller.listCategories(algorithm) == result

        where:
        algorithm || result
        CategoriesController.Algorithm.Iterative || []
        CategoriesController.Algorithm.Recursive || []
    }

}
