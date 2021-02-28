package ocp.ch3.GenericsAndCollections.ListsSetsMapsQueues;


import static java.lang.System.*;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// You use a map when you want to identify values by a key

public class UsingMap {
	public static void main(String[] args) {


		// A HashMap stores the keys in a hash table.
		// LinkedHashMap. with order
		// A TreeMap stores the keys in a sorted tree structure

		// void clear() Removes all keys and values from the map.
		// boolean isEmpty() Returns whether the map is empty.
		// int size() Returns the number of entries (key/value pairs) in the map.
		// V get(Object key) Returns the value mapped by key or null if none is mapped.
		// V put(K key, V value) Adds or replaces key/value pair. Returns previous value or null.
		// V remove(Object key) Removes and returns value mapped to key. Returns null if none.
		// boolean containsKey(Object key) Returns whether key is in map.
		// boolean containsValue(Object) Returns value is in map.
		// Set<K> keySet() Returns set of all keys.
		// Collection<V> values() Returns Collection of all values.


		Map<String, String> map = new HashMap<>();
		map.put("koala", "bamboo");
		map.put("lion", "meat");
		map.put("giraffe", "leaf");
		String food = map.get("koala"); // bamboo
		out.println(food);
		for (String key: map.keySet())
			out.print(key + ","); // koala,giraffe,lion,

		out.println();

		map = new TreeMap<>();
		map.put("koala", "bamboo");
		map.put("lion", "meat");
		map.put("giraffe", "leaf");
		food = map.get("koala"); // bamboo
		out.println(food);
		for (String key: map.keySet())
		out.print(key + ","); // giraffe,koala,lion,

		out.println();

		/** out.println(map.contains("lion")); */ // DOES NOT COMPILE
		out.println(map.containsKey("lion")); // true
		out.println(map.containsValue("lion")); // false
		out.println(map.size()); // 3

	}
}
