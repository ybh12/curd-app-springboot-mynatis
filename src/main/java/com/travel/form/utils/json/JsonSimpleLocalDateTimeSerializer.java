package com.travel.form.utils.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * @author by 李泽阳 on 2022/2/8 23:22
 * @description：
 */
public class JsonSimpleLocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    /**
     * yyyy-MM-dd HH:mm
     *
     * @author renwd
     * @since 2021/11/9
     */
    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(DateUtil.DEFAULT_YMHA_FORMAT);
        gen.writeString(dateFormat.format(value));
    }

}
