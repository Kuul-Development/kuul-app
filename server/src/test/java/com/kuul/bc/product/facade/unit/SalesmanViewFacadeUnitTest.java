package com.kuul.bc.product.facade.unit;

import com.kuul.bc.product.business.SalesmanViewBL;
import com.kuul.bc.product.dto.Product;
import com.kuul.bc.product.dto.Salesman;
import com.kuul.bc.product.entity.SalesmanEntity;
import com.kuul.bc.product.facade.SalesmanViewFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *  Test class for the salesman view presentation layer
 */
@RunWith(MockitoJUnitRunner.class)
public class SalesmanViewFacadeUnitTest {

    @InjectMocks
    private SalesmanViewFacade salesmanViewFacade;
    @Mock
    private SalesmanViewBL salesmanViewBL;

    @Test
    public void shouldAddSalesman() {
        // given
        final String salesman = "bakery";

        final ArgumentCaptor<String> salesmanCaptor = ArgumentCaptor.forClass(String.class);

        // when
        salesmanViewFacade.addSalesman(salesman);

        // then
        Mockito.verify(salesmanViewBL).addSalesman(salesmanCaptor.capture());
        assertThat(salesmanCaptor.getValue()).isEqualTo(salesman);
    }

    @Test
    public void shouldGetAllSalesman() {
        // given
        final List<SalesmanEntity> allSalesman = new ArrayList<>();

        Mockito.when(salesmanViewBL.getAllSalesman()).thenReturn(allSalesman);

        // when
        final Response result = salesmanViewFacade.getAllSalesmen();

        // then
        assertThat(result.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
        assertThat(result.getEntity()).isEqualTo(allSalesman);
    }

    @Test
    public void shouldAddProduct() {
        // given
        final long id = 1L;
        final String product = "Bread";
        final String description = "oven-fresh whole grain bread";
        final long amount = 10L;
        final double price = 3.99;

        final ArgumentCaptor<Long> idCaptor = ArgumentCaptor.forClass(Long.class);
        final ArgumentCaptor<String> productCaptor = ArgumentCaptor.forClass(String.class);
        final ArgumentCaptor<String> descriptionCaptor = ArgumentCaptor.forClass(String.class);
        final ArgumentCaptor<Long> amountCaptor = ArgumentCaptor.forClass(Long.class);
        final ArgumentCaptor<Double> priceCaptor = ArgumentCaptor.forClass(Double.class);

        // when
        salesmanViewFacade.addProduct(id, product, description, amount, price);

        // then
        Mockito.verify(salesmanViewBL).addProduct(idCaptor.capture(),
                                                  productCaptor.capture(),
                                                  descriptionCaptor.capture(),
                                                  amountCaptor.capture(),
                                                  priceCaptor.capture()
                                                 );
        assertThat(idCaptor.getValue()).isEqualTo(id);
        assertThat(productCaptor.getValue()).isEqualTo(product);
        assertThat(descriptionCaptor.getValue()).isEqualTo(description);
        assertThat(amountCaptor.getValue()).isEqualTo(amount);
        assertThat(priceCaptor.getValue()).isEqualTo(price);
    }

    @Test
    public void shouldGetStore() {
        // given
        final long id = 1L;
        final List<Product> productsOfStore = new ArrayList<>();

        Mockito.when(salesmanViewBL.getStore(id)).thenReturn(productsOfStore);

        // when
        final Response result = salesmanViewFacade.getStore(1L);

        // then
        assertThat(result.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
        assertThat(result.getEntity()).isEqualTo(productsOfStore);
    }

    @Test
    public void shouldDeleteAll() {
        // given

        // when
        salesmanViewFacade.deleteAll();

        // then
        Mockito.verify(salesmanViewBL).deleteAll();
    }
}
