package com.concurrent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class MapMultiThreadDemo {
	
	public static void main(String args[]) throws Exception{
		testPerformanceSynchronizedMap();
	}
	
	public static void testMap(){
		
		TreeMap<Object, Object> t = new TreeMap<Object, Object>();
		t.put("v4", "v4");
		t.put("v2", "v2");
		t.put("v3", "v3");
		
		LinkedHashMap<Object, Object> l = new LinkedHashMap<Object, Object>();
		l.put("v4", "v4");
		l.put("v2", "v2");
		l.put("v3", "v3");		
		
		printMap(l);
		printMap(t);
	}

	private static void printMap(Map<Object, Object> t) {
		System.out.println("------------------");
		for(Entry<Object, Object> e : t.entrySet()){
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}
	
	public final static int THREAD_POOL_SIZE = 5;
	 
	public static Map<String, Integer> hashTableObject = null;
	public static Map<String, Integer> synchronizedMapObject = null;
	public static Map<String, Integer> crunchifyConcurrentHashMapObject = null;
	
	public static void testPerformanceMap(final Map<String, Integer> crunchifyThreads) throws InterruptedException {
		 
		System.out.println("Test started for: " + crunchifyThreads.getClass());
		long averageTime = 0;
		
		for (int i = 0; i < 5; i++) {
			long startTime = System.nanoTime();
			ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
			for (int j = 0; j < THREAD_POOL_SIZE; j++) {
				service.execute(new Runnable() {
					@Override
					public void run() {
						for (int i = 0; i < 500000; i++) {
							Integer crunchifyRandomNumber = (int) Math.ceil(Math.random() * 550000);
							crunchifyThreads.put(String.valueOf(crunchifyRandomNumber), crunchifyRandomNumber);
						}
					}
				});
			}
 
			// Make sure executor stops
			service.shutdown();
 
			// Blocks until all tasks have completed execution after a shutdown request
			service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
			long entTime = System.nanoTime();
			long totalTime = (entTime - startTime) / 1000000L;
			averageTime += totalTime;
			System.out.println("2500K entried added/retrieved in " + totalTime + " ms");
		}
		System.out.println("For " + crunchifyThreads.getClass() + " the average time is " + averageTime / 5 + " ms\n");
	}
	
	public static void testPerformanceSynchronizedMap() throws InterruptedException {
		 
		// Test with Hashtable Object
		hashTableObject = new Hashtable<String, Integer>();
		testPerformanceMap(hashTableObject);
 
		// Test with synchronizedMap Object
		synchronizedMapObject = Collections.synchronizedMap(new HashMap<String, Integer>());
		testPerformanceMap(synchronizedMapObject);
 
		// Test with ConcurrentHashMap Object
		crunchifyConcurrentHashMapObject = new ConcurrentHashMap<String, Integer>();
		testPerformanceMap(crunchifyConcurrentHashMapObject);
 
	}
}
