package com.backbase.application.client;

import com.backbase.application.domain.Atm;
import org.springframework.stereotype.Component;

/**
 * ING REST Client

 * @author Rafael Aleman
 */
@Component
public class IngClient {

    /**
     * Get Atm from ING service
     * @return the Atms
     */
    public Atm getAtms() {
        final Atm atm = new Atm();
        atm.setName("Name ATM");
        return atm;
    }
}
