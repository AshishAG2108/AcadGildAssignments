package com.acadgild.Servlet;

import java.util.LinkedList;

public class Test implements Runnable{
	
	private static int value =20;
	public int s=10;
	public static int temp =10;
	
	
	
	public void run()
	{
		System.out.printf("%d", 3);
	}
	public static void main(String[] args) {
		
		try {
			Thread thread = new Thread(new Test());
			thread.start();
			System.out.printf("%d", 1);
			thread.join();
			System.out.printf("%d", 2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
