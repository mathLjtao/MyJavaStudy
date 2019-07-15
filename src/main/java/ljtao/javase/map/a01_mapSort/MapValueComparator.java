package ljtao.javase.map.a01_mapSort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MapValueComparator implements Comparator<Map.Entry<String, People>> {
	
	@Override
	public int compare(Map.Entry<String, People> o1, Map.Entry<String, People> o2) {
		int cr;
		Map<String,Integer> map=new HashMap<>();
		map.put("优秀", 3);
		map.put("良好",2);
		map.put("合格", 1);
		
		
		cr=map.get(o1.getValue().getScore())-map.get(o2.getValue().getScore());
		cr=-cr;
		if(cr==0){
			cr=o1.getValue().getId().compareTo(o2.getValue().getId());
		}
		return cr;
	}

}
