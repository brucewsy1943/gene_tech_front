package com.genetech.utils;

import com.genetech.bean.OrderDetail;
import com.genetech.bean.dto.OrderDetailDto;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/12/19.
 */
public class SpringUtil<T>{

    public List<? extends T> convertBeanToDto(List<T> sourceList,Class<? extends T> clazzTarget,String classPath) throws IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException {

        List targetList = new ArrayList<>();
        for ( T source:sourceList) {
            Object target = clazzTarget.newInstance();
            ConvertUtils.register(new DateConverter(null), java.math.BigDecimal.class);
            //org.springframework.beans.BeanUtils.
           BeanUtils.copyProperties(target,source);
            targetList.add(target);
        }
        return targetList;
    }

    //获取某个类所有的属性名
    public static List<String> getAllFieldNamesInClass(Class clazz) throws NoSuchMethodException {
        List<String> result = new ArrayList<>();
        Field[] field = clazz.getDeclaredFields();  //获取实体类的所有属性，返回Field数组
        for (int j = 0; j < field.length; j++) {  //遍历所有属性
            String name = field[j].getName();    //获取属性的名字
            if (name.equals("id")){
                continue;
            }
            result.add(name);
        }
        return result;
    }
}
