package com.kuul.bc.product.business;

import com.kuul.bc.product.dto.Catalogue;
import com.kuul.bc.product.dto.Client;
import com.kuul.bc.product.dto.Order;
import com.kuul.bc.product.dto.Product;
import com.kuul.bc.product.dto.Salesman;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ClientViewBLUnitTest {

    @InjectMocks
    private ClientViewBL clientViewBL;
    @Mock
    private SalesmanViewBL salesmanViewBL;

    @Test
    public void shouldGetCatalogue() {
        // given
        Mockito.when(salesmanViewBL.getCatalogue()).thenReturn(createCatalogue());

        // when
        List<Catalogue> result = clientViewBL.getCatalogue();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getSalesman()).isEqualTo("bakery");
        assertThat(result.get(0).getProducts().size()).isEqualTo(2);
        assertThat(result.get(1).getSalesman()).isEqualTo("butchery");
        assertThat(result.get(1).getProducts().size()).isEqualTo(1);
    }

    @Test
    public void shouldGetAllClientAccounts() {
        // given

        // when
        List<Client> result = clientViewBL.getAllClientAccounts();

        // then
        assertThat(result).isInstanceOf(ArrayList.class);
    }

    @Test
    public void shouldCreateClient() {
        // given

        // when
        clientViewBL.createClient();
        List<Client> result = clientViewBL.getAllClientAccounts();

        // then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getId()).isEqualTo(1);

    }

    @Test
    public void shouldGetAllOrders() {
        // given

        // when
        List<Order> result = clientViewBL.getAllOrders();

        // then
        assertThat(result).isInstanceOf(ArrayList.class);
    }

    private Map<Salesman, List<Product>> createCatalogue() {
        // create shop and its products
        final Salesman bakery = createSalesman(1L, "bakery");
        final Product bread = createProduct("bread", "oven-fresh baked bread", 3L, 3.99);
        final Product pie = createProduct("pie", "apple pie", 10L, 2.49);
        final List<Product> productsOfBakery = Arrays.asList(bread, pie);

        final Salesman butchery = createSalesman(2L, "butchery");
        final Product sausage = createProduct("sausage",  "beef sausage", 4L, 2.99);
        final List<Product> productsOfButchery = Collections.singletonList(sausage);

        final Map<Salesman, List<Product>> catalogue = new HashMap<>();
        catalogue.put(bakery, productsOfBakery);
        catalogue.put(butchery, productsOfButchery);
        return catalogue;
    }

    private Salesman createSalesman(long id, String salesman) {
        return new Salesman(id, salesman);
    }

    private Product createProduct(String product, String description, long amount, double price) {
        return new Product(product, description, amount, price);
    }
}
