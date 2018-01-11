package com.ck.queue.catanddog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class CatDogQueue {
	private Queue<PetEnterQueue> catQ;
	private Queue<PetEnterQueue> dogQ;
	private int count;
	public CatDogQueue() {
		this.catQ = new LinkedList<PetEnterQueue>();
		this.dogQ = new LinkedList<PetEnterQueue>();
		this.count = 0;
	}
	
	public void add(Pet pet) {
		if(pet.getName().equals("dog")) {
			this.dogQ.add(new PetEnterQueue(pet, this.count++));
		}else if(pet.getName().equals("cat")) {
			this.catQ.add(new PetEnterQueue(pet,this.count++));
		}else {
			throw new RuntimeException("err,not dog or cat");
		}
	}
	
	public Pet pollAll(){
		if(!this.catQ.isEmpty() && !this.dogQ.isEmpty()) {
			if(this.dogQ.peek().getCount()<this.catQ.peek().getCount()) {
				return this.dogQ.poll().getPet();
			}else {
				return this.catQ.poll().getPet();
			}
		}else if(!this.catQ.isEmpty()) {
			return this.catQ.poll().getPet();
		}else if(!this.dogQ.isEmpty()) {
			return this.dogQ.poll().getPet();
		}else {
			throw new RuntimeException("Queue is empty");
		}
	}
	
	public Pet pollCat() {
		if(!this.isCatQEmpty()) {
			return  this.catQ.poll().getPet();
		}else {
			throw new RuntimeException("Cat queue is empty");
		}

	}
	
	public Pet pollDog() {
		if(!this.isDogQEmpty()) {
			return  this.dogQ.poll().getPet();
		}else {
			throw new RuntimeException("Dog queue is empty");
		}

	}
	public boolean isEmpty(){
		return this.dogQ.isEmpty() && this.catQ.isEmpty();
	}
	
	public boolean isCatQEmpty() {
		return this.catQ.isEmpty();
	}
	public boolean isDogQEmpty() {
		return this.dogQ.isEmpty();
	}
	
}
