package com.asouwn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.hutool.core.io.resource.ResourceUtil;


/**
 * 
 */
public class SpiLoader {
    /**
     * 资源加载路径
     * resource/Interface
     */
    private static final String Pre_Dir = "Interface/";
    /**
     * 接口 =》 （实现类名 =》 实现类）
     */
    private static final Map<String, Map<String, Class<?>>> loadMap = new ConcurrentHashMap<>();
    /**
     * 实例缓存 实现类名 =》 实例
     */
    private static final Map<String, Object> instanceCache = new ConcurrentHashMap<>();
    
    /**
     * 通过接口获取实现类
     * @param loadInterface
     * @return
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    public static Map<String, Class<?>> loda(Class<?> loadInterface) throws IOException, ClassNotFoundException {
        String scanDir = Pre_Dir + loadInterface.getName();
        List<URL> recources = ResourceUtil.getResources(scanDir);

        Map<String, Class<?>> keyClassMap = new HashMap<>();
        for (URL recource : recources) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(recource.openStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] split = line.split("=");
                    String key = split[0];
                    String className = split[1];
                    keyClassMap.put(key, Class.forName(className));
                }
            }
        }
        loadMap.put(loadInterface.getName(), keyClassMap);
        return keyClassMap;
    }

    public static <T> T getInstance(Class<?> loadInterface, String key) {
        Map<String, Class<?>> keyClassMap = loadMap.get(loadInterface.getName());
        if (keyClassMap.isEmpty())
            System.out.println(String.format("SpiLoader中未存在 %s 类型", loadInterface.getName()));
        if (!keyClassMap.containsKey(key)) 
            System.out.println(String.format("SpiLoader中未存在 %s 类型的 %s 实现类", loadInterface.getName(), key));
        
        Class<?> implClass = keyClassMap.get(key);
        if (!instanceCache.containsKey(implClass.getName()))
            try {
                instanceCache.put(implClass.getName(), implClass.getDeclaredConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | 
                    InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        return (T) instanceCache.get(implClass.getName());
    }

}