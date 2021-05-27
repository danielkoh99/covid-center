package com.covidcenter.covidcenter.model;

import com.covidcenter.covidcenter.enums.BookingStatusCode;
import com.google.gson.*;

import java.lang.reflect.Type;

public class BookingDeserializer implements JsonDeserializer<Booking> {

    @Override
    public Booking deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject= jsonElement.getAsJsonObject();
        return new Booking(jsonObject.get("idbookings").getAsInt(),jsonObject.get("time").getAsString(),jsonObject.get("endTime").getAsString(),new BookingStatus(BookingStatusCode.pending),
                new BookingType(jsonObject.get("bookingType_idbookingType").getAsInt()),jsonObject.get("user_id_user").getAsInt());
    }
}
