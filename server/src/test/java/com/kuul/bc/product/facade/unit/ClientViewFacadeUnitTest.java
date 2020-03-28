package com.kuul.bc.product.facade.unit;

import com.kuul.bc.product.business.ClientViewBL;
import com.kuul.bc.product.dto.Catalogue;
import com.kuul.bc.product.dto.Order;
import com.kuul.bc.product.facade.ClientViewFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *  Test class for the client view presentation layer
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientViewFacadeUnitTest {

    @InjectMocks
    private ClientViewFacade clientViewFacade;
    @Mock
    private ClientViewBL clientViewBL;

    @Test
    public void shouldGetCatalogue() {
        // given
        final List<Catalogue> catalogue = new ArrayList<>();

        Mockito.when(clientViewBL.getCatalogue()).thenReturn(catalogue);

        // when
        final Response result = clientViewFacade.getCatalogue();

        // then
        assertThat(result.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
        assertThat(result.getEntity()).isEqualTo(catalogue);
    }

    @Test
    public void shouldCreateClient() {
        // given

        // when
        clientViewFacade.createClient();

        // then
        Mockito.verify(clientViewBL).createClient();
    }

    @Test
    public void shouldPlaceOrder() {
        // given
        final long id = 1L;
        final String salesman = "bakery";
        final String product = "bread";

        final ArgumentCaptor<Long> idCaptor = ArgumentCaptor.forClass(Long.class);
        final ArgumentCaptor<String> salesmanCaptor = ArgumentCaptor.forClass(String.class);
        final ArgumentCaptor<String> productCaptor = ArgumentCaptor.forClass(String.class);

        // when
        clientViewFacade.placeOrder(id, salesman, product);

        // then
        Mockito.verify(clientViewBL).placeOrder(idCaptor.capture(), salesmanCaptor.capture(), productCaptor.capture());
        assertThat(idCaptor.getValue()).isEqualTo(id);
        assertThat(salesmanCaptor.getValue()).isEqualTo(salesman);
        assertThat(productCaptor.getValue()).isEqualTo(product);
    }

    @Test
    public void shouldGetAllOrders() {
        // given
        final List<Order> allOrders = new ArrayList<>();

        Mockito.when(clientViewBL.getAllOrders()).thenReturn(allOrders);

        // when
        final Response result = clientViewFacade.getAllOrders();

        // then
        assertThat(result.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
        assertThat(result.getEntity()).isEqualTo(allOrders);
    }

    @Test
    public void shouldDeleteAll() {
        // given

        // when
        clientViewFacade.deleteAll();

        // then
        Mockito.verify(clientViewBL).deleteAll();
    }
}
