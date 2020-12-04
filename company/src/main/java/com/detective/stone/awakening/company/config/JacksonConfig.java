package com.detective.stone.awakening.company.config;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {

  @Bean
  public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
    DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
    DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    SimpleModule javaTimeModule = new JavaTimeModule();

    // 三大时间对象 序列器
    javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(date))
        .addSerializer(LocalTime.class, new LocalTimeSerializer(time))
        .addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(dateTime));
    // 三大时间对象 反序列器
    javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(date))
        .addDeserializer(LocalTime.class, new LocalTimeDeserializer(time))
        .addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(dateTime));

    Jackson2ObjectMapperBuilder builder = Jackson2ObjectMapperBuilder.json().modules(javaTimeModule);
    // 是否将java.util.Date对象转化为时间戳
//        if (!Optional.ofNullable(true).orElse(
//                true)) {
    builder.simpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        }
    // 忽略不认识的属性名
    builder.failOnUnknownProperties(false);
    // 时区
    builder.timeZone(TimeZone.getDefault());
    return builder;
  }

}
