package plutoseleniumproject;

import java.util.HashMap;
import java.util.Set;

public class MapExample {

	public static void main(String[] args) {
		
		HashMap<String,String> expHMap=new HashMap<String,String>();
		expHMap.put("doctorName", "Beth");
		expHMap.put("symptoms", "fever");
		
		System.out.println("Value "+expHMap.get("doctorName"));
		System.out.println("Value "+expHMap.get("symptoms"));
		
		Set<String> keys=expHMap.keySet();
		
		for(String s:keys)
		{
			System.out.println("Value in for loop: "+expHMap.get(s));
			
		}
		
		HashMap<String,String> actualHMap=new HashMap<String,String>();
		actualHMap.put("symptoms", "fever");
		actualHMap.put("doctorName", "Beth");
		
		System.out.println(actualHMap.equals(expHMap));
	}

}
