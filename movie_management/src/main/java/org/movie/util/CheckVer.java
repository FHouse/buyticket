package org.movie.util;

import org.movie.entity.Area;
import org.movie.entity.City;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 乐观锁版本号校对工具类
 * Created by Wkz on 2017/3/16.
 */
public class CheckVer<T> {

    final static String VER="ver";

    /**
     * 验证乐观锁版本号是否一致
     * @param beforeEntity 数据库中的数据映射实例
     * @param afterEntity 请求中的数据映射实例
     * @return  返回处理后实体
     */
    public static <T> T checkVer(Object beforeEntity,Object afterEntity,Class<T> entityClass)throws Exception{
        //获取数据库中的数据映射实例
        Map<String,Object> dbValues = getEntityValues(beforeEntity);
        //获取请求中的数据映射实例
        Map<String,Object> reqValues = getEntityValues(afterEntity);
        //版本号校对,若版本号不一致，则返回null
        //若一致则返回版本号自增1后的实例
        return judgeVer(dbValues,reqValues,entityClass);
    }

    /**
     * 获取指定实体的所有数据
     * @param entityClass 指定的实体
     * @return 返回该实体的所有数据
     * @throws Exception 反射异常重抛
     */
    private static Map<String,Object> getEntityValues(Object entityClass)throws Exception{
        Map<String,Object> fieldValues = new HashMap<String,Object>();
        Class<?> clazz = entityClass.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f:fields) {
            f.setAccessible(true);
            fieldValues.put(f.getName(),f.get(entityClass));
        }
        return fieldValues;
    }

    /**
     * 判断版本号是否一致，不一致的话返回提示信息
     * 若版本号一致，则返回将版本号自增一后设置会请求的实体中
     * @param dbValues 数据库中的数据
     * @param reqValues 请求中的数据
     * @param entityClass 实例的Class对象
     * @return 返回更改版本号后的实例
     * @throws Exception 若版本号不一致时，抛出异常
     */
    private static <T> T judgeVer(Map<String,Object> dbValues,Map<String,Object> reqValues,Class<T> entityClass)throws Exception{
        Object instance = entityClass.newInstance();
        Field[] fields = entityClass.getDeclaredFields();
        if((int)dbValues.get(VER) == (int)(reqValues.get(VER))){
            for (Field f:fields) {
                f.setAccessible(true);
                if(VER.equals(f.getName())){
                    int ver = (int)reqValues.get(f.getName());
                    ver+=1;
                    f.set(instance,ver);
                }else{
                    f.set(instance,reqValues.get(f.getName()));
                }
            }
            return (T)instance;
        }else{
            throw new Exception("版本号不一致");
        }
    }

    //测试方法
    public static void main(String[] args) throws Exception {
        City city1 = new City();
        city1.setCityId("12322");
        city1.setCityName("sdfsdf");
        city1.setVer(1);
        Area area1 = new Area();
        area1.setAreaId("123");
        area1.setAreaName("sss");
        area1.setVer(1);
        area1.setCity(city1);

        Area area2 = new Area();
        area2.setAreaId("123");
        area2.setAreaName("sss");
        area2.setVer(3);
        area2.setCity(city1);

        Area area = checkVer(area1,area2,Area.class);
        if(area == null){

        }else{
            System.out.println(area.getAreaId());
            System.out.println(area.getAreaName());
            System.out.println(area.getVer());
            System.out.println(area.getCity());
        }
    }
}
