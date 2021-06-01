package com.covidcenter.covidcenter.model;

import com.covidcenter.covidcenter.enums.BookingStatusCode;
import com.covidcenter.covidcenter.enums.BookingTypeCode;
import com.google.gson.*;

import java.lang.reflect.Type;

public class TestUpdateDeserializer implements JsonDeserializer<Booking> {
    @Override
    public Booking deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jsonObject= jsonElement.getAsJsonObject();
        BookingStatus status=new BookingStatus(BookingStatusCode.getCodeByNumber(Integer.valueOf(jsonObject.get("testResult").getAsString())));
        return new Booking(jsonObject.get("cprNumber").getAsInt(),jsonObject.get("testTime").getAsString(),"",status,
                new BookingType(BookingTypeCode.test),0);
    }
}
