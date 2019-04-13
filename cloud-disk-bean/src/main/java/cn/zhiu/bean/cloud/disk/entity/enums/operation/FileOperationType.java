package cn.zhiu.bean.cloud.disk.entity.enums.operation;

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
 * @Date: 19-4-11 11:40
 * @Description:
 */
public enum FileOperationType {

    UNZIP(1, "解压"),
    TILES(2, "to 3D tiles"),
    SESD(3, "to sesd");

    private static Logger logger = LoggerFactory.getLogger(FileOperationType.class);

    private static final Object _LOCK = new Object();

    private static Map<Integer, FileOperationType> _MAP;
    private static List<FileOperationType> _LIST;
    private static List<FileOperationType> _ALL_LIST;

    static {
        synchronized (_LOCK) {
            Map<Integer, FileOperationType> map = new HashMap<>();
            List<FileOperationType> list = new ArrayList<>();
            List<FileOperationType> listAll = new ArrayList<>();
            for (FileOperationType fileOperationType : FileOperationType.values()) {
                map.put(fileOperationType.getValue(), fileOperationType);
                listAll.add(fileOperationType);
            }

            _MAP = ImmutableMap.copyOf(map);
            _LIST = ImmutableList.copyOf(list);
            _ALL_LIST = ImmutableList.copyOf(listAll);
        }
    }

    private int value;
    private String name;

    FileOperationType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public static FileOperationType get(int value) {
        try {
            return _MAP.get(value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    public static List<FileOperationType> list() {
        return _LIST;
    }

    public static List<FileOperationType> listAll() {
        return _ALL_LIST;
    }
}
