/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */
package com.sinosoft.lis.pubfun;

import java.util.HashMap;
import java.util.Set;
/**
 * <p>Title: Web业务系统</p>
 * <p>Description: 配合自动BLS的Map类，暂不支持Remove方法</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Sinosoft</p>
 * @author Minim
 * @version 1.0
 */
public class MMap
{
    /** 数据的容器 Map Vector */
    private HashMap mapV = null;

    /** 排序的容器 Map Order */
    private HashMap mapO = null;

    /**
     * 构造函数
     */
    public MMap()
    {
        mapV = new HashMap();
        mapO = new HashMap();
    }

    /**
     * 建立键－值对，序号从1开始
     * @param key Object
     * @param value Object
     */
    public void put(Object key, Object value){
        if (key == null || value == null)
            return;
        if (mapV.containsKey(key))
		{
			mapV.put(key, value);
		} else{
			mapV.put(key, value);
			mapO.put(String.valueOf(mapV.size()), key);
		}
    }

    /**
     * 获取键－值Set
     * @return Set
     */
    public Set keySet()
    {
        return mapV.keySet();
    }

    /**
     * 根据键获取值
     * @param key Object
     * @return Object
     */
    public Object get(Object key)
    {
        return mapV.get(key);
    }

    /**
     * 获取排序Map
     * @return HashMap
     */
    public HashMap getOrder()
    {
        return mapO;
    }

    /**
     * 通过序号获取键，序号即插入顺序，从1开始
     * @param order String
     * @return Object
     */
    public Object getKeyByOrder(String order)
    {
        return mapO.get(order);
    }

    /**
     * 添加一个MMap
     * @param srcMap MMap
     */
    public void add(MMap srcMap)
    {
        if (srcMap == null)
            return;
        for (int i = 0; i < srcMap.keySet().size(); i++)
        {
            Object key = srcMap.getKeyByOrder(String.valueOf(i + 1));
            this.put(key, srcMap.get(key));
        }
        
        
    }

//    public static void main(String[] args)
//    {
//    	  MMap map = new MMap();
//
//    	  map.put("key1", "1000");
//    	  map.put("key2", "key2");
//    	  map.put("key11", "1000");
//    	  map.put("key11", "key11");
//    	  map.put("key11", "key12");
//    	  map.put("key31", "key331");
//
//    	  map.put("key1", "1000");
//    	  map.put("key2", "key2");
//    	  map.put("key11", "1000");
//    	  map.put("key11", "key11");
//    	  map.put("key11", "key12");
//    	  map.put("key51", "key51");
//    	  System.out.println(map.keySet().size());
//    	  System.out.println(map.getKeyByOrder("5"));
//    	  System.out.println(map.get("key31"));
////        MMap amap = new MMap();
////        amap.put("key1", "value1");
////        amap.put("key2", "value2");
////        MMap bmap = new MMap();
////        bmap.put("keyb1", "valueb1");
////        bmap.put("keyb2", "valueb2");
////        amap.add(bmap);
////        for (int i = 0; i < amap.keySet().size(); i++)
////        {
////            Object key = amap.getKeyByOrder(String.valueOf(i + 1));
////            System.out.println(amap.get(key).toString());
////        }
//    }
}
