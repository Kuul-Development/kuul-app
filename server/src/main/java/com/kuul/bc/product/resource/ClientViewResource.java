package com.kuul.bc.product.resource;

import com.kuul.bc.product.dto.Client;
import com.kuul.bc.product.dto.Order;
import com.kuul.bc.product.dto.Product;
import com.kuul.bc.product.dto.Salesman;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Resource class for the client view
 */
@Path("buy")
public class ClientViewResource {
    /**
     * Overview of all orders of clients
     */
    private static List<Order> shoppingCard = new ArrayList<>();
    /**
     * List of all registered clients
     */
    private static List<Client> clientAccounts = new ArrayList<>();

    /**
     * Get the whole catalogue of all available products
     */
    @GET
    @Path("getcatalogue")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveCatalogue() {
        SalesmanViewResource salesview = new SalesmanViewResource();
        Map<Salesman, List<Product>> catalogue = salesview.getCatalogue();
        return Response
                .ok(catalogue, MediaType.APPLICATION_JSON)
                .build();
    }

    /**
     * Create a new client
     */
    @PUT
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createClient() {
        int size = clientAccounts.size();
        Client newClient = new Client(size+1);
        clientAccounts.add(newClient);

        return Response
                .ok(newClient, MediaType.APPLICATION_JSON)
                .build();
    }

    /**
     * Place an order of products
     */
    @PUT
    @Path("placeOrder")
    @Produces(MediaType.APPLICATION_JSON)
    public static Response placeOrder(@QueryParam("client") long id, @QueryParam("salesman") String salesman, @QueryParam("product") String product) {
        final SalesmanViewResource sellingView = new SalesmanViewResource();
        final Client client = retrieveClientForId(id);
        final Salesman dealer = retrieveDealer(sellingView, salesman);
        final Product orderedProduct = retrieveOrderedProduct(sellingView, dealer, product);

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

        Order orderForClient = shoppingCard.stream().filter(o -> o.getClient().equals(client)).collect(Collectors.toList()).get(0);
        return Response
                .ok(orderForClient, MediaType.APPLICATION_JSON)
                .build();
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

    private static Product retrieveOrderedProduct(SalesmanViewResource sellingView, Salesman dealer, String product) {
        return sellingView.getCatalogue()
                          .get(dealer)
                          .stream()
                          .filter(listItem -> listItem.getProduct().equals(product)).collect(Collectors.toList())
                          .get(0);
    }

    private static Salesman retrieveDealer(SalesmanViewResource seller, String salesman) {
        return seller.getCatalogue().keySet().stream().filter(s -> s.getName().equals(salesman)).collect(Collectors.toList()).get(0);
    }

    private static Client retrieveClientForId(long id) {
        return clientAccounts.stream().filter(clients -> clients.getId() == id).collect(Collectors.toList()).get(0);
    }

    public List<Order> getOrders() {
        return shoppingCard;
    }
}
