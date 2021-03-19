package ocp.ch7.Concurrency.UsingConcurrentCollections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UnderstandingMemoryConsistencyErrors {

	public static void main(String[] args) {
		// Map<String, Object> foodData = new HashMap<String, Object>();
		// //java.util.ConcurrentModificationException
		Map<String, Object> foodData = new ConcurrentHashMap<String, Object>();
		foodData.put("penguin", 1);
		foodData.put("flamingo", 2);
		for (String key : foodData.keySet())// here
			foodData.remove(key);

	}

}
