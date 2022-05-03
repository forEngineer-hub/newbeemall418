package ltd.newbee.mall.newbeemall;

import java.util.HashMap;
import java.util.Map;

public class TestLong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", 23);
		String num =  map.get("id").toString();
		System.out.println(Long.parseLong(num));
	}

}
