package com.sm.util;

import java.util.List;

public class StringUtils {
    public static boolean isBlank(String str) {
        return str == null || "".equals(str.trim());
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static String join(List<String> list, String split) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        String joinStr = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            joinStr += split + list.get(i);
        }
        return joinStr;
    }
}
