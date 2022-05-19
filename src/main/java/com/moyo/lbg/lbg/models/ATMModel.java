package com.moyo.lbg.lbg.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel
public class ATMModel implements Serializable {

    @JsonProperty("Identification")
    private String identification;

    @JsonProperty("SupportedCurrencies")
    String[] supportedCurrencies;

    @JsonProperty("Location")
    private LocationModel locationModel;


//    @Override
//    public boolean equals(Object o){
//        if(o==null){
//            return false;
//        }
//        if(o.getClass()!=this.getClass()){
//            return false;
//        }
//        final ATMModel atm=(ATMModel)o ;
//        if(this.identification!=atm.identification){
//            if()
//            reeturn true;
//        }
//    }

}
