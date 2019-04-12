package cn.zhiu.bean.cloud.disk.entity.enums.convert.file;

import cn.zhiu.bean.cloud.disk.entity.enums.file.Status;
import org.springframework.core.convert.converter.Converter;

import javax.persistence.AttributeConverter;

/**
 * @Auther: yujuan
 * @Date: 19-4-11 14:36
 * @Description:
 */
public class StatusConverter implements AttributeConverter<Status, Integer>, Converter<String, Status> {

    @Override
    public Integer convertToDatabaseColumn(Status value) {
        return value.getValue();
    }

    @Override
    public Status convertToEntityAttribute(Integer integer) {
        return Status.get(integer);
    }

    @Override
    public Status convert(String s) {
        return Status.get(Integer.parseInt(s));
    }
}
