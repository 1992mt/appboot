package com.app.common.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;


/**
 * Copyright: Copyright (c) 2015 zznode
 * 
 * @ClassName: BeanUtil.java
 * @Description: 该类的功能描述
 * 
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2015年4月4日 下午9:51:16
 * 
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2015年4月4日
 *        Administrator v1.0.0 修改原因
 */
public class BeanUtil {

	private static final Logger logger = Logger.getLogger(BeanUtil.class);

	/**
	 * 将一个 Map 对象转化为一个 JavaBean
	 * 
	 * @param type
	 *            要转化的类型
	 * @param map
	 *            包含属性值的 map
	 * @return 转化出来的 JavaBean 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InstantiationException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	@SuppressWarnings("rawtypes")
	public static Object mapToBean(Class type, Map map)
			throws IntrospectionException, IllegalAccessException,
			InstantiationException, InvocationTargetException {
		BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
		Object obj = type.newInstance(); // 创建 JavaBean 对象

		// 给 JavaBean 对象的属性赋值
		PropertyDescriptor[] propertyDescriptors = beanInfo
				.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();

			if (map.containsKey(propertyName)) {
				// 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
				Object value = null;
				try {
					value = map.get(propertyName);
				} catch (Exception e) {
					logger.error(e, e);
				}
				Object[] args = new Object[1];
				args[0] = value;
				descriptor.getWriteMethod().invoke(obj, args);
			}
		}
		return obj;
	}

	/**
	 * 将一个 JavaBean 对象转化为一个 Map
	 * 
	 * @param bean
	 *            要转化的JavaBean 对象
	 * @return 转化出来的 Map 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map beanToMap(Object bean) throws IntrospectionException,
			IllegalAccessException, InvocationTargetException {
		Class type = bean.getClass();
		Map returnMap = new HashMap();
		BeanInfo beanInfo = Introspector.getBeanInfo(type);

		PropertyDescriptor[] propertyDescriptors = beanInfo
				.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			if (!propertyName.equals("class")) {
				Method readMethod = descriptor.getReadMethod();
				Object result = readMethod.invoke(bean, new Object[0]);
				if (result != null) {
					returnMap.put(propertyName, result);
				} else {
					returnMap.put(propertyName, "");
				}
			}
		}
		return returnMap;
	}

	public static boolean isBean(Object obj) {
		boolean flag =true;
		try {
			Class cl = obj.getClass();
			Method[] methods = cl.getMethods();
			for (Method m : methods) {
				String name = m.getName();
				// 判断javabean中是否只有set/get方法,和继承的Object的方法
				if (!name.startsWith("set") && !name.startsWith("get")
						&& !name.equals("equals") && !name.equals("hashCode")
						&& !name.equals("wait") && !name.equals("toString")
						&& !name.equals("getClass") && !name.equals("notify")
						&& !name.equals("notifyAll")) {
					flag = false;
					break;
				}
			}
		} catch (SecurityException e) {
			flag = false;
			logger.error(e);
		}
		return flag;
	}

	public static boolean isMap(Object obj) {
		boolean flag = false;
		if (obj instanceof Map) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 
	 * @Function: BeanUtil::getStringFromMap
	 * @Description: 从map中获取值String
	 * @param mp
	 * @param key
	 * @return
	 * @version: v1.0.0
	 * @author: Administrator
	 * @date: 2015年6月26日 上午11:04:19 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 */
	public static String getStringFromMap(Map mp, String key){
		return (mp.get(key) == null) ? "": mp.get(key).toString();
	}
	
	/**
	 * 
	 * @Function: BeanUtil::getLongFromMap
	 * @Description: 从map中获取值Long
	 * @param mp
	 * @param key
	 * @return
	 * @version: v1.0.0
	 * @author: Administrator
	 * @date: 2015年6月26日 上午11:04:19 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 */
	public static Long getLongFromMap(Map mp, String key){
		return (mp.get(key) == null) ? null: Long.parseLong(mp.get(key).toString());
	}

}
