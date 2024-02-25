package com.chutty;

import java.io.File;
import java.util.Scanner;

public class CsvFileExample2 {
	
	public static void main(String[] args) throws Exception {
	
		Scanner sc = new Scanner(new File("C:\\Users\\Prasanth\\1.csv"));
		sc.useDelimiter(" ,");
        while(sc.hasNext()) {
        	System.out.print(sc.next());
        	
        }
        sc.close(); 
	}

}
