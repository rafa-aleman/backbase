package com.backbase.application.business;

import com.backbase.application.client.IngClient;
import com.backbase.application.domain.Atm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ING Service Implementation

 * @author Rafael Aleman
 */
@Service
public class IngServiceImpl implements IngService {

    private final IngClient ingClient;

    @Autowired
    public IngServiceImpl(final IngClient ingClient) {
        this.ingClient = ingClient;
    }

    @Override
    public Atm getAtms() {
        return this.ingClient.getAtms();
    }
}
