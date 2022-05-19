package com.moyo.lbg.lbg.Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import com.moyo.lbg.lbg.models.ATMModel;
import com.moyo.lbg.lbg.models.PostalAddress;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.charset.Charset;

@SpringBootTest
public class PostAddressModelTest {

    ObjectMapper mapper=new ObjectMapper();
    PostalAddress postalAddress;

    private void prepTestCase() throws IOException {
        String json= Resources.toString(Resources.getResource("ModelCases/PostAddressCase.json"), Charset.defaultCharset());
        this.postalAddress=mapper.readValue(json, PostalAddress.class);
    }

    @Test
    public void testPostalAddress_AddressLineGetter() throws IOException {
        prepTestCase();
        Assertions.assertEquals("1 VICTORIA ROAD;",postalAddress.getAddressLine().get(0));
    }

    @Test
    public void testPostalAddress_StreetNameGetter() throws IOException {
        prepTestCase();
        Assertions.assertEquals("1 VICTORIA ROAD",postalAddress.getStreetName());
    }

    @Test
    public void testPostalAddress_CountryGetter() throws IOException {
        prepTestCase();
        Assertions.assertEquals("GB",postalAddress.getCountry());
    }

    @Test
    public void testPostalAddress_PostCodeGetter() throws IOException {
        prepTestCase();
        Assertions.assertEquals("DH8 5AE",postalAddress.getPostCode());
    }

}
