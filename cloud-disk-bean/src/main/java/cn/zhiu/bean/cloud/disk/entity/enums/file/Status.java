package cn.zhiu.bean.cloud.disk.entity.enums.file;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: yujuan
 * @Date: 19-4-11 14:34
 * @Description:
 */
public enum Status {
    NORMAL(0, "正常状态"),
    RECYCLE(-1, "已移除到回收站");

    private static Logger logger = LoggerFactory.getLogger(Status.class);

    private static final Object _LOCK = new Object();

    private static Map<Integer, Status> _MAP;
    private static List<Status> _LIST;
    private static List<Status> _ALL_LIST;

    static {
        synchronized (_LOCK) {
            Map<Integer, Status> map = new HashMap<>();
            List<Status> list = new ArrayList<>();
            List<Status> listAll = new ArrayList<>();
            for (Status status : Status.values()) {
                map.put(status.getValue(), status);
                listAll.add(status);
            }

            _MAP = ImmutableMap.copyOf(map);
            _LIST = ImmutableList.copyOf(list);
            _ALL_LIST = ImmutableList.copyOf(listAll);
        }
    }

    private int value;
    private String name;

    Status(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public static Status get(int value) {
        try {
            return _MAP.get(value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    public static List<Status> list() {
        return _LIST;
    }

    public static List<Status> listAll() {
        return _ALL_LIST;
    }
}
