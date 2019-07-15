package ljtao.javase.map.a01_mapSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapSort {
	/**
     * 准备参数，创建对象
     * @return
     */
    private static Map<String, People> getPeopleMap() {
        Map<String,People> PeopleMap = new TreeMap<>();

        // 创建对象
        People b = new People("小明"  , "优秀",  "b");
        People a = new People("小红"  , "合格",  "a");
        People c = new People("丁丁"  , "合格",  "c");
        People d = new People("冬冬"  , "良好",  "d");
        People e = new People("小黄"  , "优秀",  "e");
        People f = new People("小李"  , "良好",  "f");
        People g = new People("小钟"  , "优秀",  "g");


        // 添加乱序key值，把对象放入map集合
        PeopleMap.put("xniem", b);
        PeopleMap.put("akjd", a);
        PeopleMap.put("uioo", c);
        PeopleMap.put("qw84", d);
        PeopleMap.put("584sdf'", e);
        PeopleMap.put("4aisdf", f);
        PeopleMap.put("458jsf", g);
 
        return PeopleMap;
    }

    /**
     * 循环打印Map
     */
    private static void show(Map<String, People> PeopleMap) {
        // 循环Map 这个打印肯定是无序的，也不是按放入的先后顺序
        for (Map.Entry<String, People> PeopleOneMap : PeopleMap.entrySet()) {
            People People = PeopleOneMap.getValue();
           System.out.println(People.getName() + " " + People.getScore()+ " " + People.getId() );
        }
    }
       
      /*
       * 由于List能够直接使用Collections进行排序
       * 但是Map不行。
       * 这边所做的操作就是先将Map--》List
       * 然后对List进行排序
       * 然后在讲List--》转换成LinkedHashMap
       * 
       */
    public static Map<String, People> sortMapByValue(Map<String, People> PeopleMap) {
        if (PeopleMap == null || PeopleMap.isEmpty()) {
            return null;
        }
        // LinkedHashMap是有序的、或者TreeMap都是有序的(这里只能用LinkedHashMap)
        Map<String, People> sortedMap = new LinkedHashMap<String, People>();
      
         /* Set set=PeopleMap.entrySet();  PeopleMap.entrySet()返回的是一个set集合
          * 再讲ArrayList(Collection<? extends E> c) 可以放collection，set集合是其子类，map不行哦
          * 这步就是把map集合转为ArrayList集合 
          */ 
         
        List<Map.Entry<String, People>> entryList = new ArrayList<Map.Entry<String, People>>(PeopleMap.entrySet());
        
       //这步是关键，进过这步之后，entryList已经是个有序的ArrayList集合了
        Collections.sort(entryList, new MapValueComparator());    
        //通过迭代器取出
        Iterator<Map.Entry<String, People>> iter = entryList.iterator();
        // Map.Entry<String, People>,就是包装了一个map节点，这个节点封装了key，value值，以及别的值(比如hashmap中哈希码和next指针)
        Map.Entry<String, People> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
       }
        return sortedMap;
    }
    
    /**
     * 主方法
     * 
     */
    public static void main(String[] args) {
        // 获取Map
        Map<String,People> PeopleMap = getPeopleMap();
        // 打印未排序的Map
        show(PeopleMap);
        System.out.println("-----------before-----------");
        // 打印排序完了的Map
        show(MapSort.sortMapByValue(PeopleMap));
        System.out.println("-----------after------------");
    }
}
