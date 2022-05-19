package com.moyo.lbg.lbg.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@ApiModel
public class BrandModel implements Serializable {

    @JsonProperty("BrandName")
    private String brandName;

    @JsonProperty("ATM")
    private ArrayList<ATMModel> ATM=new ArrayList<>();
}
