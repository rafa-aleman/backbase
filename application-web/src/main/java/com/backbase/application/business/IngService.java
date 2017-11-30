package com.backbase.application.business;

import com.backbase.application.domain.Atm;

/**
 * ING Service

 * @author Rafael Aleman
 */
public interface IngService {

    /**
     * Get All the ATMs
     * @return the ATMs
     */
    Atm getAtms();
}
