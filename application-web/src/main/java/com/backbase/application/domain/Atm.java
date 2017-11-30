package com.backbase.application.domain;

import lombok.Data;

/**
 * Representation of Atm
 *
 * @author Rafael Aleman
 */
@Data
public class Atm {

    private Address address;
    private Integer distance;
    private String type;


}
