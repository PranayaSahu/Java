package com.pranaya.java;

class Q1{
	public static boolean state=true;
	public static int value=0;
	public synchronized void print(String name){
		while(value<20){
			if(state){
				state=false;
				System.out.println(name+" "+value);
				value++;
				try {
					System.out.println(name+"  going to sleep");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				state=true;
				System.out.println(name+" "+value);
				value++;
				System.out.println(name+" going to call notify");
				notify();
			}
		}
	}
}

public class ThreadExampleNumberInSequence extends Thread {
	 public static Q1 q;
	 
	 public ThreadExampleNumberInSequence(String str){
		 super(str);
	 }
	
	public void run() {
		q.print(this.getName());
	}
	public static void main(String[] args) {
		q = new Q1();
		ThreadExampleNumberInSequence te1 = new ThreadExampleNumberInSequence("Thread 1");
		ThreadExampleNumberInSequence te2 = new ThreadExampleNumberInSequence("Thread 2");
		te1.start();
		te2.start();
	}
}
