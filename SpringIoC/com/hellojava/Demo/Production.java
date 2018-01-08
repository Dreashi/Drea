package com.hellojava.Demo;

import javax.annotation.Resource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class Production { 
	public static void main(String[] args) {	
		BeanFactory factory = new ClassPathXmlApplicationContext("Spring.xml");
		Toy toy = (Toy) factory.getBean("toy"); 
		toy.toyInfo();  
		} 
	}
