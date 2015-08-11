package com.galiamov.catalog

import spock.lang.Specification


class CatalogTreeSpec extends Specification {

    def "find root node"() {
        given:
        def tree = new CatalogTree()

        and:
        tree.add("L11", "L21")
        tree.add("L12", "L23")
        tree.add("L0", "L11")
        tree.add("L12", "L24")
        tree.add("L11", "L22")
        tree.add("L0", "L12")

        expect:
        tree.getRoot() == "L0"
    }

}
