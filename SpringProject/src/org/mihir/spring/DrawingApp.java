package org.mihir.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//AbstractApplicationContext abstractContext = new ClassPathXmlApplicationContext("spring.xml");
		//abstractContext.registerShutdownHook();
		/*Triangle triangle = (Triangle)abstractContext.getBean("triangle");
		Circle circle = (Circle) abstractContext.getBean("circle");
		Triangle triangle = (Triangle)context.getBean("triangle-alias");  // When using alias in bean injection (xml)
		triangle.draw();	
		circle.draw();*/
		
		Shape shape = (Shape) context.getBean("circle");
		shape.draw();
		//System.out.println(context.getMessage("greeting", null, "default greeting", null));
	}

}
   