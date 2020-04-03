package com.kuul.bc.product.business;

import com.kuul.bc.product.dto.Product;
import com.kuul.bc.product.dto.Salesman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Business layer for the salesman view
 */
public class SalesmanViewBL {

    private static Map<Salesman, List<Product>> catalogue = new HashMap<>();

    /**
     * Add a salesman to the catalogue
     */
    public void addSalesman(String salesman) {
        long size = catalogue.keySet().size();
        Salesman newSalesman = new Salesman(size + 1, salesman);
        catalogue.put(newSalesman, new ArrayList<>());
    }

    /**
     * Get all salesmen from the catalogue
     */
    public Set<Salesman> getAllSalesman() {
        return catalogue.keySet();
    }

    /**
     * Add a product to the catalogue of a certain salesman
     */
    public void addProduct(long id, String product, String description, long amount, double price) {
        Salesman salesman = retrieveSalesmanFromCatalogue(id);
        Product newProduct = new Product(product, description, amount, price);
        catalogue.get(salesman).add(newProduct);
    }

    /**
     * Get the view on a catalogue of a certain salesman
     */
    public List<Product> getStore(long id) {
        Salesman salesman = catalogue.keySet()
                                     .stream()
                                     .filter(s -> s.getId() == id)
                                     .collect(Collectors.toList())
                                     .get(0);
        return catalogue.get(salesman);
    }

    /**
     * Delete all stores and products from catalogue
     */
    public void deleteAll() {
        catalogue.clear();
    }

    private static Salesman retrieveSalesmanFromCatalogue(long id) {
        return catalogue.keySet()
                        .stream()
                        .filter(s -> s.getId() == id)
                        .collect(Collectors.toList())
                        .get(0);
    }

    public Map<Salesman, List<Product>> getCatalogue() {
        return catalogue;
    }
}
