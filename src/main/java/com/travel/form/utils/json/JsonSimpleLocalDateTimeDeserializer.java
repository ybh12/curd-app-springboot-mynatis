package com.travel.form.utils.json;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * @author by 李泽阳 on 2022/2/8 23:22
 * @description：
 */
public class JsonSimpleLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    /**
     * yyyy-MM-dd HH:mm
     *
     * @return java.time.LocalDateTime
     * @author renwd
     * @since 2021/11/9
     */
    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String date = p.getText();
        if (StrUtil.isEmpty(date)) {
            return null;
        }
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(DateUtil.DEFAULT_YMHA_FORMAT));
    }

}
