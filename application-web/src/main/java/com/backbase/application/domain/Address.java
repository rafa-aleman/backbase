package com.backbase.application.domain;

import lombok.Data;

/**
 * Address
 *
 * @author Rafael Aleman
 */
@Data
public class Address {

    private String street;
    private String housenumber;
    private String postalcode;
    private String city;

    private GeoLocation geoLocation;

}
