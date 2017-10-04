package org.mihir.spring;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean,Shape
{

	/*private String type;
	private int height;
	
	public Triangle(String type) {
		this.type = type;
	}

	
	public Triangle(String type, int height) {
		this.type = type;
		this.height = height;
	}

	
	public Triangle(int height) {
		this.height = height;
	}


	public int getHeight() {
		return height;
	}


	public String getType() {
		return type;
	}*/


	/*public void setType(String type) {
		this.type = type;
	}*/


	/*public void draw() {
		System.out.println(getType() + " Triangle is draw of height " + getHeight());
	}*/
	
	//normal and autowiring examples.........
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	ApplicationContext context = null;
	
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	/*private List<Point> points; 
	
	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}*/

	

	public void draw() {
		System.out.println("PointA: [" + getPointA().getX() + "," + getPointA().getY() + "]");
		System.out.println("PointB: [" + getPointB().getX() + "," + getPointB().getY() + "]");
		System.out.println("PointC: [" + getPointC().getX() + "," + getPointC().getY() + "]");
	}
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		 this.context = context;
	}
	@Override
	public void setBeanName(String beanName) {
		System.out.println("Bean name is : " + beanName);
		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("init method call for Triangle ");
		
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy mehod call for Triangle");
		
	}
}
