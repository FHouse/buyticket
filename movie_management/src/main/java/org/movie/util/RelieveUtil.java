package org.movie.util;

import org.hibernate.LazyInitializationException;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 双向关联关系解除工具类
 * Created by Wkz on 2017/3/31.
 */
public class RelieveUtil {

    private static List<Class<?>> list = new ArrayList<>();

    static {
        list.add(Integer.TYPE);
        list.add(Long.TYPE);
        list.add(Double.TYPE);
        list.add(Float.TYPE);
        list.add(Character.TYPE);
        list.add(Byte.TYPE);
        list.add(Boolean.TYPE);
        list.add(Short.TYPE);
        list.add(Integer.class);
        list.add(Long.class);
        list.add(Double.class);
        list.add(Float.class);
        list.add(Character.class);
        list.add(Byte.class);
        list.add(Boolean.class);
        list.add(Short.class);
        list.add(String.class);
        list.add(java.util.Date.class);
        list.add(java.sql.Date.class);
        list.add(java.sql.Timestamp.class);
        list.add(java.sql.Time.class);
        list.add(BigDecimal.class);
    }

    /**
     * 解除双向关联关系
     * @param targetObject 需要解关系的对象
     * @throws IllegalAccessException
     */
    public static void relieve(Object targetObject){
        //获取目标Class对象
        Class<?> targetClazz = targetObject.getClass();
        //获取所有属性
        Field[] fields = targetClazz.getDeclaredFields();
        try {
            //遍历目标类所有的属性
            ergodicTargetAttribute(fields,targetObject,targetClazz);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历目标类所有的属性
     * @param fields
     * @param targetObject
     * @param targetClazz
     * @throws IllegalAccessException
     */
    private static void ergodicTargetAttribute(Field[] fields,Object targetObject,Class<?> targetClazz) throws IllegalAccessException {
        //遍历属性，若为自定义类类型或set集合类型，那么解除关系
        for (Field field:fields) {
            field.setAccessible(true);
            //判断是否为自定义类型，或set集合类型
            if(list.indexOf(field.getType()) == -1){
                //如果为set集合类型属性，那么进行set集合关系解除
                //若为普通自定义类型，那么进行普通类型关系解除
                if(field.getType().equals(Set.class)){
                    Set set = (Set) field.get(targetObject);
                    try{
                        set.size(); //作为判断介质受用，无实际意义
                        relieveSet(field,targetObject,targetClazz);
                    }catch(LazyInitializationException e){
                        field.set(targetObject,null);
                    }
                }else{
                    try{
                        if(field.get(targetObject) != null){
                            relieveOrdinary(field,targetObject,targetClazz);
                        }
                    }catch(LazyInitializationException e){
                        field.set(targetObject,null);
                    }
                }
            }
        }
    }

    /**
     * set集合类型关系解除
     * @param field
     * @param targetObject
     * @param targetClazz
     * @throws IllegalAccessException
     */
    private static void relieveSet(Field field,Object targetObject,Class<?> targetClazz) throws IllegalAccessException {
        //循环遍历set集合，获取set集合中的数据
        for (Object coverObject:(Set)field.get(targetObject)) {
            //关系解除
            relationBroken(coverObject,targetClazz);
        }
    }

    /**
     * 普通自定义类型关系解除
     * @param field
     * @param targetObject
     * @param targetClazz
     * @throws IllegalAccessException
     */
    private static void relieveOrdinary(Field field,Object targetObject,Class<?> targetClazz) throws IllegalAccessException {
        Object coverObject = field.get(targetObject);
        //关系解除
        relationBroken(coverObject,targetClazz);
    }

    /**
     * 关系解除
     * @param coverObject
     * @param targetClazz
     * @throws IllegalAccessException
     */
    private static void relationBroken(Object coverObject,Class<?> targetClazz) throws IllegalAccessException {
        Class<?> clazz = coverObject.getClass();
        //遍历指定对象的属性，并进行相应的关系解除
        Field[] fields = clazz.getDeclaredFields();
        for (Field f:fields) {
            f.setAccessible(true);
            //解除所有的双向关联关系
            if(list.indexOf(f.getType()) == -1){
                f.set(coverObject,null);
            }
        }
    }
}
