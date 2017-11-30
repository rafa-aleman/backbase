package com.backbase.application.business;

import com.backbase.application.client.IngClient;
import com.backbase.application.domain.Atm;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * IngServiceImplTest
 *
 * @author Rafael Aleman
 */
public class IngServiceImplTest {

    private IngService ingService;

    @Mock
    private IngClient ingClient;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.ingService = new IngServiceImpl(ingClient);
    }

    @Test
    public void getAtmsOks() {

        final List<Atm> atms = new ArrayList<>();
        when(this.ingService.getAtms()).thenReturn(atms);

        final List<Atm> result = this.ingService.getAtms();

        assertNotNull(result);
        assertEquals(0, result.size());
        assertEquals(atms, result);
    }

}
