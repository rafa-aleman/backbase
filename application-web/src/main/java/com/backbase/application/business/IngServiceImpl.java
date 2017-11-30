package com.backbase.application.business;

import com.backbase.application.client.IngClient;
import com.backbase.application.domain.Atm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ING Service Implementation

 * @author Rafael Aleman
 */
@Service
public class IngServiceImpl implements IngService {

    private static final Logger LOGGER = LogManager.getLogger();

    private final IngClient ingClient;

    @Autowired
    public IngServiceImpl(final IngClient ingClient) {
        this.ingClient = ingClient;
    }

    @Override
    public List<Atm> getAtms() {
        return this.ingClient.getAtms();
    }
}
