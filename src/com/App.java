package com;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App extends Thread{
	
    static boolean exists(int[] ints, int k) {

    	List<String> list = new ArrayList<String>();
    	Collections.binarySearch(list, "abv");
    	return Arrays.binarySearch(ints, k) >= 0;
    }

	public static void main(String[] args) throws InterruptedException {
		
	}
	
	public static String findFileInDirectory(String name,File dir)
    {
		System.out.println(dir.getAbsolutePath());
        File[] listFile = dir.listFiles();
        System.out.println(listFile);
        if(listFile !=null && listFile.length > 0){
            for (File fil : listFile) {
        		System.out.println(fil.getAbsolutePath());
                if (fil.isDirectory()) {
                  findFileInDirectory(name,fil.getAbsoluteFile());
                } else if (name.equalsIgnoreCase(fil.getName()) ) {
                    return fil.getAbsolutePath();
                }
            }
        }
        return null;
    } 
	
}
