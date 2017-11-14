package com.mycompany.app;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
//public class HashMapTest {
  public class App{
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<String,String>();
        //增加操作，键和值
        map.put("姓名", "张非");
        map.put("密码", "123");
        map.put("邮箱", "hh@163.com");
        map.put("姓名", "李斯");
        System.out.println(map);//重写了toString()方法

        //修改操作，根据指定的键以新值换旧值
        map.put("姓名","王剑");
        System.out.println(map);
        //查找操作
        System.out.println(map.containsKey("姓名"));//false
        System.out.println(map.containsValue("张非"));//true

        System.out.println("--------------------------");
        //第一种输出方式：迭代所有的Key值，再通过get(key)方法得到value
        Set<String> set=map.keySet();
        Iterator<String> it=set.iterator();
        while(it.hasNext()){
            String key=it.next();
            String value=map.get(key);
            System.out.println(key+":"+value);
        }
        System.out.println("------------------------");
        //第二中输出方式：通过Map.Entry和getKey(),getValue()方法
        Set<Map.Entry<String, String>> entry=map.entrySet();
        Iterator<Map.Entry<String, String>> entryIt=entry.iterator();
        while(entryIt.hasNext()){
            Map.Entry<String, String> me=entryIt.next();
            String key=me.getKey();
            String value=me.getValue();
            System.out.println(key+":"+value);
        }
        System.out.println("----------------------------");
        //第三种输出方式：只得到value的方法
        Collection<String> col=map.values();
        Iterator<String> colIt=col.iterator();
        while(colIt.hasNext()){
            String value=colIt.next();
            System.out.println(value);
        }

    }
}