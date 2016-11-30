package com.pranaya.java;

public class threadJoin extends Thread{
	public int count;
	public threadJoin(String Name){
		super(Name);
	}
	public void run() {
		for(int i=0;i<5;i++){
			System.out.println("Thread "+this.getName()+"goint to sleep for 1 sec");
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		threadJoin t1= new threadJoin(" 1");
		threadJoin t2= new threadJoin(" 2");
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}
}
