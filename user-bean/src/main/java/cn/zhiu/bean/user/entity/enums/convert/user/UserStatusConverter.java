package cn.zhiu.bean.user.entity.enums.convert.user;

import cn.zhiu.bean.user.entity.enums.user.UserStatus;
import org.springframework.core.convert.converter.Converter;

import javax.persistence.AttributeConverter;

/**
 * The type User status converter.
 *
 * @author zhuzz
 * @time 2019 /04/03 16:59:55
 */
public class UserStatusConverter implements AttributeConverter<UserStatus, Integer>, Converter<String, UserStatus> {


    @Override
    public Integer convertToDatabaseColumn(UserStatus userStatus) {
        return userStatus.getValue();
    }

    @Override
    public UserStatus convertToEntityAttribute(Integer integer) {
        return UserStatus.get(integer);
    }

    @Override
    public UserStatus convert(String s) {
        return UserStatus.get(Integer.parseInt(s));
    }
}
