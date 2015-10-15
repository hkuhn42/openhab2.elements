package com.cc.gigaset.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.gson.Gson;

public class JsonToMapImpl implements Transformations {

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, Object> jsonToMap(String json) {
        if (json.trim().startsWith("[") && json.trim().endsWith("]")) {
            json = json.trim().substring(1, json.length() - 1);
        }
        return new Gson().fromJson(json, Map.class);
    }

    @Override
    public void visit(Map<String, Object> map, MapVisitor visitor) throws Exception {
        _visit(map, visitor, 0);
    }

    @SuppressWarnings("unchecked")
    private void _visit(Map<String, Object> map, MapVisitor visitor, int level)
            throws IllegalAccessException, InvocationTargetException, Exception {
        int maxLevel = visitor.getMaxLevel();
        if (level > maxLevel) {
            return;
        }
        for (String key : map.keySet()) {
            if (key != null) {
                Object value = map.get(key);
                if (value == null) {
                    System.out.println("null is " + key);
                    continue;
                }
                if (key.contains("[")) {
                    key = key.substring(0, key.indexOf("["));
                }
                boolean isMap = value instanceof Map;
                boolean isList = value instanceof List;
                boolean isCollection = value instanceof Collection;
                String simpleName = value.getClass().getSimpleName();
                // visit without level
                if (isMap && getMethod(visitor, "onKeyValue", String.class, Map.class) != null) {
                    getMethod(visitor, "onKeyValue", String.class, Map.class).invoke(visitor, key, value);
                } else if (isList && getMethod(visitor, "onKeyValue", String.class, List.class) != null) {
                    getMethod(visitor, "onKeyValue", String.class, List.class).invoke(visitor, key, value);
                } else if (isCollection && getMethod(visitor, "onKeyValue", String.class, Collection.class) != null) {
                    getMethod(visitor, "onKeyValue", String.class, Collection.class).invoke(visitor, key, value);
                } else if (getMethod(visitor, "onKeyValue", String.class, Object.class) != null) {
                    getMethod(visitor, "onKeyValue", String.class, Object.class).invoke(visitor, key, value);
                }
                if (isMap && getMethod(visitor, key, Map.class) != null) {
                    getMethod(visitor, key, Map.class).invoke(visitor, value);
                } else if (getMethod(visitor, key, Object.class) != null) {
                    getMethod(visitor, key, Object.class).invoke(visitor, value);
                }
                if (getMethod(visitor, "on" + camelize(key), Object.class) != null) {
                    getMethod(visitor, "on" + camelize(key), Object.class).invoke(visitor, value);
                }
                if (getMethod(visitor, "on" + simpleName, Object.class) != null) {
                    getMethod(visitor, "on" + simpleName, Object.class).invoke(visitor, value);
                }
                // visit with int level
                if (isMap && getMethod(visitor, "onKeyValue", int.class, String.class, Map.class) != null) {
                    getMethod(visitor, "onKeyValue", int.class, String.class, Map.class).invoke(visitor, level, key,
                            value);
                } else if (isList && getMethod(visitor, "onKeyValue", int.class, String.class, List.class) != null) {
                    getMethod(visitor, "onKeyValue", int.class, String.class, List.class).invoke(visitor, level, key,
                            value);
                } else if (isCollection
                        && getMethod(visitor, "onKeyValue", int.class, String.class, Collection.class) != null) {
                    getMethod(visitor, "onKeyValue", int.class, String.class, Collection.class).invoke(visitor, level,
                            key, value);
                } else if (getMethod(visitor, "onKeyValue", int.class, String.class, Object.class) != null) {
                    getMethod(visitor, "onKeyValue", int.class, String.class, Object.class).invoke(visitor, level, key,
                            value);
                }
                if (isMap && getMethod(visitor, key, int.class, Map.class) != null) {
                    getMethod(visitor, key, int.class, Map.class).invoke(visitor, level, value);
                } else if (getMethod(visitor, key, int.class, Object.class) != null) {
                    getMethod(visitor, key, int.class, Object.class).invoke(visitor, level, value);
                }
                if (getMethod(visitor, "on" + camelize(key), int.class, Object.class) != null) {
                    getMethod(visitor, "on" + camelize(key), int.class, Object.class).invoke(visitor, level, value);
                }
                if (getMethod(visitor, "on" + simpleName, int.class, Object.class) != null) {
                    getMethod(visitor, "on" + simpleName, int.class, Object.class).invoke(visitor, level, value);
                }
                // recursion
                if (value instanceof Map) {
                    _visit((Map<String, Object>) value, visitor, level + 1);
                } else if (value instanceof Collection) {
                    @SuppressWarnings("rawtypes")
                    Collection<?> values = (Collection) value;
                    AtomicInteger i = new AtomicInteger(0);
                    for (Object object : values) {
                        String name = key + "[" + i.getAndIncrement() + "]";
                        if (object instanceof Map) {
                            _visit(Collections.singletonMap(name, object), visitor, level + 1);
                        } else {
                            _visit(Collections.singletonMap(name, object), visitor, level + 1);
                        }
                    }
                }
            }
        }
    }

    private String camelize(String key) {
        return key.substring(0, 1).toUpperCase().concat(key.substring(1));
    }

    private Method getMethod(MapVisitor visitor, String name, Class<?>... parameterTypes) {
        return getMethod01(visitor, name, parameterTypes);
    }

    private Method getMethod01(MapVisitor visitor, String name, Class<?>... parameterTypes) {
        try {
            Method method = visitor.getClass().getMethod(name, parameterTypes);
            method.setAccessible(true);
            return method;
        } catch (NoSuchMethodException e) {
            return getMethod02(visitor, name, parameterTypes);
        } catch (SecurityException e) {
            return getMethod02(visitor, name, parameterTypes);
        }
    }

    private Method getMethod02(MapVisitor visitor, String name, Class<?>... parameterTypes) {
        try {
            Class<?> type = visitor.getClass().getDeclaringClass();
            if (type != null) {
                Method method = type.getMethod(name, parameterTypes);
                method.setAccessible(true);
                return method;
            }
        } catch (NoSuchMethodException e) {
            return null;
        } catch (SecurityException e) {
            return null;
        }
        return null;
    }
}
