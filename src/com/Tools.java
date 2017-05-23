package com;
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


public class Tools {

	//change 1
	//change 2 on Github 
	//change 2 in the same time from eclipse 
	
	//change 3 from Github  
	
	//change 4 from eclipse
	
	//change 5 eclipse
	// change 5 github
	// change6 github to fetch 
	
	public static void main(String args[]) throws Exception{
		
		testSynMap();
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
	 
	public static Map<String, Integer> crunchifyHashTableObject = null;
	public static Map<String, Integer> crunchifySynchronizedMapObject = null;
	public static Map<String, Integer> crunchifyConcurrentHashMapObject = null;
	
	public static void crunchifyPerformTest(final Map<String, Integer> crunchifyThreads) throws InterruptedException {
		 
		System.out.println("Test started for: " + crunchifyThreads.getClass());
		long averageTime = 0;
		
		for (int i = 0; i < 5; i++) {
			long startTime = System.nanoTime();
			ExecutorService crunchifyExServer = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
 
			for (int j = 0; j < THREAD_POOL_SIZE; j++) {
				crunchifyExServer.execute(new Runnable() {
					@SuppressWarnings("unused")
					@Override
					public void run() {
 
						for (int i = 0; i < 500000; i++) {
							Integer crunchifyRandomNumber = (int) Math.ceil(Math.random() * 550000);
 
							Integer crunchifyValue = crunchifyThreads.get(String.valueOf(crunchifyRandomNumber));

							crunchifyThreads.put(String.valueOf(crunchifyRandomNumber), crunchifyRandomNumber);
						}
					}
				});
			}
 
			// Make sure executor stops
			crunchifyExServer.shutdown();
 
			// Blocks until all tasks have completed execution after a shutdown request
			crunchifyExServer.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
 
			long entTime = System.nanoTime();
			long totalTime = (entTime - startTime) / 1000000L;
			averageTime += totalTime;
			System.out.println("2500K entried added/retrieved in " + totalTime + " ms");
		}
		System.out.println("For " + crunchifyThreads.getClass() + " the average time is " + averageTime / 5 + " ms\n");
	}
	
	public static void testSynMap() throws InterruptedException {
		 
		// Test with Hashtable Object
		crunchifyHashTableObject = new Hashtable<String, Integer>();
		crunchifyPerformTest(crunchifyHashTableObject);
 
		// Test with synchronizedMap Object
		crunchifySynchronizedMapObject = Collections.synchronizedMap(new HashMap<String, Integer>());
		crunchifyPerformTest(crunchifySynchronizedMapObject);
 
		// Test with ConcurrentHashMap Object
		crunchifyConcurrentHashMapObject = new ConcurrentHashMap<String, Integer>();
		crunchifyPerformTest(crunchifyConcurrentHashMapObject);
 
	}
}
