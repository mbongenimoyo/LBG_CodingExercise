package com.moyo.lbg.lbg.Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import com.moyo.lbg.lbg.models.ATMModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.charset.Charset;

@SpringBootTest
public class ATMModelTests {

    ObjectMapper mapper=new ObjectMapper();

    ATMModel atmModel;

    @Test
    public void testAtmIdGetter() throws IOException {
        prepTestCase();
        Assertions.assertEquals("LFFFBC11",atmModel.getIdentification());

    }

    @Test
    public void testAtmSupportedCurrenciesGetter() throws IOException {
        prepTestCase();
        Assertions.assertEquals("GBP",atmModel.getSupportedCurrencies()[0]);
    }

    @Test
    public void testAtmIdSetter() throws IOException {
        prepTestCase();
        atmModel.setIdentification("TESTID");
        Assertions.assertEquals("TESTID",atmModel.getIdentification());
    }

    @Test
    public void testAtmSupportedCurrenciesSetter() throws IOException {
        prepTestCase();
        atmModel.setSupportedCurrencies(new String[]{"MADE UP MONEY"});
        Assertions.assertEquals("MADE UP MONEY",atmModel.getSupportedCurrencies()[0]);
    }



    private void prepTestCase() throws IOException {
        String json= Resources.toString(Resources.getResource("ModelCases/Atmtestcase.json"), Charset.defaultCharset());
        this.atmModel=mapper.readValue(json, ATMModel.class);
    }
}
