package org.mihir.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape, ApplicationEventPublisherAware {
 
	private Point center;
	private ApplicationEventPublisher publisher;
	@Autowired
	private MessageSource messageSource;
	
	public Point getCenter() {
		return center;
	}

	//@Required
	//@Autowired
	//@Qualifier("circleRelated")
	//Now JSR-250 annotation demo
	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
	}

	public void draw() {
		System.out.println("Circle Point is (" + center.getX() + "," + center.getY() + ")");
		System.out.println(this.messageSource.getMessage("greeting", null, "default greeting", null));
		System.out.println(this.messageSource.getMessage("drawing.point", new Object[] {center.getX(), center.getY()}, "default point message", null));
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
	}
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@PostConstruct
	public void initializeCircle() {
		System.out.println("init of the circle");
	}
	
	@PreDestroy
	public void destroyCircle() {
		System.out.println("destroy of the circle");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		// TODO Auto-generated method stub
		this.publisher =  publisher;
	}
}
