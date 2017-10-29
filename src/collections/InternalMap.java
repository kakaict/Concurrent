package collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import collections.model.Country;

public class InternalMap {

	
	public static void main(String args[]){
		
		Map<Country, String> m = new HashMap<Country, String>();
		
		Country country1 = new Country(1, "JP");
		
		Country country2 = new Country(3, "VN");

		m.put(country2, "VN");
		m.put(new Country(4, "US"), "US");
		m.put(new Country(5, "FR"), "FR");
		m.put(country1, "JP");

		System.out.println("size : " + m.size());

		m.forEach((k,v) -> {
			Country c = (Country) k;
			System.out.println(c.getId() + " - value :" + v);
		});
		
		HashSet<Country> s = new HashSet<Country>();
		s.add(country1);
		s.add(country2);
		s.add(new Country(4, "US"));
		s.add(new Country(5, "FR"));
		
		System.out.println("In set :");
		for (Object c : s){
			Country t = (Country) c;
			System.out.println(t.getId() + " - " + t.getName());
		}
	}
	
	private static void printf(Object[] t){
		for (int i = 0; i < t.length ; i ++){
			System.out.println(t[i]);
		}
	}
	
}
