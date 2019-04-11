package cn.zhiu.bean.user.entity.enums.convert.user;

import cn.zhiu.bean.user.entity.enums.user.SexType;
import org.springframework.core.convert.converter.Converter;

import javax.persistence.AttributeConverter;


/**
 * The type Sex type converter.
 *
 * @author zhuzz
 * @time 2019 /04/10 23:15:23
 */
public class SexTypeConverter implements AttributeConverter<SexType, Integer>, Converter<String, SexType> {

    @Override
    public Integer convertToDatabaseColumn(SexType value) {
        return value.getValue();
    }

    @Override
    public SexType convertToEntityAttribute(Integer integer) {
        return SexType.get(integer);
    }

    @Override
    public SexType convert(String s) {
        return SexType.get(Integer.parseInt(s));
    }
}
