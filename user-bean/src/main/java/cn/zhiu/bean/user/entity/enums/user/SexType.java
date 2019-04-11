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
 * 性别枚举
 */
public enum SexType {
    Female(0, "女"),
    Male(1, "男"),
    Unknown(2, "未知");

    private static Logger logger = LoggerFactory.getLogger(SexType.class);

    private static final Object _LOCK = new Object();

    private static Map<Integer, SexType> _MAP;
    private static List<SexType> _LIST;
    private static List<SexType> _ALL_LIST;

    static {
        synchronized (_LOCK) {
            Map<Integer, SexType> map = new HashMap<>();
            List<SexType> list = new ArrayList<>();
            List<SexType> listAll = new ArrayList<>();
            for (SexType deleteStatus: SexType.values()) {
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

    SexType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public static SexType get(int value) {
        try {
            return _MAP.get(value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    public static List<SexType> list() {
        return _LIST;
    }

    public static List<SexType> listAll() {
        return _ALL_LIST;
    }
}