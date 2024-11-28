package com.asouwn;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LambdaFactory {
    private static final Map<String, Supplier<Interface>> map = new HashMap<>(){
        {
            put("a", A::new);
        }
    };

    public static Interface getInstance() {
        return getInstance("a");
    }
    public static Interface getInstance(String key) {
        return map.get(key).get();
    }
    
}
