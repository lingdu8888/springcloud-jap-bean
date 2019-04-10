package cn.zhiu.bean.user.entity.enums.user;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The enum User status.
 *
 * @author zhuzz
 * @time 2019 /04/03 16:42:31
 */
public enum  UserStatus {

    NORMAL(0,"正常"),
    DELETE(1,"删除");

    private static Logger logger = LoggerFactory.getLogger(UserStatus.class);

    private static final Object _LOCK = new Object();

    private static Map<Integer, UserStatus> _MAP;
    private static List<UserStatus> _LIST;
    private static List<UserStatus> _ALL_LIST;

    static {
        synchronized (_LOCK) {
            Map<Integer, UserStatus> map = new HashMap<>();
            List<UserStatus> list = new ArrayList<>();
            List<UserStatus> listAll = new ArrayList<>();
            for (UserStatus  deleteStatus: UserStatus.values()) {
                map.put(deleteStatus.getValue(), deleteStatus);
                listAll.add(deleteStatus);
            }

            _MAP = ImmutableMap.copyOf(map);
            _LIST = ImmutableList.copyOf(list);
            _ALL_LIST = ImmutableList.copyOf(listAll);
        }
    }

    private int value;
    private String name;

    UserStatus(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public static UserStatus get(int value) {
        try {
            return _MAP.get(value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    public static List<UserStatus> list() {
        return _LIST;
    }

    public static List<UserStatus> listAll() {
        return _ALL_LIST;
    }
}
