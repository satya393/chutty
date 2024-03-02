//package com.chutty;
//
//import java.io.BufferedReader;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.StringTokenizer;
//
//import jakarta.persistence.Entity;
//
//public class uplodeCsvFile {
//		
//	public static void main(String[] args) {
//
//	
//		try(BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\Prasanth\\1.csv"))){	
//			String str = "";
//			
//			while ((str = br.readLine()) != null) {
//				
//				StringTokenizer tokenizer = new StringTokenizer(str, ",");
//				
//				while(tokenizer.hasMoreElements()) {
//					System.out.print(tokenizer.nextElement());
//				}
//			}
//			
//		}catch(Exception e){
//			System.out.println(e);
//		}
//		
//	}
//
//	
//	
//}
