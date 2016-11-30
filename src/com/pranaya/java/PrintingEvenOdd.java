package com.pranaya.java;

class Q2 {
	public static boolean state = true;
	public static int value = 1;
	public int oddSum=0;
	public int evenSum=0;
	public synchronized void print(String name) {
		//System.out.println("Going to call While loop");
		while (value < 10) {
			try {
				if (value % 2 == 0) {
					//System.out.println(name+" even  "+value);
					this.evenSum+=value;
					System.out.println("Even sum is :"+this.evenSum+"   value added:"+value);
					value++;
					notifyAll();
					wait(1000);
				}else{
					//System.out.println(name+" odd "+value);
					this.oddSum+=value;
					System.out.println("Odd sum is :"+this.oddSum+"   value added:"+value);
					value++;
					notifyAll();
					wait(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class PrintingEvenOdd {
	public static void main(String[] args) {
		Q2 q = new Q2();
		Thread t1 = new Thread(() -> {
			q.print("t1");
		});
		Thread t2 = new Thread(() -> {
			q.print("t2");
		});
		t1.setName("t1");
		t2.setName("t2");
		//System.out.println("before start");
		t1.start();
		t2.start();
		//System.out.println("before join");
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(q.evenSum +"     "+q.oddSum);
	}
}
