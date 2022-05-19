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
public class ContentsModel implements Serializable {

//    private DateModel dateModel;
    @JsonProperty("meta")
    private Object meta;

    @JsonProperty("data")
    private ArrayList<DataModel> data=new ArrayList<>();


}
