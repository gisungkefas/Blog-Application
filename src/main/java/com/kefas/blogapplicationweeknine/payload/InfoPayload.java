package com.kefas.blogapplicationweeknine.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class InfoPayload {

    @NotBlank
    private String street;

    @NotBlank
    private String suite;

    @NotBlank
    private String city;

    @NotBlank
    private String zipcode;

    private String companyName;

    private String catchPhrase;

    private String phone;

    private String lat;

    private String lng;
}
