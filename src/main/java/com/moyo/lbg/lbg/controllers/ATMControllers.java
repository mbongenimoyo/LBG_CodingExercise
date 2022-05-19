package com.moyo.lbg.lbg.controllers;

import com.moyo.lbg.lbg.aspects.ControllerTracking;
import com.moyo.lbg.lbg.aspects.TrackExecutionTime;
import com.moyo.lbg.lbg.models.ATMModel;
import com.moyo.lbg.lbg.models.RequestModel;
import com.moyo.lbg.lbg.models.ResponseModel;
import com.moyo.lbg.lbg.service.ATMService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.BadAttributeValueExpException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api("ATM Conttollers")
@RequestMapping("/")
public class ATMControllers {


    @Autowired
    ATMService atmService;


    @GetMapping
    @ControllerTracking
    @TrackExecutionTime
    @ApiOperation("Retrieve data for ATM specified by id")
    public ResponseModel getIdentificationValues(@RequestBody RequestModel requestModel) throws IOException, BadAttributeValueExpException {
        return new ResponseModel(requestModel.getIdentification(),atmService.getById(requestModel));

    }
}
