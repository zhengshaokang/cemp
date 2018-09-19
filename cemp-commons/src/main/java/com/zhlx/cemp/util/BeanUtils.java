package com.zhlx.cemp.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.cglib.beans.BeanCopier;

/**
 */
public class BeanUtils {

    private static Map<String, BeanCopier> BEAN_COPIER_MAP = new HashMap<String, BeanCopier>();

    public static <T, E> void copyProperties(T source, E target) {
        if (source == null || target == null) return;
        String beanKey = source.getClass().toString() + target.getClass().toString();
        BeanCopier copier = null;
        if (!BEAN_COPIER_MAP.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            BEAN_COPIER_MAP.put(beanKey, copier);
        } else {
            copier = BEAN_COPIER_MAP.get(beanKey);
        }
        copier.copy(source, target, null);
    }

    public static <T, E> E copyProperties(T source, Class<E> type) {
        if (source == null || type == null) return null;
        try {
            E target = type.newInstance();
            copyProperties(source, target);
            return target;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T, E> List<E> copyList(List<T> source, Class<E> type) {
        if (source == null || type == null) return null;
        List<E> result = new ArrayList<E>(source.size());
        E temp = null;
        for (T o : source) {
            temp = copyProperties(o, type);
            result.add(temp);
        }
        return result;
    }

}
