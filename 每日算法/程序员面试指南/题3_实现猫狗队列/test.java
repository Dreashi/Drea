package com.ck.queue.catanddog;

import java.util.Date;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CatDogQueue dcqueue = new CatDogQueue();
		for(int i=0;i<10;++i) {
			Pet pet = null;
			if(i%2==0) 
				pet = new Pet("cat");
			else
				pet = new Pet("dog");
			dcqueue.add(pet);
		}
		
		
		System.out.println(dcqueue.pollDog());
		
	}

}
