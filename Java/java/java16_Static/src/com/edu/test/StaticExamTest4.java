package com.edu.test;

public class StaticExamTest4 {
	static int i=0;
	
	//1.main method - static block
	public static void main(String[] args) {
		System.out.println("1. main method block : "+i);	//0

	}//main
	
	//2.static initialization(√ ±‚»≠)
	static {
		i=300;
		System.out.println("2. static initialization block : "+i);	//300
	}

}//class