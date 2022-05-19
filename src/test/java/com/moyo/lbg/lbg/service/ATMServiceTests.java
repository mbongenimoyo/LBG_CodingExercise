package com.moyo.lbg.lbg.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import com.moyo.lbg.lbg.models.ATMModel;
import com.moyo.lbg.lbg.models.ContentsModel;
import com.moyo.lbg.lbg.service.impl.ATMServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
public class ATMServiceTests {

    ObjectMapper mapper= new ObjectMapper();
    ContentsModel response;

    @Autowired
    private ATMServiceImpl atmService= new ATMServiceImpl();


    public ATMServiceTests() throws IOException {
        String json=Resources.toString(Resources.getResource("Applicationtestcase.json"), Charset.defaultCharset());
        response=mapper.readValue(json, ContentsModel.class);
    }


    @Test
    public void testMapAtmToId() throws IOException {
        prepTestCase();
        ATMModel a=response.getData().get(0).getBrandModel().get(0).getATM().get(0);
        ArrayList<ATMModel> list= new ArrayList<>();
        list.add(a);
        Map<String,ArrayList<ATMModel>> res= atmService.mapAtmsToId(list);
        Assertions.assertEquals(a.getIdentification(),res.get("LFFFBC11").get(0).getIdentification());
        Assertions.assertEquals(a.getSupportedCurrencies(),res.get("LFFFBC11").get(0).getSupportedCurrencies());
    }

//    @Test
//    public void

    private ContentsModel prepTestCase() throws IOException {
        String json=Resources.toString(Resources.getResource("Applicationtestcase.json"), Charset.defaultCharset());
        return response=mapper.readValue(json, ContentsModel.class);
    }
}
