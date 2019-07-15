package ljtao.javase.set.treeset;

import java.util.Comparator;
import ljtao.javase.map.a01_mapSort.People;

public class MyComparable implements Comparator<People>{  
    
    @Override  
    public int compare(People s1, People s2) {  
     
         // 总分从高到低（注意这里是s2减s1）  
        int num = Integer.parseInt(s2.getScore()) - Integer.parseInt(s1.getScore());  
          
        if(num>0){  
            return 1;  
        }  
        if(num<0){  
            return -1;  
        }  
          
        if(num==0){  
            //这步非常关键，没有这个如果总成绩相同名字不同 ，那set集合就默认是相同元素，就会被覆盖掉  
            return s2.getName().compareTo(s1.getName());  
        }         
            return 0;     
    }     
}
