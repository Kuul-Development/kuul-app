package com.kuul.bc.product.facade.unit;

import com.kuul.bc.product.business.SupplierViewBL;
import com.kuul.bc.product.facade.SupplierViewFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *  Test class for the supplier view presentation layer
 */
@RunWith(MockitoJUnitRunner.class)
public class SupplierViewFacadeUnitTest {

    @InjectMocks
    private SupplierViewFacade supplierViewFacade;
    @Mock
    private SupplierViewBL supplierViewBL;

    @Test
    public void shouldMarkOrderAsDone() {
        // given
        final long orderId = 1L;

        final ArgumentCaptor<Long> orderIdCapture = ArgumentCaptor.forClass(Long.class);

        // when
        supplierViewFacade.markOrderAsDone(orderId);

        // then
        Mockito.verify(supplierViewBL).markOrderAsDone(orderIdCapture.capture());
        assertThat(orderIdCapture.getValue()).isEqualTo(orderId);
    }
}
