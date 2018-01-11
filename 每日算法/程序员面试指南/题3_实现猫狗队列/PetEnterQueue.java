package com.ck.queue.catanddog;

public class PetEnterQueue {
	private Pet pet;
	private int count;//加上一个时间戳，标记对象进入队列的时间
	public PetEnterQueue(Pet pet,int count) {
		super();
		this.pet = pet;
		this.count = count;
	}
	public Pet getPet() {
		return this.pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public String getEnterPetName() {
		return this.pet.getName();
	}
}
