package com.hellojava.Demo;

public class GapGun implements Toy {  
	private String info; 
	public GapGun() 
	{ 			} 
	public GapGun(String info) { 
		super(); 
     this.info = info; 
     } 
	public String getInfo()
	{
		return info; 
		} 
	public void setInfo(String info) {
		this.info = info;  
		}   
	@Override   
	public void toyInfo() 
	{  
		System.out.println("Íæ¾ßÊÖÇ¹£º"+info);
		}  
	} 
