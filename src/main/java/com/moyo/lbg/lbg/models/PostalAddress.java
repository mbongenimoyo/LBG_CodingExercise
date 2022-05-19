package com.moyo.lbg.lbg.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
@Getter
@Setter
@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel
public class PostalAddress implements Serializable {

    @JsonProperty("AddressLine")
    private ArrayList<String> addressLine =new ArrayList<>() ;

    @JsonProperty("CountrySubDivision")
    private ArrayList<String> countrySubDivision=new ArrayList<>();

    @JsonProperty("StreetName")
    private String streetName;

    @JsonProperty("TownName")
    private String TownName;

    @JsonProperty("Country")
    private  String country;

    @JsonProperty("PostCode")
    private String postCode;
}
