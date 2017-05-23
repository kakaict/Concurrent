package com;

import java.util.concurrent.atomic.AtomicInteger;

public class Concurrent {
	
	private AtomicInteger atomicInt; 
	
	public int  atomiqueValue(){
		
		return atomicInt.incrementAndGet();
	}

}
