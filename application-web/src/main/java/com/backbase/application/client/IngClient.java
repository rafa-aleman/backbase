package com.backbase.application.client;

import com.backbase.application.domain.Atm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * ING REST Client

 * @author Rafael Aleman
 */
@Component
public class IngClient {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String ATM_RESOURCE = "/atms/";

    @Value("${ing.url:https://www.ing.nl/api/locator}")
    private String ingUrl;

    private final ObjectMapper objectMapper;

    /**
     * Public constructor
     */
    public IngClient() {
        this.objectMapper = new ObjectMapper();
    }
    

    /**
     * Get Atm from ING service
     * @return the Atms
     */
    public List<Atm> getAtms() {
        LOGGER.debug("Getting the list of ATMS from ING Server");
        String responseString = this.getAtmFromServer(ingUrl + ATM_RESOURCE);
        if(responseString == null) {
            return null;
        }

        //TODO: Improve with a message converter. This is done because the response is corrupted
        if(!responseString.startsWith("[")) {
            responseString = responseString.substring(responseString.indexOf("["));
        }

        try {
            final Atm[] atms = this.objectMapper.readValue(responseString, Atm[].class);
            return Arrays.asList(atms);
        } catch (IOException e) {
            throw new HttpMessageNotReadableException("Error mapping the object", e);
        }
    }

    /**
     * Get the string from the ing server.
     * Improve with RestTemplate and Converter
     * @param ingAtmUrl the img atm url
     * @return the response
     */
    private String getAtmFromServer(final String ingAtmUrl) {
        try {
            final URL url = new URL(ingAtmUrl);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() !=  200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            final BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            final StringBuffer response = new StringBuffer();
            while ((output = br.readLine()) != null) {
                response.append(output);
            }

            conn.disconnect();
            return response.toString();

        } catch (final Exception e) {
            throw new RuntimeException("Error getting ATM from ING", e);
        }
    }
}
