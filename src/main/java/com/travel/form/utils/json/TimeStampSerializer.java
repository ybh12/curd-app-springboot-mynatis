package com.travel.form.utils.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author by 李泽阳 on 2022/2/6 3:55
 * @description：
 */
public class TimeStampSerializer extends JsonSerializer<LocalDateTime> {
    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        long timeStamp = value.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        gen.writeNumber(timeStamp);
    }
}
