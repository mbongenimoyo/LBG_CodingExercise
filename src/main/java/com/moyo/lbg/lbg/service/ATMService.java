package com.moyo.lbg.lbg.service;

import com.moyo.lbg.lbg.models.ATMModel;
import com.moyo.lbg.lbg.models.RequestModel;

import javax.management.BadAttributeValueExpException;
import java.io.IOException;
import java.util.ArrayList;

public interface ATMService {

   public ArrayList<ATMModel> getById(RequestModel requestModel) throws IOException, BadAttributeValueExpException;





}
