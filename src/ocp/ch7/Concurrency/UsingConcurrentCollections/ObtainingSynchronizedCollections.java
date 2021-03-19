package ocp.ch7.Concurrency.UsingConcurrentCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//synchronized List

public class ObtainingSynchronizedCollections {

	public static void main(String[] args) {

		List<Integer> list = Collections.synchronizedList(new ArrayList<>(Arrays.asList(4, 3, 52)));
		synchronized (list) { // bloc sync
			for (int data : list)
				System.out.print(data + " ");
		}

		Map<String, Object> foodData = new HashMap<String, Object>();
		foodData.put("penguin", 1);
		foodData.put("flamingo", 2);
		Map<String, Object> synchronizedFoodData = Collections.synchronizedMap(foodData);
		//for (String key : synchronizedFoodData.keySet()) //java.util.ConcurrentModificationException
			//synchronizedFoodData.remove(key);

	}

}
