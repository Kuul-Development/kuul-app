package com.kuul.bc.product.business;

import com.kuul.bc.product.dto.Catalogue;
import com.kuul.bc.product.dto.Client;
import com.kuul.bc.product.dto.Order;
import com.kuul.bc.product.dto.Product;
import com.kuul.bc.product.dto.Salesman;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * business layer for the client view
 */
public class ClientViewBL {

    /**
     * Overview of all orders of clients
     */
    private static List<Order> shoppingCard = new ArrayList<>();
    /**
     * List of all registered clients
     */
    private static List<Client> clientAccounts = new ArrayList<>();

    @Inject
    private SalesmanViewBL salesmanViewBL;

    /**
     * Get the whole catalogue of available stores and products
     */
    public List<Catalogue> getCatalogue() {
        return createCatalogueForClientView();
    }

    /**
     * Create a new client
     */
    public void createClient() {
        int size = clientAccounts.size();
        Client newClient = new Client(size+1);
        clientAccounts.add(newClient);
    }

    /**
     * Place an order of products
     */
    public void placeOrder(long id, String salesman, String product) {
        final Client client = retrieveClientForId(id);
        final Salesman dealer = retrieveDealer(salesman);
        final Product orderedProduct = retrieveOrderedProduct(dealer, product);

        if(isClientKnown(client)) {
            if (clientHasAlreadyOrderAtDealer(dealer)) {
                addNewProductToClientsShoppingCard(client, dealer, orderedProduct);
            } else {
                addNewDealerToClientsShoppingCard(client, dealer, orderedProduct);
            }
        }
        else {
            addNewOrderToClient(client, dealer, orderedProduct);
        }
    }

    /**
     * Delete all items from shoppingCard
     */
    public void deleteAll() {
        shoppingCard.clear();
    }

    /**
     * Get the whole catalogue of all available products
     */
    public List<Order> getAllOrders() {
        return shoppingCard;
    }

    /**
     * Get all client accounts
     */
    public List<Client> getAllClientAccounts() {
        return clientAccounts;
    }

    private List<Catalogue> createCatalogueForClientView() {
        Map<Salesman, List<Product>> catalogue = salesmanViewBL.getCatalogue();
        return catalogue.entrySet()
                        .stream()
                        .map(e -> new Catalogue(e.getKey().getName(), e.getValue()))
                        .collect(Collectors.toList());
    }

    private static void addNewOrderToClient(Client client, Salesman dealer, Product orderedProduct) {
        int size = shoppingCard.size();
        Order newOrder = new Order(size+1, client, dealer, orderedProduct);
        shoppingCard.add(newOrder);
    }

    private static void addNewDealerToClientsShoppingCard(Client client, Salesman dealer, Product orderedProduct) {
        Order order = shoppingCard.stream().filter(o -> o.getClient().equals(client)).collect(Collectors.toList()).get(0);
        order.getListOfOrderedProducts().put(dealer, Collections.singletonList(orderedProduct));
    }

    private static void addNewProductToClientsShoppingCard(Client client, Salesman dealer, Product orderedProduct) {
        Order order = shoppingCard.stream().filter(o -> o.getClient().equals(client)).collect(Collectors.toList()).get(0);
        order.getListOfOrderedProducts().get(dealer).add(orderedProduct);
    }

    private static boolean clientHasAlreadyOrderAtDealer(Salesman dealer) {
        return shoppingCard.stream().anyMatch(order -> order.getListOfOrderedProducts().containsKey(dealer));
    }

    private static boolean isClientKnown(Client client) {
        return shoppingCard.stream().anyMatch(order -> order.getClient().equals(client));
    }

    private Product retrieveOrderedProduct(Salesman dealer, String product) {
        return  salesmanViewBL.getCatalogue()
                              .get(dealer)
                              .stream()
                              .filter(listItem -> listItem.getProduct().equals(product)).collect(Collectors.toList())
                              .get(0);
    }

    private Salesman retrieveDealer(String salesman) {
        return salesmanViewBL.getCatalogue().keySet().stream().filter(s -> s.getName().equals(salesman)).collect(Collectors.toList()).get(0);
    }

    private static Client retrieveClientForId(long id) {
        return clientAccounts.stream().filter(clients -> clients.getId() == id).collect(Collectors.toList()).get(0);
    }
}
