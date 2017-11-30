package com.backbase.application.web.controller;

import com.backbase.application.business.IngService;
import com.backbase.application.business.IngServiceImpl;
import com.backbase.application.client.IngClient;
import com.backbase.application.domain.Atm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * AtmController

 * @author Rafael Aleman
 */
@RestController
@RequestMapping("/atms")
public class ATMController {

    private static final Logger LOGGER = LogManager.getLogger();

    private final IngService ingService;

    @Autowired
    public ATMController(final IngService ingService) {
        this.ingService = ingService;
    }

    /**
     * Get All the ING ATMs
     * @return the ATMs
     */
    @GetMapping("/ing")
    @ResponseStatus(HttpStatus.OK)
    public Atm getINGAtms() {
        LOGGER.debug("Getting ING ATMs");
        return this.ingService.getAtms();
    }

}
