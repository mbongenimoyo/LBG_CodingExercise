package com.moyo.lbg.lbg.models;


import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;

@Getter
@Setter
@EntityScan
@ApiModel
public class RequestModel implements Serializable {

    String url;

    String identification;

    public RequestModel(){

    }



    @Override
    public String toString(){
        return "RequestModel{" + "url="+url
                +", Identification="+identification+"}";
    }
}
