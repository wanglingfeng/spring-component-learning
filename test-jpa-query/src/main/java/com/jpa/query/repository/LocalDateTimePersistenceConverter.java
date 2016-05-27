package com.jpa.query.repository;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by Lingfeng on 2015/12/16.
 */
// @Converter(autoApply = true)添加该注解后该转换器能自动适用；
// 否则需要在实体中添加@Convert(converter = LocalDateTimePersistenceConverter.class)注解
// 可理解为@Converter(autoApply = true)是全局注解，@Convert(converter = LocalDateTimePersistenceConverter.class)是单个使用的注解
public class LocalDateTimePersistenceConverter implements AttributeConverter<LocalDateTime, Timestamp> {
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
        return Timestamp.valueOf(attribute);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
        return dbData.toLocalDateTime();
    }
}
