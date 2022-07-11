package com.travel.form.utils.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

/**
 * @author by 李泽阳 on 2022/2/6 3:56
 * @description：
 */
public class TimeStampDeserializer extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String dateStr = jsonParser.getValueAsString();
        if (this.isNumeric(dateStr)) {
            return Instant.ofEpochMilli(jsonParser.getLongValue() / 1000).atZone(ZoneId.systemDefault()).toLocalDateTime();
        } else {
            return this.getLocalDateTime(dateStr);
        }

    }

    /**
     * 获取日期
     *
     * @param date d
     * @return LocalDateTime
     */
    public LocalDateTime getLocalDateTime(String date) {
        //格式:2019-09-09
        String pattern = "\\d{4}(\\-|\\/|.)\\d{1,2}\\1\\d{1,2}";
        boolean isVail = Pattern.compile(pattern).matcher(date).matches();
        if (isVail) {
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(DateUtil.DEFAULT_DATE_FORMAT));
            return LocalDateTime.of(localDate, LocalTime.of(0, 0, 0));
        }
        //格式:2019-09-09 01:00
        pattern = "\\d{4}(\\-|\\/|.)\\d{1,2}\\1\\d{1,2}\\s\\d{1,2}:\\d{1,2}";
        isVail = Pattern.compile(pattern).matcher(date).matches();
        if (isVail) {
            return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(DateUtil.DEFAULT_YMHA_FORMAT));
        }
        //格式:2019-09-09 01
        pattern = "\\d{4}(\\-|\\/|.)\\d{1,2}\\1\\d{1,2}\\s\\d{1,2}";
        isVail = Pattern.compile(pattern).matcher(date).matches();
        if (isVail) {
            return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(DateUtil.DEFAULT_YMMV_FORMAT));
        }
        //格式:2019-09-09 01:00:00
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(DateUtil.DEFAULT_DATE_TIME_FORMAT));

    }

    public boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}
