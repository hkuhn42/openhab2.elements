package com.cc.gigaset.common;

import java.util.Map;

public interface Transformations {

    Map<String, Object> jsonToMap(String json);

    void visit(Map<String, Object> map, MapVisitor visitor) throws Exception;
}
