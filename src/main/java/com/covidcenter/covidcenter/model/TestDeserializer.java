package com.covidcenter.covidcenter.model;

import com.covidcenter.covidcenter.enums.BookingStatusCode;
import com.covidcenter.covidcenter.enums.BookingTypeCode;
import com.google.gson.*;

import java.lang.reflect.Type;

public class TestDeserializer implements JsonDeserializer<Booking> {
    @Override
    public Booking deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jsonObject= jsonElement.getAsJsonObject();
        BookingStatus status=null;
        if(jsonObject.get("testResult").getAsString().equals("positive")){
            status=new BookingStatus(BookingStatusCode.positive);
        }
        else{
            status=new BookingStatus(BookingStatusCode.negative);

        }
        return new Booking(0,jsonObject.get("testTime").getAsString(),"",status,
                new BookingType(BookingTypeCode.test),jsonObject.get("cprNumber").getAsInt());
    }
}
