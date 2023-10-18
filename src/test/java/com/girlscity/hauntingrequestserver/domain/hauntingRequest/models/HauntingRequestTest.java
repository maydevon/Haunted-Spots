package com.girlscity.hauntingrequestserver.domain.hauntingRequest.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class HauntingRequestTest {
    @Test
    public void constructorTest01(){
        Date date = new Date();
        HauntingRequest request = new HauntingRequest("The Dickinson Mansion", "340 Kitts Hummock Rd, Dover, DE 19901");
        request.setId(1L);

        String expected = "1 The Dickinson Mansion 340 Kitts Hummock Rd, Dover, DE 19901";
        String actual = request.toString();

        Assertions.assertEquals(expected, actual);
    }

}