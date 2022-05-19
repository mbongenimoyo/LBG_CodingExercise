package com.moyo.lbg.lbg.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ResponseModel {

    private String identification;

    private ArrayList<ATMModel> atmModels=new ArrayList<>();

    public ResponseModel(String id,ArrayList<ATMModel> atmModel){

        this.identification=id;
        this.atmModels=atmModel;

    }
}
