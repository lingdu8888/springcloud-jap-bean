package cn.zhiu.bean.cloud.disk.entity.enums.convert.operation;


import cn.zhiu.bean.cloud.disk.entity.enums.operation.FileOperationType;
import org.springframework.core.convert.converter.Converter;

import javax.persistence.AttributeConverter;


/**
 * @Auther: yujuan
 * @Date: 19-4-11 11:46
 * @Description:
 */
public class FileOperationTypeConvert implements AttributeConverter<FileOperationType, Integer>, Converter<String, FileOperationType> {

    @Override
    public Integer convertToDatabaseColumn(FileOperationType fileOperationType) {
        return fileOperationType.getValue();
    }

    @Override
    public FileOperationType convertToEntityAttribute(Integer integer) {
        return FileOperationType.get(integer);
    }

    @Override
    public FileOperationType convert(String s) {
        return FileOperationType.get(Integer.parseInt(s));
    }
}
