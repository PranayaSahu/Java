package com.pranaya.java;

public class threadExam extends Thread {

	public static int temp = 1;
	public String message;
	public static boolean status = true;

	public threadExam(String str) {
		super(str);
		message = str;
	}
	
	public void run() {
		synchronized(this){
			System.out.println("Going to call while loop");
			while (temp < 10) {
				if (status) {
					status = false;
					System.out.println(temp);					
					System.out.println("Status updated to false "+status);
					temp++;
					try {
						System.out.println("Thread is going to sleep");
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Out of if condition");
				System.out.println(temp);
				status = true;
				temp++;
				System.out.println("Calling notify method");
				notify();
			}
		}
	}
	public static void main(String[] args) {
		threadExam t1 = new threadExam("This first thread");
		threadExam t2 = new threadExam("This second thread");
		t1.start();
		t2.start();
	}

}
